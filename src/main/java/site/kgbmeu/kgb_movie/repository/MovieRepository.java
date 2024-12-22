package site.kgbmeu.kgb_movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.kgbmeu.kgb_movie.vo.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}