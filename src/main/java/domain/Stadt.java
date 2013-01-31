/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Stadt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stadt.findAll", query = "select t from Stadt t"),
    @NamedQuery(name = "Stadt.findById", query = "select t from Stadt t WHERE t.id = :id"),})
public class Stadt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Plz")
    private int id;
    @Column(name = "STADTNAME")
    private String name;
    @Column(name = "KnotenListe")
    ArrayList<Integer> knoten = new ArrayList<Integer>();
    //@Column(name = "KNOTEN_1")
    //private int knoten_1;
    //@Column(name = "KNOTEN_2")
    //private int knoten_2;
    //@Column(name = "KNOTEN_3")
    //private int knoten_3;

    public Stadt() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Integer> getListe(){
        return knoten;   
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setKnoten(int knoten){
        this.knoten.add(knoten);
    }
}
