package model.dao;

import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import model.bean.Categoria;
import model.bean.Produto;

class ProdutoDAOTest {


   public ProdutoDAOTest() {

   }


   @Ignore
   public void inserir() {

      Categoria categoria = new Categoria();
      categoria.setId(1);

      Produto produto = new Produto();
      produto.setDescricao("Feijão");
      produto.setQtd(20);
      produto.setValor(10);
      produto.setCategoria(categoria);

      ProdutoDAO dao = new ProdutoDAO();

      if (dao.save(produto)) {
         System.out.println("Salvo com sucesso!");
      } else {
         fail("Erro ao salvar");
      }

   }


   @Test
   public void atualizar() {

      Categoria categoria = new Categoria();
      categoria.setId(1);

      Produto produto = new Produto();
      produto.setDescricao("Arroz");
      produto.setQtd(15);
      produto.setValor(5);
      produto.setCategoria(categoria);
      produto.setId(1);

      ProdutoDAO dao = new ProdutoDAO();

      if (dao.update(produto)) {
         System.out.println("Atualizado com sucesso!");
      } else {
         fail("Erro ao salvar");
      }

   }



   @Ignore
   public void listar() {
      ProdutoDAO dao = new ProdutoDAO();

      for (Produto p : dao.findAll()) {

         System.out.println("Descrição Produto: " + p.getDescricao() + " - Descrição Categoria: " + p.getCategoria().getDescricao());

      }


   }

}
