package com.usa.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Ale Giraldo
 */
@Data
@Entity
@Table(name="RESERVATION")
public class Reservation implements Serializable{
    
    @Id //Pone como llave principal al ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera un autoincremental
    @Column(name="idReservation")
    private Integer idReservation;
    
    @Column(name="startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    @Column(name="devolutionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date devolutionDate;
    
    @Column(name="status")
    private String status = "created";
    
    //Relación Client-Reservations
    @ManyToOne
    @JoinColumn(name="name")
    @JsonIgnoreProperties("reservations")
    private Client client;
    

    //Relación Room-Reservations
    @ManyToOne
    @JoinColumn(name="description") //Con qué columna se une? //name genera error //Intentar one to one
    @JsonIgnoreProperties("reservations")
    private Room room;

}