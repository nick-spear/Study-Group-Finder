package edu.usm.studygroupfinder.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.usm.studygroupfinder.model.User;
import edu.usm.studygroupfinder.model.Course;

@Controller
public class UserController {

    private static Set<User> userDatabase = new HashSet<>();
    
    static {
        Course Course1 = new Course();
        Course Course2 = new Course();
        User User1 = new User();
        User User2 = new User();
        User User3 = new User();
        
        Course1.setId("COS375");
        Course2.setId("COS285");
        
        User1.setUsername("theDude");
        User1.setName("Nick");
        User1.setPassword("himom");
        User1.addCourse(Course1);
        
        User2.setUsername("theOtherDude");
        User2.setName("John");
        User2.setPassword("wordpass");
        User2.addCourse(Course1);
        User2.addCourse(Course2);
        
        User3.setUsername("theLastDude");
        User3.setName("Bob");
        User3.setPassword("password");
        User3.addCourse(Course2);
        
        userDatabase.add(User1);
        userDatabase.add(User2);
        userDatabase.add(User3);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String userList(Map<String, Object> model) {
        model.put("userDatabase", this.userDatabase);
        
        return "userList";
    }
    
}