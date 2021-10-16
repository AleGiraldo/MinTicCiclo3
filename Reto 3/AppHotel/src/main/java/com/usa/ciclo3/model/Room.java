package com.usa.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Ale Giraldo
 */
@Data
@Entity
@Table(name="ROOM")
public class Room implements Serializable{
    @Id //Pone como llave principal al ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera un autoincremental
    private Integer id;
    
    private String name;
    
    private String hotel;
    
    private Integer stars;
    
    private String description;
    
    //Relación Category-Room
    @ManyToOne //Define la relación de la llave foranea
    @JoinColumn(name="category") //Nombre de la columna
    @JsonIgnoreProperties("rooms") 
    private Category category;
    
    //Relación Room-Messages
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Message> messages;
    

    //Relación Room-Reservations
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Reservation> reservations;

    
}
