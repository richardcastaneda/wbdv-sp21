package com.example.wbdvsp2102castanedarserverjava.controllers;

import com.example.wbdvsp2102castanedarserverjava.models.User;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;

@RestController
public class HttpSessions {

  //@GetMapping("/api/session/set/{attr}/{value}")

  List<User> users = new ArrayList<User>();
  @GetMapping("/api/users/register/{username}/{password}")
  public User register(
      @PathVariable("username") String username,
      @PathVariable("password") String password,
      HttpSession session){
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    session.setAttribute("currentUser", user);
    users.add(user);
    return user;
  }

  @GetMapping("/api/users/profile")
  public User profile(HttpSession session) {
    User currentUser = (User)
    session.getAttribute("currentUser");
    return currentUser;
  }

  @GetMapping("/api/logout")
  public void logout (HttpSession session) {
    session.invalidate();
  }

  @PostMapping("/api/login/{username}/{password}")
  public User login(
      @RequestBody User credentials,
      HttpSession session,
      @PathVariable("username") String username,
      @PathVariable("password") String password) {
    for (User user : users) {
      if (user.getUsername().equals(username) &&
          user.getPassword().equals(password)) {
        session.setAttribute("currentUser", user);
        return user;
      }
    }
    return null;
  }

  public String setSessionAttribute(
      @PathVariable("attr") String attr,
      @PathVariable("value") String value,
      HttpSession session) {
    session.setAttribute(attr, value);
    return attr + "=" + value;
  }

  @GetMapping("/api/session/get/{attr}")
  public String getSessionAttribute(
      @PathVariable ("attr") String attr,
      HttpSession session) {
    return (String)session.getAttribute(attr);
  }
}
