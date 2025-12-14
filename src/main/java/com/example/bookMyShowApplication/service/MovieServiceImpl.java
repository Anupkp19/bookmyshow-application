package com.example.bookMyShowApplication.service;

import com.example.bookMyShowApplication.dto.MoviesDto;
import com.example.bookMyShowApplication.model.Movie;
import com.example.bookMyShowApplication.repository.MovieEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieEntityRepository movieEntityRepository;
    @Override
    public String addMovie(MoviesDto moviesDto) {

        //Time constrains need to write assembler here to convert to entity from normal POJO and vice versa

        Movie movie = new Movie();
        movie.setMovieDesctiption(moviesDto.getMovieDescription());
        movie.setMoviePoster(moviesDto.getMoviePoster());
        movie.setMovieName(moviesDto.getMovieName());
        movieEntityRepository.save(movie);
        return "Movie added successfully";
    }
}
