
package dao;

import conexiones.ConexionBD;
import dto.Profesor_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Profesor_DAO {

    public Profesor_DAO() {
    }
    public Profesor_DTO loginP(String codigo, String clave) {        
        String sql = "SELECT * FROM tb_profesor WHERE codigo=\""+codigo+"\"AND clave=\""+clave+"\"";
        Connection com = ConexionBD.obtener();
        Profesor_DTO obj = new Profesor_DTO();
        if (com != null) {
           
            PreparedStatement psmt;
            try {
                psmt = com.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                while (rs.next()) {
                    obj.setCodigo(rs.getInt("codigo"));
                    obj.setNombre(rs.getString("nombre"));
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
        
    public Profesor_DTO obtenerP(String nombre) {        
        String sql = "SELECT * FROM tb_profesor WHERE nombre=\""+nombre+"\"";
        Connection com = ConexionBD.obtener();
        Profesor_DTO obj = new Profesor_DTO();
        if (com != null) {
           
            PreparedStatement psmt;
            try {
                psmt = com.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                while (rs.next()) {
                    obj.setCodigo(rs.getInt("codigo"));
                    obj.setNombre(rs.getString("nombre"));
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
        String sql = "UPDATE `tb_profesor` SET `"+parametro+"`=\""+dato+"\" WHERE codigo=\""+codigo+"\"";                
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
    public String updateP(String codigo, String clave){
         Connection com = ConexionBD.obtener();        
        String sql = "UPDATE `tb_profesor` SET `clave`=\""+clave+"\" WHERE codigo=\""+codigo+"\"";                
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
}
