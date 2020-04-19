package model.dao;

import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import model.bean.Categoria;

class CategoriaDAOTest {



   public CategoriaDAOTest() {

   }


   @Test
   public void inserir() {

      Categoria cat = new Categoria("Alimentos");
      CategoriaDAO dao = new CategoriaDAO();
      if (dao.save(cat)) {
         System.out.println("Salvo com sucesso");
      } else {
         fail("Erro ao salvar");
      }

   }

   @Ignore
   public void atualizar() {

      Categoria cat = new Categoria("calça");
      cat.setId(3);
      CategoriaDAO dao = new CategoriaDAO();
      if (dao.upDate(cat)) {
         System.out.println("Atualização realizada com sucesso");
      } else {
         fail("Erro ao salvar");
      }

   }

   @Ignore
   public void deletar() {
      Categoria cat = new Categoria();
      cat.setId(6);
      CategoriaDAO dao = new CategoriaDAO();

      if (dao.delete(cat)) {
         System.out.println("Deletado com sucesso!");
      } else {
         fail("Erro ao deletar!");
      }

   }


   @Ignore
   public void listar() {
      CategoriaDAO dao = new CategoriaDAO();

      for (Categoria c : dao.findAll()) {
         System.out.println("Descrição: " + c.getDescricao());
      }

   }



}
