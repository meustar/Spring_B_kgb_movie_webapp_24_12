package site.kgbmeu.kgb_movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.kgbmeu.kgb_movie.service.TMDBService;
import site.kgbmeu.kgb_movie.vo.Movie;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private TMDBService tmdbService;

    @GetMapping("/popular")
    public ResponseEntity<List<Movie>> getPopularMovies() {
        try {
            List<Movie> movies = tmdbService.getPopularMovies();
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of(new Movie(null, "Error", "Unable to fetch movies", "", "")));
        }
    }
}