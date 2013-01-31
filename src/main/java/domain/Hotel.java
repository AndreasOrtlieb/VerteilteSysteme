/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Hotel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "select t from Hotel t"),
    @NamedQuery(name = "Hotel.findByStadt", query = "select t from Hotel t WHERE t.standort  = :standort")})

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HOTEL_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
     @Column(name = "Sterne")
    private int sterne;
   @Column(name = "Anzahl_Betten")
    private int betten;
   @JoinColumn(name = "Standort", referencedColumnName = "Plz")
    @ManyToOne(optional = false)
    private Stadt standort;
   
    public Hotel() {
    }
    
     public int getId() {
        return id;
    }

     public String getName() {
        return name;
    }
     
     public int getSterne() {
        return sterne;
    }
     
     public int getBetten() {
        return betten;
    }
     
    public Stadt getStandort() {
        return standort;
    }
     public void setName(String name) {
        this.name=name;
    }
     
     public void setSterne(int sterne) {
        this.sterne = sterne;
    }
     
     public void setBetten(int betten) {
        this.betten= betten;
    }
     
    public void setStandort(Stadt standort) {
        this.standort = standort;
    }
    }