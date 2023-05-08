package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

@Controller
public class HelloController {



  @GetMapping("/hello")
  @ResponseBody
  public String hello(){
    return "Hello Kapusta";
  }

  @GetMapping("/helloView")
  public String helloView(Model model){

    LocalTime time = LocalTime.parse("20:20");

    if (time.getHour() >= 8 && time.getHour() < 20){
      model.addAttribute("textColor", "black");
      model.addAttribute("backgroundColor", "white");
    }else{
      model.addAttribute("textColor", "white");
      model.addAttribute("backgroundColor", "black");
    }

    return "home";
  }


}
