package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
* Die StandartDao enth�lt Standart Methoden die alle anderen Daos auch benutzen
*/

public abstract class StandartDao {

    public EntityManager em;
 
    StandartDao() {
        startDB emf = startDB.getInstance();
        em = emf.getEm();
    }

    public <T> void addElement(T element) {

        try {
            em.getTransaction().begin();
            em.persist(element);
            em.getTransaction().commit();

        } catch (RuntimeException ex) {
            if (em.getTransaction() != null
                    && em.getTransaction().isActive()) {
                System.out.println("Rollback");
                em.getTransaction().rollback();
                throw ex;
            }
        }
    }

    public <T> List<T> getList(Class<T> classs) {

        Query q = em.createNamedQuery(classs.getSimpleName() + ".findAll");
        List<T> liste = q.getResultList();
        return liste;
    }

}