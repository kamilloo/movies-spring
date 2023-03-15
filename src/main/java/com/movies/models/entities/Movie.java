package com.movies.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LocalDate released;
}
