package com.tms.web.entity;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars")
@Data
public class Car2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Enumerated(EnumType.STRING)
    private CarModel model;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIME)
    private Date updateTime;
    private  Boolean inStock;
    @Version
    private Long version;

    public Car2() {
    }

    public Car2(String nom, CarModel model, Date releaseDate, Boolean inStock) {
        this.nom = nom;
        this.model = model;
        this.releaseDate = releaseDate;
        this.inStock = inStock;
    }

}
