package site.kgbmeu.kgb_movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.kgbmeu.kgb_movie.repository.MovieRepository;
import site.kgbmeu.kgb_movie.vo.Movie;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}