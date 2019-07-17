
package dto;

import java.io.Serializable;

public class Profesor_DTO implements Serializable{
    private int codigo;
    private String nombre;
    private int cc;
    private int clave;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Profesor_DTO(String nombre, int clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public Profesor_DTO() {
    }

    public Profesor_DTO(int codigo, String nombre, int cc, int clave) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cc = cc;
        this.clave = clave;
    }
}
