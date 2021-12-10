package com.example.ui.controller;

import com.example.ui.dao.DaoUser;
import com.example.ui.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/")
@Slf4j
public class LoginController {

    @Autowired
    private DaoUser daoUser;

    @GetMapping("/register")
    public String getRegister(){
        return "DangKy";
    }

    @GetMapping("/login")
    public String getLogin(Model theModel,@RequestParam(required=false,name = "error") String error ){
        theModel.addAttribute("error",error);
//        if (error != null)
//            theModel.addAttribute("error", "Your username and password is invalid.");
        return "DangNhap";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model theModel, HttpServletResponse response){
        theModel.addAttribute("error","");
        String rs = daoUser.login(user);
        
        if(rs.equalsIgnoreCase("Wrong username and password") || rs.equalsIgnoreCase("Server Error")){
//            theModel.addAttribute("error",rs);
            return "redirect:/login?error=" + rs;
        }else {
            response.addCookie(new Cookie("token",rs ));
            return "redirect:/home/";
        }


    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model theModel, HttpServletResponse response){


        User user1 = daoUser.saveUser(user);

        String rs = daoUser.login(user1);

        response.addCookie(new Cookie("token",rs ));
        return "redirect:/home/";

    }

}
