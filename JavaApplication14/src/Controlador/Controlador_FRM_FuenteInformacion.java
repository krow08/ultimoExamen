/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoUsuario;
import Vista.FRM_FuenteInformacion;
import Vista.FRM_MantenimientoLogin;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author altna
 */
public class Controlador_FRM_FuenteInformacion implements ActionListener {
    FRM_FuenteInformacion fuenteInfo;
    FRM_MenuPrincipal menu;
    Controlador_FRM_MenuPrincipal controladorMenu;
    FRM_MantenimientoLogin Login;
    public int eleccion=0;
    ArchivoUsuario archivo;
    
   
    public Controlador_FRM_FuenteInformacion(FRM_FuenteInformacion fuenteInfo, FRM_MenuPrincipal frm_MenuPrincipal)
    {
       this.fuenteInfo=fuenteInfo;
       Login=new FRM_MantenimientoLogin(frm_MenuPrincipal);
       
       //visible();
    }
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("Aceptar"))
        {
            Login.setVisible(true);
            if(this.fuenteInfo.archivosPlanosSeleccionados())
            {
             //   if(devolverUsuario())
             //   {
                    Login.setVisible(true);
                    eleccion=1;
                    System.out.println("archivoPlanos");
              //  }
            }
            if(this.fuenteInfo.basesDeDatosSeleccionados())
            {
                eleccion=2;
                System.out.println("BaseDeDatos");
            }
            if(this.fuenteInfo.xMLSeleccionados())
            {
                eleccion=3;
                System.out.println("XML");
            }
            
            //En el caso de que se selecciones dos o mas opciones;
            
            if(this.fuenteInfo.xMLSeleccionados()&&this.fuenteInfo.basesDeDatosSeleccionados()&&this.fuenteInfo.archivosPlanosSeleccionados()
             ||this.fuenteInfo.xMLSeleccionados()&&this.fuenteInfo.basesDeDatosSeleccionados()||this.fuenteInfo.xMLSeleccionados()&&this.fuenteInfo.archivosPlanosSeleccionados()
             ||this.fuenteInfo.basesDeDatosSeleccionados()&&this.fuenteInfo.archivosPlanosSeleccionados())
            {
                System.out.println("Se pueden seleccionar solo una opcion a la vez");
            }
            
            fuenteInfo.setVisible(false);
        }
    
        if(e.getActionCommand().equals("Salir"))
        {
           System.exit(0);
        }
    }
   public int devolverEleccion()
   {
       return eleccion;
   }
   public boolean devolverUsuario()
   {
       boolean usuario=false;
       for(int contador=0;contador==archivo.devolverInformacionDeUsuario().size();contador++)
       {
           if (contador>0)
           {
               usuario=true;
           }
           else
           {
               usuario=false;
           }
       }
       return usuario;
   }
}
