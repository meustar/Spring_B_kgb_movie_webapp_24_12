package site.kgbmeu.kgb_movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.kgbmeu.kgb_movie.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


}
