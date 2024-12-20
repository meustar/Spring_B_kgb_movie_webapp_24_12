package site.kgbmeu.kgb_movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.kgbmeu.kgb_movie.service.UserService;
import site.kgbmeu.kgb_movie.vo.User;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // 회원 목록 조회
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // 사용자 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // 사용자 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok("User updated successfully");
    }

    // 회원 탈퇴
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}