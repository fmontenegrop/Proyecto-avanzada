
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

public class Nota_DAO {
    public List<Object>getNotas(String codigo_e) {
        
        List<Object> list = null;
        String sql = "SELECT nota, (SELECT id_c FROM tb_registro WHERE id_r = id AND codigo_e =\""+codigo_e+"\") FROM tb_nota ";
        Connection com = ConexionBD.obtener();        
        if(com != null){
            PreparedStatement psmt;
            try{
                psmt = com.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                list = new ArrayList<>();
                while (rs.next()){                    
                    //Notas_DTO obj = new Notas_DTO(rs.getInt("id"), rs.getInt("id_r"), rs.getInt("cod_profesor"), rs.getInt("nota")); 
                    int[] n = new int[2];
                    n[0]=rs.getInt("nota");
                    n[1]=rs.getInt("id_c");
                    list.add(n);
                }
            }catch(SQLException ex){
                Logger.getLogger(Nota_DAO.class.getName()).log(Level.SEVERE,null,ex);
            }finally{
               
            }
        }else {
            System.out.println("conexion nula");
        }
        return list;
        
    };
    
}
