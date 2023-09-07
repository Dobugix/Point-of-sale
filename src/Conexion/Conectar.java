
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//Conexión para MySQL
public class Conectar {
    Connection con=null;
    public Connection conexionAdmin(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/dbpuntodeventamendez","root","m@rio123");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    Statement createStatement(){
        throw new UnsupportedOperationException("No soportado");
    } 

    public Connection conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
