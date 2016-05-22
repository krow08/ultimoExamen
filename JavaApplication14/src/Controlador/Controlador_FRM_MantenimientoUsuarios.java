/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import Modelo.ArchivoUsuario;
import Modelo.MetodoUsuario;
import Vista.FRM_MantenimientoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador_FRM_MantenimientoUsuarios implements ActionListener {

   public MetodoUsuario metodos;
    FRM_MantenimientoUsuario mantenimientoUsuario;
    ArchivoUsuario archivo;
      Controlador_FRM_FuenteInformacion fuente;
    public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuario mantenimientoUsuario)
    {
        this.mantenimientoUsuario=mantenimientoUsuario;
        metodos = new MetodoUsuario();
        archivo=new ArchivoUsuario();
        if(archivo.cargarArchivoUsuario()){
        metodos.setArray(archivo.devolverInformacionDeUsuario());
        
        }
         else
        {   
         
         archivo.crearArchivoUsuario();  
         
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Consultar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
            buscar();
            }
        }
       
        if(e.getActionCommand().equals("Agregar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
            metodos.agregarUsuario(mantenimientoUsuario.devolverInformacion());
            metodos.mostrarInformacion();     
            metodos.mensaje("El Usuario  ha sido agregado exitosamente");
            mantenimientoUsuario.posicionInicial();
        }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
           metodos.modificarUsuario(mantenimientoUsuario.devolverInformacion());
           metodos.mensaje("Los datos han sido modificados exitosamente");
           mantenimientoUsuario.desabilirAgregar();
           mantenimientoUsuario.posicionInicial();
            }
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
            metodos.eliminarUsuario(mantenimientoUsuario.devolverInformacion());
            metodos.mensaje("El usuario ha sido eliminado exitosamente");
            mantenimientoUsuario.desabilirAgregar();
            mantenimientoUsuario.posicionInicial();
            }
        }
    
    }
    
    public void guardarArchivos()
    {
        archivo.crearArchivoUsuario();
        for(int contador=0; contador<metodos.getTamano();contador++)
        {
            
        archivo.ingresarInformacionUsuario(metodos.get(contador));
          
        }
        
    }
    public void buscar()
    {
            if(metodos.consultarUsuario(mantenimientoUsuario.devolverNombreUsuario()))
            {
                mantenimientoUsuario.mostrarInformacion(metodos.getArregloInformacion());
                mantenimientoUsuario.habilirModificar();
                mantenimientoUsuario.habilirEliminar();
            }
            else
            {
                metodos.mensaje("El Usuario consultado no se encontró");
                mantenimientoUsuario.habilirAgregar();
            }
    }
    
   
    
}
