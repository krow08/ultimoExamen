/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodosPersonas;
import Modelo.Personas;
import Vista.FRM_VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author altna
 */
public class Controlador_FRM_VentanaPrincipal implements ActionListener{
    MetodosPersonas metodos;
    FRM_VentanaPrincipal ventana;
    Personas persona;
    public boolean registrarse=false;
    public boolean modificar=false;
    int cedula=0;
    public Controlador_FRM_VentanaPrincipal(FRM_VentanaPrincipal ventana)
    {
        this.ventana=ventana;
        metodos=new MetodosPersonas();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Registrar"))
        {
            String[] arreglo=ventana.devolverInfo();
                            //String nombre, int edad, int cedula, Personas siguiente, int numeroCita, String fecha, String tipo
          metodos.crear(arreglo[0],Integer.parseInt(arreglo[1]),Integer.parseInt(arreglo[2]),null,Integer.parseInt(arreglo[3]),arreglo[4],arreglo[5]);
          registrarse=true;
          ventana.generarNumeroFicha(registrarse);
          ventana.limpiarCampos();
          modificar=false;
            System.out.println("Registrar");
        }
        if(e.getActionCommand().equals("Llamar"))
        {
            ventana.imprimir(metodos.imprimir());
            System.out.println("llamar");
        }
        
        if(e.getActionCommand().equals("Eliminar"))
        {
            cedula=Integer.parseInt(JOptionPane.showInputDialog("ingrese su cedula"));
            metodos.eliminar(cedula);
            System.out.println("Eliminar");
        }
        
        if(e.getActionCommand().equals("Modificar"))
        {
            if (modificar==false)
            {
            cedula=Integer.parseInt(JOptionPane.showInputDialog("ingrese su cedula"));
            modificar=true;
            ventana.bloquearCedula();
            ventana.setCedula(cedula);
            JOptionPane.showMessageDialog(null, "ingrese los datos");
            
            }
            else{
            String[] arreglo=ventana.devolverInfo();
             //String nombre, int edad, int cedula, Personas siguiente, int numeroCita, String fecha, String tipo
            metodos.modificar(cedula,arreglo[1],Integer.parseInt(arreglo[2]),arreglo[4],arreglo[5]);
            ventana.limpiarCampos();
            modificar=false;
            }
            System.out.println("Modificar");
        }
        
        if(e.getActionCommand().equals(">"))
        {
            metodos.ordenarMayorMenor();
            System.out.println("Ordenar>");
        }
        
        if(e.getActionCommand().equals("mostrarTodos"))
        {
            ventana.imprimir(metodos.imprimirTodos());
            System.out.println("mostrarTodos");
        }
    }
}
