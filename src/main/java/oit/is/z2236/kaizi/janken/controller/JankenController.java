package oit.is.z2236.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2236.kaizi.janken.model.Janken;
//import oit.is.z2236.kaizi.janken.model.Entry;
import oit.is.z2236.kaizi.janken.model.User;
import oit.is.z2236.kaizi.janken.model.UserMapper;

@Controller
public class JankenController {

  @Autowired
  UserMapper userMapper;

  // @Autowired
  // private Entry room;

  // @GetMapping("/janken")
  // public String janken() {
  // return "janken.html";
  // }

  // @PostMapping("/janken")
  // public String janken(@RequestParam String name, ModelMap model) {
  // // String name = user;
  // model.addAttribute("name", name);
  // room.addUser(name);
  // return "janken.html";
  // }

  // @GetMapping("/janken")
  // public String sample32(ModelMap model, Principal prin) {
  // String loginUser = prin.getName(); // ログインユーザ情報
  // model.addAttribute("login_user", loginUser);
  // this.room.addUser(loginUser);
  // model.addAttribute("room", this.room);
  // return "janken.html";
  // }

  // @Transactional
  // @PostMapping("/janken")
  // public String sample43(ModelMap model, Principal prin) {
  // String loginUser = prin.getName(); // ログインユーザ情報
  // User users = new User();
  // users.setUserName(loginUser);
  // userMapper.insertUser(users);
  // model.addAttribute("users", users);
  // // System.out.println("ID:" + chamber3.getId());
  // return "janken.html";
  // }

  @GetMapping("/janken")
  public String sample42(ModelMap model) {
    ArrayList<User> users = userMapper.selectAllUsers();
    model.addAttribute("users", users);
    return "janken.html";
  }

  @GetMapping("/janken/{param1}")
  public String janken2(@PathVariable String param1, ModelMap model) {
    // String msg1;
    // String msg2;
    // String msg3 = "";

    ArrayList<String> msglist = new ArrayList<>();
    Janken game = new Janken();

    msglist = game.Game(param1);

    // msg1 = "あなたの手 " + param1;
    // msg2 = "相手の手 Gu";

    // if (param1.equals("Gu")) {
    // msg3 = "結果 Draw";
    // } else if (param1.equals("Pa")) {
    // msg3 = "結果 You Win!";
    // } else if (param1.equals("Cyoki")) {
    // msg3 = "結果 You lose";
    // }

    // msglist.add(msg1);
    // msglist.add(msg2);
    // msglist.add(msg3);
    model.addAttribute("msglist", msglist);

    return "janken.html";
  }

}
