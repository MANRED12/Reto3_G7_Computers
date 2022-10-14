package com.team7.computercenter.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="computer")//Se nombra la tabla
public class Computer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Se agrega la columna Id como autoIncremental
    private Integer id;
    @Column(length = 45)//Se establece la longitud máxima del campo name
    private String name;
    @Column(length = 45)//Se establece la longitud máxima del campo brand
    private String brand;
    private Integer year;
    @Column(length = 250)//Se establece la longitud máxima del campo description
    private String description;
    @ManyToOne//Creacion de relacion muchos a uno con la tabla category
    @JoinColumn(name = "idCategory")
    @JsonIgnoreProperties("computers")
    private Category category;

    //Creacion de relacion uno a muchos con la tabla messages
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "computer")
    @JsonIgnoreProperties({"computer","client"})//Se solicita que no se repitan los datos de las tablas computer y client
    private List<Message> messages;

    //Creacion de relacion uno a muchos con la tabla reservation
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "computer")
    @JsonIgnoreProperties({"computer","messages"})///Se solicita que no se repitan los datos de las tablas computer y client
    private List<Reservation> reservations;

    //Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}