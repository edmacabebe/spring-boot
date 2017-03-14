package xovr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "users")
public class User {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  private String email;
  
  @NotNull
  private String userName;
  
  @NotNull
  private String fullName;
  
  @NotNull
  private String password;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  public User() { }

  public User(long id) { 
    this.id = id;
  }

  public User(String email, String userName, String fullName, String password) {
    this.email = email;
    this.userName = userName;
    this.fullName = fullName;
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }
  
  public String getUserName() {
    return userName;
  }

  public void setUserName(String value) {
    this.userName = value;
  }
  
  public String getFullName() {
	return fullName;
  }

  public void setFullName(String value) {
	this.userName = value;
  }
  
  public String getPassword() {
	return password;
  }

  public void setPassword(String value) {
	this.password = value;
  }
  
} // class User
