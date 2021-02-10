package com.example.wbdvsp2102castanedarserverjava.models;

public class User {
  private long id;
  private String username;
  private String firstName;
  private String lastName;

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getFirstName() {
    return firstName;
  }

  public User(String username, String firstName, String lastName, String Role) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
  }
   public User(){

   }

}
