/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoCursos;
import Modelo.MetodosCursos;
import Modelo.MetodosXML_Cursos;
import Vista.FRM_MantenimientoCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    public MetodosCursos metodos;
    ArchivoCursos archivo;
      Controlador_FRM_FuenteInformacion fuente;
      MetodosXML_Cursos metodosXML;
      FRM_MantenimientoCursos ventana;
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos)
    {
        this.frm_MantenimientoCursos= frm_MantenimientoCursos;
        metodos = new MetodosCursos();
        frm_MantenimientoCursos.estadoInicial();
        archivo=new ArchivoCursos();
        metodosXML=new MetodosXML_Cursos(ventana);
        if(archivo.cargarArchivoCursos()){
     metodos.setArray(archivo.devolverInformacionDeCursos());
     }
     else
     {
         archivo.crearArchivoCursos();
         
     }
    } 
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
            metodos.agregarCurso(frm_MantenimientoCursos.devolverInformacion());
            metodos.mensaje("El curso ha sido registrado con éxito");
            frm_MantenimientoCursos.limpiarCampos();
            frm_MantenimientoCursos.estadoInicial();
            }
            if(this.fuente.devolverEleccion()==2)
            {
                metodosXML.guardarEnXML(ventana.devolverInformacion());
            ventana.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
            ventana.limpiarInterfaz();
            ventana.estadoInicial();
            }
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
            if(metodos.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodos.getArregloInformacion());
                frm_MantenimientoCursos.habilitarModificar();
                frm_MantenimientoCursos.habilirEliminar();
            }
            else
            {
                metodos.mensaje("No se encontro el curso");
                frm_MantenimientoCursos.habilitarAgregar();
            }
            }
            if(this.fuente.devolverEleccion()==2)
            {
                if(metodosXML.consultarInformacionDelXml(ventana.devolverSigla()))
        {
            ventana.mostrarInformacion(metodos.getArregloInformacion());
            ventana.habilitarOpciones();
            
            ventana.mostrarMensaje("Información encontrada con la cédula : "+ventana.devolverSigla());
        }
        else
        {
            ventana.mostrarMensaje("No se encontró información con la cédula: "+ventana.devolverSigla());
            ventana.habilitarAgregar();
        }   
        ventana.deshabilitarSigla();
            }
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
            metodos.eliminarCurso(frm_MantenimientoCursos.devolverInformacion());
            metodos.mensaje("El curso ha sido eliminado con éxito");
            frm_MantenimientoCursos.posicionInicial();
            }
            if(this.fuente.devolverEleccion()==2)
            {
                metodosXML.eliminarInformacionDelXml(ventana.devolverSigla());
            ventana.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");
            ventana.limpiarInterfaz();
            ventana.estadoInicial();
            }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(this.fuente.devolverEleccion()==1)
            {
           metodos.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
           metodos.mensaje("Los datos han sido modificados exitosamente");
           frm_MantenimientoCursos.limpiarCampos();
           frm_MantenimientoCursos.deshabilitarAgregar(); 
            }
            if(this.fuente.devolverEleccion()==2)
            {
                metodosXML.modificarInformacionDelXml(ventana.devolverInformacion());
            ventana.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");
            ventana.limpiarInterfaz();
            ventana.estadoInicial();
            }
        }
    }
    public void guardarArchivos()
    {
          archivo.crearArchivoCursos();
          for(int contador=0; contador<metodos.getTamano();contador++){
          archivo.ingresarInformacionCursos(metodos.get(contador));
           }
    }
}
