/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MetodoUsuario {
    
    private ArrayList <Usuario> arrayUsuarios;
    String arregloInformacionConsultada[];
    
    public MetodoUsuario()
    {
        arrayUsuarios=new ArrayList <Usuario>();
        arregloInformacionConsultada=new String[3];
    }
     public void setArray(ArrayList<Usuario> array){
        arrayUsuarios=array;
    }
    
    
     public ArrayList<Usuario> getArray(){
       return arrayUsuarios;
    }
     
     public int getTamano(){
         return arrayUsuarios.size();
     }
     
     public Usuario get(int numero){
         return arrayUsuarios.get(numero);
     }
   
    public void agregarUsuario(String informacion[])
    {
    Usuario temporal=new Usuario(informacion[0],informacion[1],informacion[2],Integer.parseInt(informacion[3]));  
    arrayUsuarios.add(temporal);
    }
    
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            System.out.println(arrayUsuarios.get(contador).getInformacion());
        
        }
    
    }
    public boolean consultarUsuario(String nombreUsuario)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(nombreUsuario))
            {
                arregloInformacionConsultada[0]=arrayUsuarios.get(contador).getNombre();
                arregloInformacionConsultada[1]=arrayUsuarios.get(contador).getContraseña();
                arregloInformacionConsultada[2]=""+arrayUsuarios.get(contador).getTipo();
                existe=true;
            }
        
        }
        return existe;
    
    }
    
    
    public void modificarUsuario(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(arreglo[1]))
            {
                arrayUsuarios.get(contador).setNombre(arreglo[0]);
                arrayUsuarios.get(contador).setNombreUsuario(arreglo[2]);
                arrayUsuarios.get(contador).setNombreUsuario(arreglo[3]);
            }
        }
    }
    public void eliminarUsuario(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(arreglo[1]))
            {
                arrayUsuarios.remove(contador);
            }
        }
    }
    
    
    public void mensaje(String mensaje)
    {
       JOptionPane.showMessageDialog(null,mensaje);
    }
    
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }
}
