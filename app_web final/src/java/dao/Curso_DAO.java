/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexiones.ConexionBD;
import dto.Curso_DTO;
import dto.Estudiante_DTO;
import dto.Profesor_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Curso_DAO {
     public Curso_DTO obtenerC(String nombre) {        
        String sql = "SELECT * FROM tb_curso WHERE nombre=\""+nombre+"\"";
        Connection com = ConexionBD.obtener();
        Curso_DTO obj = new Curso_DTO();
        if (com != null) {           
            PreparedStatement psmt;
            try {
                psmt = com.prepareStatement(sql);
                ResultSet rs = psmt.executeQuery();
                while (rs.next()) {
                    obj.setId(rs.getInt("id"));
                    obj.setNombre(rs.getString("nombre"));
                    obj.setCodigo_profesor(rs.getInt("codigo_profesor"));                    
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
}
