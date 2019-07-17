
package dao;

import conexiones.ConexionBD;
import dto.Estudiante_DTO;
import dto.Profesor_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Estudiante_DAO {
    public Estudiante_DTO obtenerE(String nombre) {        
        String sql = "SELECT * FROM tb_estudiante WHERE nombre=\""+nombre+"\"";
        Connection com = ConexionBD.obtener();
        Estudiante_DTO obj = new Estudiante_DTO();
        if (com != null) {           
            PreparedStatement psmt;
            try {
                psmt = com.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                while (rs.next()) {
                    obj.setCodigo(rs.getInt("codigo"));
                    obj.setNombre(rs.getString("nombre"));
                    obj.setApellido(rs.getString("apellido"));
                    obj.setCorreo(rs.getString("correo"));
                    obj.setCc(rs.getInt("cc"));
                    obj.setClave(rs.getInt("clave"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Profesor_DAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

            }
        } else {
            System.out.println("conexion nula");
        }
        return obj;
    }
    public String Editar(String codigo, String dato, String parametro){
         Connection com = ConexionBD.obtener();        
        String sql = "UPDATE `tb_estudiante` SET `"+parametro+"`=\""+dato+"\" WHERE codigo=\""+codigo+"\"";                
        PreparedStatement psmt;
        if(com!=null){
            try{
               psmt = com.prepareStatement(sql);
               psmt.executeUpdate();
            }
            catch (SQLException ex) {
                Logger.getLogger(Profesor_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             return "Update Sucefull";
        }
        else return "Conexion Nula";
    }
    public Estudiante_DTO loginP(String codigo, String clave) {        
        String sql = "SELECT * FROM tb_estudiante WHERE codigo=\""+codigo+"\"AND clave=\""+clave+"\"";
        Connection com = ConexionBD.obtener();
        Estudiante_DTO obj = new Estudiante_DTO();
        if (com != null) {
           
            PreparedStatement psmt;
            try {
                psmt = com.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                while (rs.next()) {
                    obj.setCodigo(rs.getInt("codigo"));
                    obj.setNombre(rs.getString("nombre"));
                    obj.setApellido(rs.getString("apellido"));
                    obj.setCorreo(rs.getString("correo"));
                    obj.setClave(rs.getInt("clave"));
                    obj.setCc(rs.getInt("cc"));                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Profesor_DAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

            }
        } else {
            System.out.println("conexion nula");
        }
        return obj;
    }
    public String updateP(String id, String clave){
         Connection com = ConexionBD.obtener();        
        String sql = "UPDATE `tb_estudiante` SET `clave`=\""+clave+"\" WHERE id=\""+id+"\"";                
        PreparedStatement psmt;
        if(com!=null){
            try{
               psmt = com.prepareStatement(sql);
               psmt.executeUpdate();
            }
            catch (SQLException ex) {
                Logger.getLogger(Estudiante_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             return "Update Sucefull";
        }
        else return "Conexion Nula";
    }
}
