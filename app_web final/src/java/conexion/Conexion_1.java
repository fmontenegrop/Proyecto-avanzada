/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion_1 {
     private static Connection cnx = null;

    public static Connection obtener() {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_universidad", "root", "");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Conexion_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cnx;
    }

    public static Connection estadoBD() {
        Connection est = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            est = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_universidad", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No hay conexion");
        }finally{
        if(est!=null){
            try {
                est.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        if (est == null) {
            cnx = null;
        }
        return est;
    }
}
