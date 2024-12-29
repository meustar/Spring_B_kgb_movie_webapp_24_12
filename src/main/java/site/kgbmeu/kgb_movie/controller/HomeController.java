package site.kgbmeu.kgb_movie.controller;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, OAuth2User principal) {
        if (principal != null) {
            // Principal 정보 유효성 체크 및 NPE 방지
            String name = principal.getAttribute("name");
            String email = principal.getAttribute("email");
            if (name != null && email != null) {
                model.addAttribute("name", name);
                model.addAttribute("email", email);
            } else {
                model.addAttribute("name", "Guest");
                model.addAttribute("email", "guest@example.com");
            }
        }
        return "home";
    }
}