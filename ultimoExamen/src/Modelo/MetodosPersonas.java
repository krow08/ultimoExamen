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
public class MetodosPersonas {
 
    Personas principal;
    public MetodosPersonas()
    {
        
    }
    
    public void crear(String nombre, int edad, int cedula, Personas siguiente, int numeroCita, String fecha, String tipo)
    {
        if(principal==null)
        {
             principal=new Personas(nombre, edad, cedula, null, numeroCita, fecha, tipo);
        }
        else
        {
            if(tipo.equals("Normal"))
            {
                Personas temporal=devolverUltimaPersona();
                temporal.setSiguiente(new Personas(nombre, edad, cedula, null, numeroCita, fecha, tipo));
            }
            else
            {
                Personas aux;
                aux=new Personas(nombre, edad, cedula, null, numeroCita, fecha, tipo);
                aux.setSiguiente(principal);
                principal=aux;
            }
        }
    }
   
    public Personas devolverUltimaPersona()
    {
        Personas temporal=principal;
        while(temporal.getSiguiente()!=null)
        {
          temporal=temporal.getSiguiente();
        }
        return temporal;
    }
    
    public String imprimir(){
        String valores="";
        if (principal==null)
        {
            valores="no hay ninguna cita";
        }
        else{
        Personas temporal=principal;
        while( temporal.getSiguiente()!=null){
        valores=temporal.getNombre()+" Cita: "+temporal.getNumeroCita()+"\n";
        System.out.println(temporal.getNombre()+"Cita: "+temporal.getNumeroCita()+"\n");
        temporal=temporal.getSiguiente();
    }
        valores=temporal.getNombre()+" Cita: "+temporal.getNumeroCita()+"\n";
        eliminar(temporal.getCedula());
    }
        return valores;  
        
    }
    public void eliminar(int cedula)
    {
        Personas auxiliar=principal;
        boolean haEliminado=false;
        if(auxiliar.cedula==cedula)
        {
            principal=principal.siguiente;
            haEliminado=true;
        }
        else
        {
            auxiliar=devolverUltimaPersona();
            if(auxiliar.cedula==cedula)
            {
                auxiliar=devolverAntepenultimaPersona();
                auxiliar.siguiente=null;
                haEliminado=true;
            }
        }
        if(!haEliminado)
        {
            Personas temporal;
            auxiliar=devolverPersonaAnterior(cedula);
            temporal=auxiliar.siguiente.siguiente;
            auxiliar.siguiente=temporal;
        }
    }
    public Personas devolverPersonaAnterior(int datoBuscar)
    {
        Personas auxiliar=principal;
        while(auxiliar.siguiente.cedula!=datoBuscar)
        {
            auxiliar=auxiliar.siguiente;
        }
        return auxiliar;
    }
    
    public Personas devolverAntepenultimaPersona()
    {
        Personas auxiliar=principal;
        while(auxiliar.siguiente.siguiente!=null)
        {
            auxiliar=auxiliar.siguiente;
        }
        return auxiliar;
    }
    //String nombre, int edad, int cedula, Personas siguiente, int numeroCita, String fecha, String tipo
    public void modificar(int cedula, String nombre,int edad, String fecha, String tipo)
    {
        Personas auxiliar;
        auxiliar=buscarNodo(cedula);
        auxiliar.nombre=nombre;
        auxiliar.edad=edad;
        auxiliar.fecha=fecha;
        auxiliar.tipo=tipo;
    }
    
    public Personas buscarNodo(int cedula)
    {
        Personas auxiliar=principal;
        while(auxiliar.cedula!=cedula)
        {
            auxiliar=auxiliar.siguiente;
        }
        return auxiliar;
    }
    
    public void ordenarMayorMenor()
    {
        int cantidadNodos=devolverCantidadPersonas();
        int datoTemporal;
        Personas auxiliar=principal;
        for(int contador=0;contador<cantidadNodos;contador++)
        {
            auxiliar=principal;
            while(auxiliar.getSiguiente()!=null)
            {
                if(auxiliar.getEdad()<auxiliar.getSiguiente().getEdad())
                {
                    datoTemporal=auxiliar.getEdad();
                    auxiliar.edad=auxiliar.getSiguiente().getEdad();
                    auxiliar.getSiguiente().edad=datoTemporal;
                }
                auxiliar=auxiliar.getSiguiente();
            }
        }
    }
    
    public int devolverCantidadPersonas()
    {
        int contador=1;
        Personas auxiliar=principal;
        while(auxiliar.siguiente!=null)
        {
            contador++;
            auxiliar=auxiliar.siguiente;
        }
        
        return contador;
    }
    
    public String imprimirTodos()
    {
        String valores="";
        if (principal==null)
        {
            valores="no hay ninguna cita";
        }
        else{
        Personas temporal=principal;
        while( temporal.getSiguiente()!=null){
        valores+=temporal.getNombre()+" Cita: "+temporal.getNumeroCita()+"\n";
        System.out.println(temporal.getNombre()+"Cita: "+temporal.getNumeroCita()+"\n");
        temporal=temporal.getSiguiente();
    }
        valores+=temporal.getNombre()+" Cita: "+temporal.getNumeroCita()+"\n";
    }
        return valores;  
    }
}