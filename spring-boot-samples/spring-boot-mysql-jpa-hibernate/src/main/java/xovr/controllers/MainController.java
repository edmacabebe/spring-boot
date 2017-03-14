package xovr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  @RequestMapping("/user")
  @ResponseBody
  public String index() {
    String part_1 =  "non-thymeleaf extension by Edison Macabebe, as an exercise for Cross|Over<p>" +
    		"<table border='1'><tr><th width='10%'>References</th><th width='20%'>Description</th></tr>" +
    		"<tr align='center'><td><a href='https://projects.spring.io/spring-boot/'>spring-boot</a></td><td>Spring Boot</td></tr>" +
    		"<tr align='center'><th><a href='http://blog.netgloo.com/2014/10/27/using-mysql-in-spring-boot-via-spring-data-jpa-and-hibernate/'>netgloo</a></th><th>Netgloo</th></tr>" +
    		"</table><br>" ;
    String part_2 = "<p><textarea rows='4' cols='100%'>" +
    		"* '/user/create?email=[email]&name=[name]': create a new user with an auto-generated id and email\n" +  
    		"\t and name as passed values. \n" + 
    		"* `/user/delete?id=[id]`: delete the user with the passed id. \n" +
    		"* `/user/get-by-email?email=[email]`: retrieve the id for the user with the passed email address.\n" +
    		"</textarea>";
    
    return part_1 + part_2;
  }
  /*
  @RequestMapping("/error")
  @ResponseBody
  public String error() {
	  return "ERROR";
  }
  */

}
