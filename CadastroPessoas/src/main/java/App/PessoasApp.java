package App;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoasApp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("Conexao");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }
}
