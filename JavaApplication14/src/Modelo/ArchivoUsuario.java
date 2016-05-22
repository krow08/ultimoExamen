/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ArchivoUsuario 
{


       ObjectOutputStream archivoSalida;
       ObjectInputStream archivoEntrada;
       
       public ArchivoUsuario()
       {
          if(cargarArchivoUsuario())
        {
         System.out.println("El archivo se cargó correctamente");   
        }
        else
        {
          System.out.println("Error al cargar archivo");  
        }
       }

       public void crearArchivoUsuario()
            {
                try{       
                archivoSalida=new ObjectOutputStream(new FileOutputStream("archivoUsuario.dat"));
                System.out.println("Se creó el archivo de Usuario de forma correcta");
                }
                catch(Exception e)
                {
                 System.out.println("Error al crear archivo Usuario"+e);
                }

            }
       
       public void ingresarInformacionUsuario(Usuario usuario)
        {
         try
         {
             archivoSalida.writeObject(usuario);
             System.out.println("Se escribió de forma correcta la información del archivoUsuario");
         }
         catch(Exception e)
         {
             System.out.println("Error al ingresar información al archivoUsuario"+e);
         }
        }
       
        public boolean cargarArchivoUsuario()
                {
                    boolean existe=false;
                    try{           

                    archivoEntrada=new ObjectInputStream(new FileInputStream("archivoUsuario.dat"));
                    existe=true;
                    
                            }
                    catch(Exception e)
                    {
                        System.out.println("Error al cargar archivo usuario"+e);
                    }
                    return existe;
                }
        
        
        public ArrayList<Usuario> devolverInformacionDeUsuario()
        {
            ArrayList <Usuario> arrayUsuario=new ArrayList<Usuario>();
            
            try
            {
              while(true)
              {
                  arrayUsuario.add((Usuario)archivoEntrada.readObject());
              }
            }
            catch(Exception e)
            {
                System.out.println("Se llegó al final del archivo usuario");
            }
            
            return arrayUsuario;
        }
        
       
   }
   

