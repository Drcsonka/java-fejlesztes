package com.epam.training.ticketservice.ui.command;

import com.epam.training.ticketservice.core.movie.persistence.entity.Movie;
import com.epam.training.ticketservice.core.user.persistence.entity.Admin;
import com.epam.training.ticketservice.core.movie.model.MovieDto;
import com.epam.training.ticketservice.exceptions.EmptyListException;
import com.epam.training.ticketservice.exceptions.CrudException;
import com.epam.training.ticketservice.core.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class MovieCommands {

    MovieService movieService;

    @Autowired
    MovieCommands(MovieService movieService) {
        this.movieService = movieService;
    }


    @ShellMethod(value = "List all movies", key = "list movies")
    public String list() {
        List<Movie> movies;
        try {
            movies = movieService.listMovies();
        } catch (EmptyListException e) {
            return e.getMessage();
        }
        for (Movie movie : movies) {
            System.out.println("" + movie.getName() + " ("
                    + movie.getCategory() + ", " + movie.getLength() + " minutes)");
        }
        return null;
    }
    @ShellMethod(value = "List the available movies", key = "list movies")
    public String listOfMovies() {
        List<MovieDto> movies = movieService.getMovieList();
        if (movies.isEmpty()) {
            return "There are no movies at the moment";
        }
        for (MovieDto movie : movies) {
            System.out.println("" + movie.getName() + " ("
                    + movie.getCategory() + ", " + movie.getLength() + " minutes)");
        }
        return null;
    }


    @ShellMethod(value = "Update existing movie", key = "update movie")
    public String updateMovie(String movieName, String movieType, String moviesLength) {

        if (AdminAccount.isLogedIn()) {
            try {
                movieService.updateMovie(movieName, movieType, moviesLength);
            } catch (CrudException e) {
                return e.getMessage();
            }

            return "Movie updated";
        }

        return "You are not signed in";

    }


    @ShellMethod(value = "Delete existing movie", key = "delete movie")
    public String deleteMovie(String movieName) {

        if (AdminAccount.isLogedIn()) {
            try {
                movieService.deleteMovie(movieName);
            } catch (CrudException e) {
                return e.getMessage();
            }

            return "Movie deleted";
        }

        return "You are not signed in";

    }
}
