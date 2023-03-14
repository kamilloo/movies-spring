package com.movies.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Movie {
    @Id
    private Long id;

    @Column(nullable = true, length = 100)
    private String name;

    @Column()
    private String director;

    @Column()
    private String title;

    @Column()
    private String genre;

    @Column()
    private Date released;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
