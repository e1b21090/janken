package oit.is.z2236.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// import oit.is.z2236.kaizi.janken.model.Janken;
import oit.is.z2236.kaizi.janken.model.Entry;

@Controller
public class JankenController {
  @Autowired
  private Entry room;
  // @GetMapping("/janken")
  // public String janken() {
  // return "janken.html";
  // }

  @PostMapping("/janken")
  public String janken(@RequestParam String name, ModelMap model) {
    // String name = user;
    model.addAttribute("name", name);
    room.addUser(name);
    return "janken.html";
  }

  @GetMapping("/janken")
  public String sample32(ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    model.addAttribute("login_user", loginUser);
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    return "janken.html";
  }

  @GetMapping("/janken2/{param1}")
  public String janken2(@PathVariable String param1, ModelMap model) {
    String msg1;
    String msg2;
    String msg3 = "";

    ArrayList<String> msglist = new ArrayList<>();

    msg1 = "あなたの手 " + param1;
    msg2 = "相手の手 Gu";

    if (param1.equals("Gu")) {
      msg3 = "結果 Draw";
    } else if (param1.equals("Pa")) {
      msg3 = "結果 You Win!";
    } else if (param1.equals("Cyoki")) {
      msg3 = "結果 You lose";
    }

    msglist.add(msg1);
    msglist.add(msg2);
    msglist.add(msg3);
    model.addAttribute("msglist", msglist);

    return "janken.html";
  }

}
