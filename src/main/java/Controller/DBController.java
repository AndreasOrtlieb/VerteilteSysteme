/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.HotelDao;
import DAO.StadtDao;
import domain.Hotel;
import domain.Stadt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Standart
 */
public class DBController{
    private StadtDao StadtDB;
    private HotelDao HotelDB;
    private List<Stadt> StadtListe;
    private List<Hotel> HotelListe;
    ArrayList<Integer> knoten;
    BufferedReader reader = null;
    String zeile;
    
    public DBController(){
      StadtDB = StadtDao.getInstance();
      StadtListe = StadtDB.getList(Stadt.class);
      if(StadtListe.size()<=0){
          fuelleStadtDb();
      }
      HotelDB = HotelDao.getInstance();
      HotelListe = HotelDB.getList(Hotel.class);
      if(HotelListe.size()<=0){
          fuelleHotelDb();
      }
    }
      
    public void test(){
        String s ="test";
      File f = new File( s);

      if ( f.exists() )
      {
        if ( f.setLastModified( System.currentTimeMillis() ) )
          System.out.println( "Berührte " + s );
        else
          System.out.println( "Konnte nicht berühren " + s );
      }
      else
      {
        try
        {
          f.createNewFile();
          System.out.println( "Legte neue Datei an " + s );
        } catch ( IOException e ) { e.printStackTrace(); }
      
    }
    }
    
    public void fuelleStadtDb(){
         Stadt stadt;
	 try
	 {
	   reader = new BufferedReader(new FileReader( "Staedte.txt" ));
	     
	   zeile = reader.readLine();
	   while(zeile!=null){
		   String[] splitErgebnis = zeile.split(" ");
		   stadt = new Stadt();
                   stadt.setName(splitErgebnis[0]);
                   for(int i = 1;i<splitErgebnis.length;i++){
                   stadt.setKnoten(intUmwandlung(splitErgebnis[i]));
	   }
                   StadtDB.addElement(stadt);
		   zeile = reader.readLine();
	   }
	 }
	 catch ( IOException e ) {
	   System.err.println( "Fehler beim Lesen der Datei!" );
	 }
	 finally {
	   try { reader.close(); } catch ( Exception e ) { e.printStackTrace(); }
	 }
    }
    
    public void fuelleHotelDb(){
         Hotel hotel;
         Stadt stadt;
	 try
	 {
	   reader = new BufferedReader(new FileReader( "Hotels.txt" ));
	     
	   zeile = reader.readLine();
	   while(zeile!=null){
		   String[] splitErgebnis = zeile.split(" ");
		   hotel = new Hotel();              
                   stadt = StadtDB.getStadt(intUmwandlung(splitErgebnis[0]));
                   hotel.setStandort(stadt);
                   hotel.setName(splitErgebnis[1]);
                   hotel.setSterne(intUmwandlung(splitErgebnis[2]));
                   StadtDB.addElement(hotel);
		   zeile = reader.readLine();
	   }
	 }
	 catch ( IOException e ) {
	   System.err.println( "Fehler beim Lesen der Datei!" );
	 }
	 finally {
	   try { reader.close(); } catch ( Exception e ) { e.printStackTrace(); }
	 }
    }
    
public void getList(){
    StadtListe = StadtDB.getList(Stadt.class);
    System.out.println(StadtListe.size());
    Stadt neu = StadtListe.get(0);
    knoten = neu.getListe();
    System.out.println(neu.getId());
    System.out.println(knoten.get(2));
}
public int intUmwandlung(String wert){
    int Zahl = 0;
    try
    {
      Zahl = Integer.parseInt(wert);
    }
    catch (NumberFormatException nfe)
    {
      System.out.println("NumberFormatException: " + nfe.getMessage());
    }
    return Zahl;
}
}
