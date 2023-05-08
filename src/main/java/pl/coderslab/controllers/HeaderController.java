package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
@Controller
public class HeaderController {
    @GetMapping("/showUserAgent")
    public String showHeader(HttpServletRequest request, Model model){
        String headerName = request.getHeader("User-Agent");
        String headerValue = request.getHeader(headerName);
        model.addAttribute("headerName", headerName);
        model.addAttribute("headerValue", headerValue);

        return "userAgent";
    }
}
