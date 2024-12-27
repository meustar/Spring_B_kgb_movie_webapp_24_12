package site.kgbmeu.kgb_movie.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import site.kgbmeu.kgb_movie.vo.Movie;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TMDBService {

    @Value("${spring.tmdb.api-key}")
    private String apiKey;

    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/popular";
    private static final String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500";

    public List<Movie> getPopularMovies() {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?api_key=%s&language=ko-KR", BASE_URL, apiKey);

        TMDBResponse response = restTemplate.getForObject(url, TMDBResponse.class);
        return response != null ? response.getResults().stream().map(movie -> {
            movie.setPoster(POSTER_BASE_URL + movie.getPoster());
            return movie;
        }).collect(Collectors.toList()) : List.of();
    }

    // Inner class to map TMDB response
    private static class TMDBResponse {
        private List<Movie> results;

        public List<Movie> getResults() {
            return results;
        }

        public void setResults(List<Movie> results) {
            this.results = results;
        }
    }
}