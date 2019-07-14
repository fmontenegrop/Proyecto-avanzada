package dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;


public class PersonaDTO implements Serializable{

    public PersonaDTO() {
    }
    
     private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private int clave;
    private int cc;

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public PersonaDTO(int id, String nombre, String apellido, String correo, int clave, int cc) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave= clave;
        this.cc=cc;
    }

    public PersonaDTO(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
}
