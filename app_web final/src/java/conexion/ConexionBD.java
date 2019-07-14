/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionBD {
     
    Connection con;   
    public  Connection obtener(){      
        try{                        
            Class.forName("com.mysql.jdbc.Driver");                                     
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cursos","root","");                         
        }catch (Exception E){
            
        }
        return con;
    }
}
