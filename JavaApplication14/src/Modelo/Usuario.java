/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;


public class Usuario implements Serializable{
    
    private String nombre;
    private String nombreUsuario;
    private String contraseña;
    private int tipo;

    public Usuario(String nombre, String nombreUsuario, String contraseña, int tipo) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

   
    public String getInformacion()
    {
        return "Nombre" +nombre+ "Nombre de Usuario" +nombreUsuario+ "contraseña" +contraseña;
    }
}
