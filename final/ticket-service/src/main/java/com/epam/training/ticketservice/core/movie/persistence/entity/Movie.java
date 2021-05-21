package com.epam.training.ticketservice.core.movie.persistence.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.*;
import java.util.Objects;


@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String title;
    private String genre;
    private Integer length;


    public Movie(Long id, String title, String genre, Integer length) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public String  getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getlength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


    @Override
    public String toString() {
        return "Movie{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", genre='" + genre + '\''
                + ", length=" + length
                + '}';
    }
}
