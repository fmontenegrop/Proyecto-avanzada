
package dao;

import conexiones.ConexionBD;
import dto.Notas_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registro_DAO {
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
