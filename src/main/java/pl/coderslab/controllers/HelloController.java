package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.*;

@Controller
public class HelloController {



  @GetMapping("/hello")
  @ResponseBody
  public String hello(){
    System.out.println("hello");
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

@GetMapping("/workers")
  public String workersAction(Model model){
 Random random = new Random();
 int rdm = random.nextInt(30)+1;
    Path path1 = Paths.get("/home/marcin/Pobrane/Homework_02/Workers.txt");
  System.out.println(Files.exists(path1));
    try {
      for (String line : Files.readAllLines(path1)) {
        if(line.contains(String.valueOf(rdm))){
          model.addAttribute("worker", line);
          System.out.println(line);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }



    return "workers";

  }


}
