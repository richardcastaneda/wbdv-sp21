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
    users.add(new User(123, "alice", "Alice"));
    users.add(new User(669, "bob", "Bob"));
    users.add(new User(425, "dan", "Dan"));
    users.add(new User(206, "charlie", "Charlie"));
    users.add(new User(253, "isa", "Isa"));
  }
  @GetMapping("/users")
  public List<User> findAllUsers() {
    return users;
  }
}
