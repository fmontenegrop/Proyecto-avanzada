
package dto;

import java.io.Serializable;

public class Notas_DTO implements Serializable{
    private int id;
    private int id_r;
    private int cod_profesor;
    private int nota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_r() {
        return id_r;
    }

    public void setId_r(int id_r) {
        this.id_r = id_r;
    }

    public int getCod_profesor() {
        return cod_profesor;
    }

    public void setCod_profesor(int cod_profesor) {
        this.cod_profesor = cod_profesor;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Notas_DTO(int id_r, int cod_profesor, int nota) {
        this.id_r = id_r;
        this.cod_profesor = cod_profesor;
        this.nota = nota;
    }

    public Notas_DTO(int id, int id_r, int cod_profesor, int nota) {
        this.id = id;
        this.id_r = id_r;
        this.cod_profesor = cod_profesor;
        this.nota = nota;
    }
    
    
}
