package livraria.control;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class Conexao {
    
      
   private static Connection conn ;
   
   
   public static Connection getConnection() {
        
	  if (conn == null){
	      try {
              
               	
                  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tegra?useTimezone=true&serverTimezone=UTC","tegra","tegra");
                  return conn;
                  
              }catch (Exception ex) {
                  System.out.println("Falha na Conexao");
                  System.out.println(ex.toString() + ex.getMessage());
          }
	   }
       	
	      return conn;
	   
   }
   
   public void closeConnection(){
        if (conn != null){
	   try {
                  conn.close();
           } catch (SQLException ex) {
                   System.out.println(ex.toString());    
           }
        }   
    }
}