package xovr.controllers;

import java.util.List;
import xovr.models.User;
import xovr.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class UserController
 */
@Controller
public class UserController {
	
	@RequestMapping(value="/user/listAll")
	@ResponseBody
	public Iterable<User> fetchAll() {
		Iterable<User> users;
		try {
			users = userDao.getAll();
		} catch (Exception ex) {
		      return null; //"Error fetching all users: " + ex.toString();
	    }
	    return users;
		
	}
  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * Create a new user with an auto-generated id and email and name as passed 
   * values.
   */
  @RequestMapping(value="/user/create")
  @ResponseBody
  public String create(String email, String un, String fn, String pwd) {
    try {
      User user = new User(email, un, fn, pwd);
      userDao.create(user);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created!";
  }
  
  /**
   * Delete the user with the passed id.
   */
  @RequestMapping(value="/user/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * Retrieve the id for the user with the passed email address.
   */
  @RequestMapping(value="/user/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    String name;
    try {
      User user = userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
      name = String.valueOf(user.getFullName());
    }
    catch (Exception ex) {
      return "User not found: " + ex.toString();
    }
    return "The user id is: " + userId + " and name is: " + name;
  }
  
  /**
   * Update the email and the name for the user indentified by the passed id.
   */
  @RequestMapping(value="/user/update")
  @ResponseBody
  public String updateName(long id, String email, String un, String fn, String pwd) {
    try {
      User user = userDao.getById(id);
      user.setEmail(email);
      user.setUserName(un);
      user.setFullName(fn);
      user.setPassword(pwd);
      userDao.update(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  } 

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // Wire the UserDao used inside this controller.
  @Autowired
  private UserDao userDao;
  
} // class UserController
