package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class startDB {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private static startDB instance = null;

    public static startDB getInstance() {
        if (instance == null) {
            instance = new startDB();
        }
        return instance;
    }

    private startDB() {
        emf = Persistence.createEntityManagerFactory("Hoteldienst");
        em = emf.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void closeDB() {
        emf.close();
    }
}
