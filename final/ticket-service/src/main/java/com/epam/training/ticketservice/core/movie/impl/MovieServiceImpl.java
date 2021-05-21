package com.epam.training.ticketservice.core.movie.impl;

import com.epam.training.ticketservice.core.movie.MovieService;
import com.epam.training.ticketservice.core.movie.model.MovieDto;
import com.epam.training.ticketservice.core.movie.persistence.entity.Movie;
import com.epam.training.ticketservice.core.movie.persistence.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> getMovieList() {
        return movieRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toUnmodifiableList());
    }


    @Override
    public void createMovie(MovieDto movieDto) {
        Objects.requireNonNull(movieDto, "Movie cannot be null");
        Objects.requireNonNull(movieDto.getTitle(), "Movie Title cannot be null");
        Objects.requireNonNull(movieDto.getLength(), "Movie Length cannot be null");
        Objects.requireNonNull(movieDto.getGenre(), "Movie Genre cannot be null");
        Movie movie = new Movie(null,
                movieDto.getTitle(),
                movieDto.getGenre(),
                movieDto.getLength()
        );
        movieRepository.save(movie);
    }

    public void deleteMovieByTitle(String title) {
        if (!movieRepository.existsByTitle(title)) {
            throw new IllegalArgumentException("Movie with this title doesn't exist!");
        }
        movieRepository.deleteByTitle(title);
    }

    @Override
    public void updateMovie(MovieDto movieDto) {
        if (!movieRepository.existsByTitle(movieDto.getTitle())) {
            throw new IllegalArgumentException("Movie with this title doesn't exist!");
        }
        Movie movie = movieRepository.getMovieByTitle(movieDto.getTitle());
        movie.setGenre(movieDto.getGenre());
        movie.setLength(movieDto.getLength());
        movieRepository.save(movie);
    }


    @Override
    public Boolean existsByTitle(String title) {
        return movieRepository.existsByTitle(title);
    }

    private MovieDto convertEntityToDto(Movie movie) {
        return new MovieDto.Builder()
                .withTitle(movie.getTitle())
                .withGenre(movie.getGenre())
                .withLength(movie.getlength())
                .build();
    }

}
