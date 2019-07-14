/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import conexion.Conexion_1;
import conexion.ConexionBD;
import dto.Docente_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;
/**
 *
 * @author GAMER
 */
public class DocenteDAO {
    Docente_DTO person = new Docente_DTO();
    public Docente_DTO validar(int codigo, int clave) {                
        Conexion_1 cn=new Conexion_1();
        Connection con;
        PreparedStatement ps ;
        ResultSet rs; 
        String sql="SELECT * FROM `tb_profesor` WHERE codigo=\""+codigo+"\" and clave=\""+clave+"\" ";        
        try{
            con=cn.obtener();                        
            ps=con.prepareStatement(sql);           
            rs=ps.executeQuery();                       
            while(rs.next()){                
                Docente_DTO obj = new Docente_DTO(rs.getInt("codigo"), rs.getString("nombre"),rs.getInt("cc"), rs.getInt("clave"));
                person=obj;                
            }           
        }catch(Exception e){
            
        }        
        return person;
    }
}
