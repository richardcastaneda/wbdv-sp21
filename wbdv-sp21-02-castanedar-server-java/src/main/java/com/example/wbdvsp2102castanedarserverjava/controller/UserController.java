package com.example.wbdvsp2102castanedarserverjava.controller;

import java.util.ArrayList;
import java.util.List;
import com.example.wbdvsp2102castanedarserverjava.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  static List<User> users = new ArrayList<>();
  static {
    users.add(new User("tlee","Tim","Lee","FACULTY"));
    users.add(new User("alovelace","Alice","Lovelace","FACULTY"));
    users.add(new User("cgarcia", "Charlie","Garcia","STUDENT"));
    users.add(new User("dcraig","Dan","Craig","STUDENT"));
    users.add(new User("sbolivar","Simon", "Bolivar","FACULTY"));
    users.add(new User("izzysb","Israel", "Sanchez-Blanco","Student"));
  }
  @GetMapping("/users")
  public List<User> findAllUsers() {
    return users;
  }
}
