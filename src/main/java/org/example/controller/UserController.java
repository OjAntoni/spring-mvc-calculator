package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.example.service.UserValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/auth")
    public String getAuthorization(Model model){
        model.addAttribute("valid", true);
        return "auth";
    }

    @GetMapping("/reg")
    public String getRegistration(Model model){
        model.addAttribute("valid", true);
        return "reg";
    }

    @PostMapping("/reg")
    public String postRegistration(String name, String username, String password, Model model, HttpSession session){
        model.addAttribute("valid", true);
        if(userService.exists(username) || !UserValidatorService.validatePassword(password) || !UserValidatorService.validateUsername(username)){
            model.addAttribute("valid", false);
            return "reg";
        } else {
            User user = new User(0, name, username, password);
            userService.save(user);
            return "auth";
        }
    }

    @PostMapping("/auth")
    public String postAuthorization(String username, String password, HttpSession session, Model model){
        User user = userService.getByUsername(username);
        if( user==null || !user.getPassword().equals(password)){
            model.addAttribute("valid", false);
            return "auth";
        } else {
            session.setAttribute("user",user);
            return "home";
        }
    }

    @PostMapping("/logout")
    public String postLogout(HttpSession session){
        session.invalidate();
        return "home";
    }

}
