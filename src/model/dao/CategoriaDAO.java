package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.connectionFactory;
import model.bean.Categoria;

public class CategoriaDAO {


   private Connection con = null;

   public CategoriaDAO() {
      con = connectionFactory.getConnection();
   }

   public boolean save(Categoria categoria) {

      String sql = "INSERT INTO categoria (descricao) VALUES (?)";

      PreparedStatement stmt = null;

      try {
         stmt = (PreparedStatement) con.prepareStatement(sql);
         stmt.setString(1, categoria.getDescricao());
         stmt.executeUpdate();
         return true;
      } catch (SQLException e) {
         System.err.println("Erro: " + e);
         return false;

      } finally {
         connectionFactory.closeConnection(con, stmt);
      }

   }


   public List<Categoria> findAll() {

      String sql = "select * from categoria";

      PreparedStatement stmt = null;
      ResultSet rs = null;

      List<Categoria> categorias = new ArrayList<>();

      try {
         stmt = con.prepareStatement(sql);
         rs = stmt.executeQuery();

         while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setDescricao(rs.getString("descricao"));
            categorias.add(categoria);
         }

      } catch (SQLException e) {
         System.err.println("Erro: " + e);
      } finally {
         connectionFactory.closeConnection(con, stmt, rs);
      }

      return categorias;

   }


   public boolean upDate(Categoria categoria) {

      String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";

      PreparedStatement stmt = null;

      try {
         stmt = (PreparedStatement) con.prepareStatement(sql);
         stmt.setString(1, categoria.getDescricao());
         stmt.setInt(2, categoria.getId());
         stmt.executeUpdate();
         return true;
      } catch (SQLException e) {
         System.err.println("Erro: " + e);
         return false;

      } finally {
         connectionFactory.closeConnection(con, stmt);
      }

   }


   public boolean delete(Categoria categoria) {

      String sql = "DELETE FROM categoria WHERE id = ?";

      PreparedStatement stmt = null;

      try {
         stmt = (PreparedStatement) con.prepareStatement(sql);
         stmt.setInt(1, categoria.getId());
         stmt.executeUpdate();
         return true;
      } catch (SQLException e) {
         System.err.println("Erro: " + e);
         return false;

      } finally {
         connectionFactory.closeConnection(con, stmt);
      }

   }

}
