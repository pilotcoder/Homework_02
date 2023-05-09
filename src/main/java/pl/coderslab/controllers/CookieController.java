package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CookieController {
    @GetMapping("/add-cookies")
    public void addCookies(HttpServletResponse response) {
        Cookie user = new Cookie("user", "Jan");
        user.setMaxAge(10 * 60);
        response.addCookie(user);
        Cookie uid = new Cookie("uid", "ccb1b154-c4ff");
        uid.setMaxAge(10 * 24 * 60 * 60);
        response.addCookie(uid);
        Cookie ide = new Cookie("IDE", "IntelliJ");
        ide.setMaxAge(30 * 24 * 60 * 60);
        response.addCookie(ide);
    }


    @GetMapping("/all-cookies")
    public String showCookies(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            List<Cookie> cookieList = new ArrayList<>();
            for (Cookie cookie : cookies) {
                cookieList.add(cookie);
            }
            model.addAttribute("cookieList", cookieList);
        }
        return "allCookies";
    }
}

