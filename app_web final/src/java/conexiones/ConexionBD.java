package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {

    private static Connection cnx = null;

    public static Connection obtener() {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_universidad", "root", "");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cnx;
    }

    public static Connection estadoBD() {
        Connection est = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            est = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_universidad", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No hay conexion");
        }finally{
        if(est!=null){
            try {
                est.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        if (est == null) {
            cnx = null;
        }
        return est;
    }

}
