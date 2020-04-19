package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.connectionFactory;
import model.bean.Categoria;
import model.bean.Produto;

public class ProdutoDAO {

   private Connection con = null;

   public ProdutoDAO() {

      con = connectionFactory.getConnection();

   }

   public boolean save(Produto produto) {

      String sql = "INSERT INTO produto (descricao, qtd, valor, categoria_id) VALUES (?, ?, ?, ?)";

      PreparedStatement stmt = null;

      try {
         stmt = (PreparedStatement) con.prepareStatement(sql);
         stmt.setString(1, produto.getDescricao());
         stmt.setInt(2, produto.getQtd());
         stmt.setDouble(3, produto.getValor());
         stmt.setInt(4, produto.getCategoria().getId());
         stmt.executeUpdate();
         return true;
      } catch (SQLException e) {
         System.err.println("Erro: " + e);
         return false;

      } finally {
         connectionFactory.closeConnection(con, stmt);
      }

   }


   public boolean update(Produto produto) {

      String sql = "UPDATE produto SET descricao = ?, qtd = ?, valor = ?, categoria_id = ? WHERE  id = ?";

      PreparedStatement stmt = null;

      try {
         stmt = (PreparedStatement) con.prepareStatement(sql);
         stmt.setString(1, produto.getDescricao());
         stmt.setInt(2, produto.getQtd());
         stmt.setDouble(3, produto.getValor());
         stmt.setInt(4, produto.getCategoria().getId());
         stmt.setInt(5, produto.getId());
         stmt.executeUpdate();
         return true;
      } catch (SQLException e) {
         System.err.println("Erro: " + e);
         return false;

      } finally {
         connectionFactory.closeConnection(con, stmt);
      }

   }


   public List<Produto> findAll() {

      String sql = "select * from vw_produtocategoria";

      PreparedStatement stmt = null;
      ResultSet rs = null;

      List<Produto> produtos = new ArrayList<>();

      try {
         stmt = con.prepareStatement(sql);
         rs = stmt.executeQuery();

         while (rs.next()) {
            Produto produto = new Produto();

            produto.setDescricao(rs.getString("pdesc"));
            produto.setId(rs.getInt("pid"));
            produto.setQtd(rs.getInt("qtd"));
            produto.setValor(rs.getDouble("valor"));

            Categoria categoria = new Categoria();

            categoria.setId(rs.getInt("cid"));
            categoria.setDescricao(rs.getString("cdesc"));

            produto.setCategoria(categoria);

            produtos.add(produto);
         }

      } catch (SQLException e) {
         System.err.println("Erro: " + e);
      } finally {
         connectionFactory.closeConnection(con, stmt, rs);
      }

      return produtos;

   }


}
