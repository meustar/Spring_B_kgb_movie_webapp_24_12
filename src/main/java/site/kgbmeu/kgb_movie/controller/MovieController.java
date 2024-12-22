package site.kgbmeu.kgb_movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.kgbmeu.kgb_movie.service.MovieService;
import site.kgbmeu.kgb_movie.vo.Movie;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.findAll();
    }
}