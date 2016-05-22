/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoMatricula;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Modelo.MetodosMatricula;
import Vista.FRM_FuenteInformacion;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_Matricula implements ActionListener{
    
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    MetodosMatricula metodosMatricula;
    FRM_Matricula frm_Matricula;
    FRM_FuenteInformacion fuenteInfo;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    ArchivoMatricula archivo;
    
    
   
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes mantenimientoEstudiantes,FRM_MantenimientoCursos mantenimientoCursos,FRM_Matricula frm_Matricula)
    {
        this.metodosCursos=mantenimientoCursos.controlador.metodos;
        this.metodosEstudiantes=mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodos;
        this.frm_Matricula=frm_Matricula;
        metodosMatricula=new MetodosMatricula();
        archivo=new ArchivoMatricula();
        frm_Matricula.numeroCodigo(metodosMatricula.devolverCodigo());
        
        if(archivo.cargarArchivoMatricula()){
     metodosMatricula.setArray(archivo.devolverInformacionDeMatricula());
     }
     else
     {
         archivo.crearArchivoMatricula();
         
     }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ConsultaRapidaEstudiante"))
        {
            if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
            {
                String arreglo[]=metodosEstudiantes.getArregloInformacion();
                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                encontroEstudiante=true;     
            }
            else
            {
            frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra, favor dirigirse al modulo mantenimiento estudiantes");
            }
        }
        if(e.getActionCommand().equals("ConsultaRapidaCurso"))
        {
            if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla()))
            {
                String arreglo[]=metodosCursos.getArregloInformacion();
                frm_Matricula.mostrarNombreCurso(arreglo[0]);
                encontroCurso=true;      
            }
            else
            {
              frm_Matricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al modulo mantenimiento curso");  
            }
        }
        if(e.getActionCommand().equals("Consultar"))
        {
           buscar();
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            frm_Matricula.cargarTabla();
            encontroCurso=false;
            frm_Matricula.estadoInicial();
            frm_Matricula.limpiarCurso();
        }
          if(e.getActionCommand().equals("FinalizarMatricula"))
         {
           for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
            {
                metodosMatricula.agregarMatricula(frm_Matricula.getInformacionTabla(contador));
            }
            frm_Matricula.resetearInterfaz();
            metodosMatricula.mostrarInformacion();
            
         }
        
        if(encontroEstudiante && encontroCurso)
        {
            frm_Matricula.habilitarAgregar();
        }
         if(e.getActionCommand().equals("Eliminar"))
        {
            metodosMatricula.eliminarMatricula(frm_Matricula.devolverInformacion());
            metodosMatricula.mostrarMensaje("La matricula se borro efectivamente");
            frm_Matricula.resetearInterfaz();
            frm_Matricula.habilitarAgregar();
            frm_Matricula.numeroCodigo(metodosMatricula.devolverCodigo());
        }
    }
    public void guardarArchivos()
    {
        archivo.crearArchivoMatricula();
        for(int contador=0; contador<metodosMatricula.getTamano();contador++)
        {
            
        archivo.ingresarInformacionMatricula(metodosMatricula.get(contador));
          
        }
        
    }
    public String colocarCodigo()
    {
        return metodosMatricula.devolverCodigo();
    }
    public void buscar()
    {
         if(metodosMatricula.consultarMatricula(frm_Matricula.devolverCodigo()))
            {
               frm_Matricula.mostrarInformacion(metodosMatricula.getArregloInformacion());
               frm_Matricula.mostrarNombreEstudiante(metodosEstudiantes.consultarNombreEstudiantes(frm_Matricula.devolverCedula()));
               frm_Matricula.mostrarNombreCurso(metodosCursos.consultarNombreCurso(frm_Matricula.devolverSigla()));
               frm_Matricula.cargarTabla();
               frm_Matricula.habilitarEliminar();
               frm_Matricula.deshabulitarAgregar();
               
               
            }
            else
            {
                metodosMatricula.mostrarMensaje("El estudiante consultado no se encontró");
                frm_Matricula.habilitarAgregar();
                frm_Matricula.numeroCodigo(metodosMatricula.devolverCodigo());
            } 
    }
}
