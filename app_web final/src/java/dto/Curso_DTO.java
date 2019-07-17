
package dto;

import java.io.Serializable;

public class Curso_DTO implements Serializable{
    private int id;
    private String nombre;
    private int codigo_profesor;

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

    public int getCodigo_profesor() {
        return codigo_profesor;
    }

    public void setCodigo_profesor(int codigo_profesor) {
        this.codigo_profesor = codigo_profesor;
    }

    public Curso_DTO(String nombre, int codigo_profesor) {
        this.nombre = nombre;
        this.codigo_profesor = codigo_profesor;
    }

    public Curso_DTO(int id, String nombre, int codigo_profesor) {
        this.id = id;
        this.nombre = nombre;
        this.codigo_profesor = codigo_profesor;
    }
}
