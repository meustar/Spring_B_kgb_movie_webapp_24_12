package site.kgbmeu.kgb_movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.kgbmeu.kgb_movie.repository.UserRepository;
import site.kgbmeu.kgb_movie.vo.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 사용자 생성
    public void createUser(User user) {
        userRepository.save(user);
    }

    // 전체 사용자 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 특정 사용자 조회
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 사용자 정보 수정
    public void updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        userRepository.save(existingUser);
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}