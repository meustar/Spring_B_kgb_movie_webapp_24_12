package site.kgbmeu.kgb_movie.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // JPA Entity 어노테이션으로 데이터베이스 테이블과 매핑됨
@Table(name = "movies") // 테이블 이름을 "movies"로 지정
@Data // Lombok을 사용하여 Getter, Setter, toString, equals, hashCode 등을 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 포함한 생성자 자동 생성
public class Movie {

    @Id // Primary Key로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 값 설정
    private Long id; // 영화 ID

    private String title; // 영화 제목

    private String overview; // 영화 설명

    private String poster; // 포스터 URL

    private String releaseDate; // 출시일
}