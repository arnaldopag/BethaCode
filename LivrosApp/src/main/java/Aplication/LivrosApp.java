package Aplication;
import Model.Livro;
import Model.Tipo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LivrosApp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("Conexao");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Tipo  tipoCadastrado = entityManager.find(Tipo.class, 1);
        Livro livro1 = new Livro();
        livro1.setTitulo("Senhor dos Aneis");
        livro1.setTitulo("J.R.R Tolkien");
        livro1.setTipo(tipoCadastrado);

        entityManager.getTransaction().begin();
        entityManager.persist(livro1);
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }




}
