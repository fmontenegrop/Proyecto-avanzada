
package dto;

import java.io.Serializable;
import java.sql.Date;

public class Registro_DTO implements Serializable{
    private int id;
    private Date fecha;
    private int codigo_e;
    private int id_c;

    public Registro_DTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodigo_e() {
        return codigo_e;
    }

    public void setCodigo_e(int codigo_e) {
        this.codigo_e = codigo_e;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public Registro_DTO(Date fecha, int codigo_e, int id_c) {
        this.fecha = fecha;
        this.codigo_e = codigo_e;
        this.id_c = id_c;
    }

    public Registro_DTO(int id, Date fecha, int codigo_e, int id_c) {
        this.id = id;
        this.fecha = fecha;
        this.codigo_e = codigo_e;
        this.id_c = id_c;
    }
}
