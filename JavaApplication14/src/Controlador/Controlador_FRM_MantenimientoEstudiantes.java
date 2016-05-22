/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoEstudiantes;
import Modelo.MetodosEstudiantes;
import Vista.FRM_MantenimientoEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosXML_Estudiantes;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    
    public MetodosEstudiantes metodos;
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    ArchivoEstudiantes archivo;
    Controlador_FRM_FuenteInformacion fuente;
    MetodosXML_Estudiantes metodosXML;
    FRM_MantenimientoEstudiantes ventana;
     public int seleccion;
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes mantenimientoEstudiantes)
    {
       
        metodosXML=new MetodosXML_Estudiantes(ventana);
        this.mantenimientoEstudiantes=mantenimientoEstudiantes;
        metodos = new MetodosEstudiantes();
        mantenimientoEstudiantes.estadoInicial();
        archivo=new ArchivoEstudiantes();
        if(archivo.cargarArchivoEstudiantes()){
     metodos.setArray(archivo.devolverInformacionDeEstudiantes());
     }
     else
     {
         archivo.crearArchivoEstudiantes();         
     }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        seleccion=fuente.devolverEleccion();
        System.out.println(seleccion);
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("ConsultaRapida"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
                buscarArchivos();
            }
            if(this.fuente.devolverEleccion()==2)
            {
                if(metodosXML.consultarInformacionDelXml(ventana.devolverCedula()))
                {
                    ventana.mostrarMensaje("No se encontró información con la cédula: "+ventana.devolverCedula());
                    ventana.habilirAgregar();
                }
                else
                {
                    ventana.mostrarInformacion(metodosXML.getArregloInformacion());
                    ventana.habilitarOpciones();
                    
                    ventana.mostrarMensaje("Información encontrada con la cédula : "+ventana.devolverCedula());
        }   
        ventana.deshabilitarCedula();
            }
        }
       
        if(e.getActionCommand().equals("Agregar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
            metodos.agregarEstudiante(mantenimientoEstudiantes.devolverInformacion());
            metodos.mostrarInformacion();     
            metodos.mensaje("El estudiante ha sido agregado exitosamente");
            mantenimientoEstudiantes.posicionInicial();
            }
            if(this.fuente.devolverEleccion()==2)
            {
              metodosXML.guardarEnXML(ventana.devolverInformacion());
            ventana.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
            ventana.limpiarInterfaz();
            ventana.estadoInicial();
            }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
           metodos.modificarEstudiante(mantenimientoEstudiantes.devolverInformacion());
           metodos.mensaje("Los datos han sido modificados exitosamente");
           mantenimientoEstudiantes.desabilirAgregar();
           mantenimientoEstudiantes.posicionInicial();
            }
            if(this.fuente.devolverEleccion()==2)
            {
                metodosXML.modificarInformacionDelXml(ventana.devolverInformacion());
            ventana.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");
            ventana.limpiarInterfaz();
            ventana.estadoInicial();
            }
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
            metodos.eliminarEstudiante(mantenimientoEstudiantes.devolverInformacion());
            metodos.mensaje("El estudiante ha sido eliminado exitosamente");
            mantenimientoEstudiantes.desabilirAgregar();
            mantenimientoEstudiantes.posicionInicial();
            }
            if(this.fuente.devolverEleccion()==2)
            {
                metodosXML.eliminarInformacionDelXml(ventana.devolverCedula());
            ventana.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");
            ventana.limpiarInterfaz();
            ventana.estadoInicial();
            }
        }
    
    }
    
    public void guardarArchivos()
    {
        archivo.crearArchivoEstudiantes();
        for(int contador=0; contador<metodos.getTamano();contador++)
        {
            
        archivo.ingresarInformacionEstudiantes(metodos.get(contador));
          
        }
        
    }
    public void buscarArchivos()
    {
            if(metodos.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
                mantenimientoEstudiantes.habilirModificar();
                mantenimientoEstudiantes.habilirEliminar();
            }
            else
            {
                metodos.mensaje("El estudiante consultado no se encontró");
                mantenimientoEstudiantes.habilirAgregar();
            }
    }
    public void buscarXML()
    {
         if(metodosXML.consultarInformacionDelXml(ventana.devolverCedula()))
        {
            ventana.mostrarInformacion(metodosXML.getArregloInformacion());
            ventana.habilitarOpciones();
            ventana.mostrarMensaje("Información encontrada con la cédula : "+ventana.devolverCedula());
        }
        else
        {
            ventana.mostrarMensaje("No se encontró información con la cédula: "+ventana.devolverCedula());
            ventana.habilirAgregar();
        }   
        ventana.deshabilitarCedula();
    }
}
