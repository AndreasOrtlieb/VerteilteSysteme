/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Standart
 */
public class HotelDao extends StandartDao{
  private static HotelDao instance = null;

    private HotelDao() {
    }

    public static HotelDao getInstance() {
        if (instance == null) {
            instance = new HotelDao();
        }
        return instance;
    }  
}
