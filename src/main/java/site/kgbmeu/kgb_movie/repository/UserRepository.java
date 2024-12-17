package site.kgbmeu.kgb_movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.kgbmeu.kgb_movie.vo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 추가적인 쿼리 메서드를 작성할 수 있습니다.
}