/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Stadt;
import javax.persistence.Query;

/**
 *
 * @author Standart
 */
public class StadtDao extends StandartDao{
   private static StadtDao instance = null;

    private StadtDao() {
    }

    public static StadtDao getInstance() {
        if (instance == null) {
            instance = new StadtDao();
        }
        return instance;
    }
    
        public Stadt getStadt(int id) {
        Query q = em.createNamedQuery("Stadt.findById");
        q.setParameter("id", id);
        Stadt stadt = (Stadt) q.getSingleResult();
        return stadt;
    }
}
