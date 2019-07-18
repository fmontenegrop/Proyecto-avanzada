
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
        List<Registro_DTO> list = null;
        String sql = "select * from tb_registro where cod_e=\""+codigo+"\"";
        Connection com = ConexionBD.obtener();        
        if (com != null) {            
            PreparedStatement psmt;
            try {
                psmt = com.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                 list = new ArrayList<>();
                while (rs.next()) {                    
                    Registro_DTO obj = new Registro_DTO(rs.getInt("id"),rs.getDate("fecha"),rs.getInt("cod_e"),rs.getInt("id_c"));
                    list.add(obj);
                    System.out.println(""+obj.getId());
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
