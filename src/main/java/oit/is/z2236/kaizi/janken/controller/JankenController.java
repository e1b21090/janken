package oit.is.z2236.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  @GetMapping("/janken")
  public String janken() {
    return "janken.html";
  }

  @PostMapping("/janken")
  public String janken(@RequestParam String name, ModelMap model) {
    // String name = user;
    model.addAttribute("name", name);
    return "janken.html";
  }

  @GetMapping("/janken2/{param1}")
  public String sample22(@PathVariable String param1, ModelMap model) {
    String msg1;
    String msg2;
    String msg3 = "";

    msg1 = "あなたの手 " + param1;
    msg2 = "相手の手 Gu";

    if (param1.equals("Gu")) {
      msg3 = "結果 Draw";
    } else if (param1.equals("Pa")) {
      msg3 = "結果 You Win!";
    } else if (param1.equals("Cyoki")) {
      msg3 = "結果 You lose";
    }

    model.addAttribute("msg1", msg1);
    model.addAttribute("msg2", msg2);
    model.addAttribute("msg3", msg3);

    return "janken.html";
  }

}
