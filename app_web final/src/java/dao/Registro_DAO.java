
package dao;

import conexiones.ConexionBD;
import dto.Notas_DTO;
import dto.Profesor_DTO;
import dto.Registro_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registro_DAO {
    public List<Registro_DTO> obtenerR(String codigo) {        
        List<Registro_DTO> list= null;
        String sql = "SELECT * FROM tb_registro WHERE cod_e=\""+codigo+"\"";
        Connection com = ConexionBD.obtener();        
        if (com != null) {
           
            PreparedStatement psmt;
            try {
                psmt = com.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                while (rs.next()) {
                    Registro_DTO obj = new Registro_DTO();
                    obj.setId(rs.getInt("id"));
                    obj.setFecha(rs.getDate("fecha"));
                    obj.setCodigo_e(rs.getInt("cod_e"));
                    obj.setId_c(rs.getInt("id_c"));
                    list.add(obj);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Profesor_DAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

            }
        } else {
            System.out.println("conexion nula");
        }
        return list;
    }
    public String registrarCurso(String fecha,String codigo_e,String id_c){        
        Connection com = ConexionBD.obtener();        
        String sql = "INSERT INTO `tb_registro`( `fecha`, `cod_e`, `id_c`) VALUES (\""+fecha+"\",\""+codigo_e+"\",\""+id_c+"\")";                
        PreparedStatement psmt;
        if(com!=null){
            try{
               psmt = com.prepareStatement(sql);
               psmt.executeUpdate();
            }
            catch (SQLException ex) {
                Logger.getLogger(Registro_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             return "Insert Sucefull";
        }
        else return "Conexion Nula";
    };
}
