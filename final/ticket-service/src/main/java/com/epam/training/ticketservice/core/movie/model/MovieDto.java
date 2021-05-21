package com.epam.training.ticketservice.core.movie.model;

import java.util.Objects;

public class MovieDto {
    private final String title;
    private final String genre;
    private final Integer length;

    public MovieDto(String title, String genre, Integer length) {
        this.title = title;
        this.genre = genre;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getLength(){return length;}


    @Override
    public String toString() {
        return title + " ("
                + genre + ", "
                + length + " minutes)";
    }

    public static class Builder {
        private String title;
        private String genre;
        private Integer length;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder withLength(Integer length) {
            this.length = length;
            return this;
        }

        public MovieDto build() {
            return new MovieDto(this.title,this.genre,this.length);
        }


    }

}
