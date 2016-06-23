/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author altna
 */
public class Personas {
    
    public int edad=0;
    public String nombre="";
    public int cedula=0;
    public int numeroCita=0;
    public String fecha="";
    Personas siguiente;
    public String tipo;
    
        public Personas(String nombre, int edad, int cedula, Personas siguiente, int numeroCita, String fecha, String tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.siguiente=siguiente;
        this.numeroCita=numeroCita;
        this.fecha=fecha;
        this.tipo=tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Personas getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Personas siguiente) {
        this.siguiente = siguiente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
