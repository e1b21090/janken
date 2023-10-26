package oit.is.z2236.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

//import javax.annotation.processing.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import oit.is.z2236.kaizi.janken.model.Janken;
//import oit.is.z2236.kaizi.janken.model.Entry;
import oit.is.z2236.kaizi.janken.model.User;
import oit.is.z2236.kaizi.janken.model.UserMapper;
import oit.is.z2236.kaizi.janken.model.Match;
import oit.is.z2236.kaizi.janken.model.MatchMapper;
import oit.is.z2236.kaizi.janken.model.MatchInfo;
import oit.is.z2236.kaizi.janken.model.MatchInfoMapper;

@Controller
public class JankenController {

  @Autowired
  UserMapper userMapper;
  @Autowired
  MatchMapper matchMapper;
  @Autowired
  MatchInfoMapper matchInfoMapper;

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

  @GetMapping("/janken")
  public String entryUser(ModelMap model) {
    ArrayList<User> users = userMapper.selectAllUsers();
    ArrayList<Match> matches = matchMapper.selectAllMatches();
    model.addAttribute("matches", matches);
    model.addAttribute("users", users);

    ArrayList<MatchInfo> matchinfo = matchInfoMapper.selectAllByIsActive();
    model.addAttribute("matchinfo", matchinfo);
    return "janken.html";
  }

  @GetMapping("/match")
  public String sample23(@RequestParam Integer id, ModelMap model) {
    User match = userMapper.selectAllById(id);
    model.addAttribute("match", match);
    return "match.html";
  }

  @Transactional
  @GetMapping("/fight")
  public String sample43(@RequestParam Integer hand, @RequestParam Integer id, ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    User user = userMapper.selectByUserName(loginUser);
    MatchInfo matchInfo = new MatchInfo();
    matchInfo.setUser1(user.getId());
    matchInfo.setUser2(id);
    matchInfo.setIsActive(true);

    if (hand == 1) {
      matchInfo.setUser1Hand("Gu");
    } else if (hand == 2) {
      matchInfo.setUser1Hand("Choki");
    } else if (hand == 3) {
      matchInfo.setUser1Hand("Pa");
    }

    matchInfoMapper.insertMatchInfo(matchInfo);

    // users.setUserName(loginUser);
    // userMapper.insertUser(users);
    // model.addAttribute("users", users);
    // System.out.println("ID:" + chamber3.getId());
    return "wait.html";
    }

  // @GetMapping("/janken/{param1}")
  // public String janken2(@PathVariable String param1, ModelMap model) {
  // // String msg1;
  // // String msg2;
  // // String msg3 = "";

  // ArrayList<String> msglist = new ArrayList<>();
  // Janken game = new Janken();

  // msglist = game.Game(param1);

  // // msg1 = "あなたの手 " + param1;
  // // msg2 = "相手の手 Gu";

  // // if (param1.equals("Gu")) {
  // // msg3 = "結果 Draw";
  // // } else if (param1.equals("Pa")) {
  // // msg3 = "結果 You Win!";
  // // } else if (param1.equals("Cyoki")) {
  // // msg3 = "結果 You lose";
  // // }

  // // msglist.add(msg1);
  // // msglist.add(msg2);
  // // msglist.add(msg3);
  // model.addAttribute("msglist", msglist);

  // return "janken.html";
  // }

}
