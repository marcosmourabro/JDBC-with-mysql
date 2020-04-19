package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class connectionFactory {

   private static final String DRIVER = "com.mysql.jdbc.Driver";
   private static final String URL = "jdbc:mysql://localhost:3306/db_loja";
   private static final String USER = "root";
   private static final String PASS = "123456";

   public static Connection getConnection() {

      try {

         Class.forName(DRIVER);
         return (Connection) DriverManager.getConnection(URL, USER, PASS);


      } catch (ClassNotFoundException | SQLException e) {
         throw new RuntimeException("Erro na conexão", e);
      }


   }


   public static void closeConnection(Connection con) {
      if (con != null) {
         try {
            con.close();
         } catch (SQLException e) {
            System.err.println("Erro:" + e);
         }

      }

   }



   public static void closeConnection(Connection con, PreparedStatement stmt) {
      if (stmt != null) {
         try {
            stmt.close();
         } catch (SQLException e) {
            System.err.println("Erro:" + e);
         }

      }

      closeConnection(con);

   }


   public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
      if (rs != null) {
         try {
            rs.close();
         } catch (SQLException e) {
            System.err.println("Erro:" + e);
         }

      }

      closeConnection(con, stmt);

   }

}
