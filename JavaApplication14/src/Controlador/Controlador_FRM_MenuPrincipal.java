/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.FRM_FuenteInformacion;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_MantenimientoLogin;
import Vista.FRM_MantenimientoUsuario;
import Vista.FRM_Matricula;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MenuPrincipal implements ActionListener{
    
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    FRM_MantenimientoCursos mantenimientoCursos;
    FRM_Matricula matricula;
    FRM_MantenimientoUsuario usurio;
    FRM_FuenteInformacion fuenteInfo;
    FRM_MantenimientoLogin Login;
    FRM_MenuPrincipal menu;
    
    
    public Controlador_FRM_MenuPrincipal(FRM_MenuPrincipal frm_MenuPrincipal)
    {
        mantenimientoEstudiantes=new FRM_MantenimientoEstudiantes();
        mantenimientoCursos=new FRM_MantenimientoCursos();
        matricula= new FRM_Matricula(mantenimientoEstudiantes,mantenimientoCursos);
        usurio= new FRM_MantenimientoUsuario();
        Login=new FRM_MantenimientoLogin(frm_MenuPrincipal);
        //visible();
        //fuenteInfo.setVisible(true);
        fuenteInfo=new FRM_FuenteInformacion(frm_MenuPrincipal);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);        
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            this.mantenimientoEstudiantes.setVisible(true);
            
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            this.mantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            this.matricula.setVisible(true);
            this.matricula.colocarCodigo();
        }
        if(e.getActionCommand().equals("Usuario"))
        {
            this.usurio.setVisible(true);
        }
    
    }   
    
}
