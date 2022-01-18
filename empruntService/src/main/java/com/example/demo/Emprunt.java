package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long carteId;
    private String Title;

    private Date empruntDate;
    private Date retourDate;

    public Emprunt() {
    }

    public Emprunt(long carteId, String title) {
        Title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCarteId() {
        return carteId;
    }

    public void setCarteId(long carteId) {
        this.carteId = carteId;
    }

    public String getTitle() {
        return Title;
    }


    
}
