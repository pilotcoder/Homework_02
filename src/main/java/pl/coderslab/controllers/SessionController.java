package pl.coderslab.controllers;


import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

    @Controller
    @SessionAttributes("loginStart")
    public class SessionController {

        @GetMapping("/session/loginStart")
        @ResponseBody
        String loginStartView(HttpSession httpSession, Model model){
            LocalDateTime loginStart = (LocalDateTime) httpSession.getAttribute("loginStart");
            if (loginStart == null){
                loginStart = LocalDateTime.now();
                model.addAttribute("loginStart", loginStart);
            }
            return loginStart.toString();
        }

    }

