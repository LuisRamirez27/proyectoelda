package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQL {
    public Connection cn = null;
    private static Connection conn = null;
    private static String hostname   = "localhost";
    private static String dbname = "";
    private static String dbuser = "root";
    private static String dbpass = "";
    public Connection getConectar()
    {
        return cn;
    }
    public MySQL()
    {
        try
        {

            cn = DriverManager.getConnection("jdbc:mysql://"+ hostname +":3306/" + dbname, dbuser, dbpass );
            System.out.println("Conectado");
        } catch (SQLException ex)
        {
            System.err.println("Error: "+ex);
        }
    }
}
