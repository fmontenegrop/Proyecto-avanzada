package dao;

import conexion.Conexion_1;
import conexion.ConexionBD;
import dto.PersonaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

public class Persona_DAO {

    public List<PersonaDTO> getPersonas() {

        List<PersonaDTO> list = null;
        String sql = "select id, nombre, apellido, correo from persona";
        Connection com = Conexion_1.obtener();
        if (com != null) {
            PreparedStatement psmt;
            try {
                psmt = com.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                   // PersonaDTO obj = new PersonaDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"));
                    //list.add(obj);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Persona_DAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

            }
        } else {
            System.out.println("conexion nula");
        }
        return list;

    }

    ;
    
    public List<PersonaDTO> buscarPersona(int idPersona) {

        List<PersonaDTO> list = null;
        String sql = "select id, nombre, apellidos, correo from persona";
        Connection com = Conexion_1.obtener();

        if (com != null) {
            PreparedStatement psmt;
            try {
                psmt = com.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                list = new ArrayList<>();
                while (rs.next()) {
                    if (idPersona == rs.getInt("id")) {
                        //PersonaDTO obj = new PersonaDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("correo"));
                        //list.add(obj);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Persona_DAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

            }
        } else {
            System.out.println("conexion nula");
        }
        return list;

    }

    ;
    public String insertP(String nombre, String apellido, String correo) {
        Connection com = Conexion_1.obtener();
        String sql = "INSERT INTO `persona`( `nombre`, `apellido`, `correo`) VALUES (\"" + nombre + "\",\"" + apellido + "\",\"" + correo + "\")";
        PreparedStatement psmt;
        if (com != null) {
            try {
                psmt = com.prepareStatement(sql);
                psmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Persona_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "Insert Sucefull";
        } else {
            return "Conexion Nula";
        }
    }

    public String updateP(String id, String nombre, String apellido, String correo) {
        Connection com = Conexion_1.obtener();
        String sql = "UPDATE `persona` SET `nombre`=\"" + nombre + "\",`apellido`=\"" + apellido + "\",`correo`=\"" + correo + "\" WHERE id=\"" + id + "\"";
        PreparedStatement psmt;
        if (com != null) {
            try {
                psmt = com.prepareStatement(sql);
                psmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Persona_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "Update Sucefull";
        } else {
            return "Conexion Nula";
        }
    }

    public String deleteP(String id) {
        Connection com = Conexion_1.obtener();
        String sql = "DELETE FROM `persona` WHERE id=\"" + id + "\"";
        PreparedStatement psmt;
        if (com != null) {
            try {
                psmt = com.prepareStatement(sql);
                psmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Persona_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "Delte Sucefull";
        } else {
            return "Conexion Nula";
        }
    }

    public PersonaDTO validar(int codigo, int clave) {        
        PersonaDTO person = new PersonaDTO();
        Conexion_1 cn=new Conexion_1();
        Connection con;
        PreparedStatement ps ;
        ResultSet rs; 
        String sql="SELECT * FROM `tb_estudiante` WHERE codigo=\""+codigo+"\" and clave=\""+clave+"\" ";        
        try{
            con=cn.obtener();                        
            ps=con.prepareStatement(sql);           
            rs=ps.executeQuery();                       
            while(rs.next()){                
                PersonaDTO obj = new PersonaDTO(rs.getInt("codigo"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"), rs.getInt("clave"), rs.getInt("cc"));
                person=obj;                
            }           
        }catch(Exception e){
            
        }        
        return person;
    }
;

}
