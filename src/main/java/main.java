
import Controller.DBController;
import DAO.StandartDao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Standart
 */
public class main {
   public static void main(String[] args) {
       //StandartDao test = StandartDao.getInstance();
       DBController DB = new DBController();
       //DB.txtEinlesen();
       DB.getList();
   } 
}
