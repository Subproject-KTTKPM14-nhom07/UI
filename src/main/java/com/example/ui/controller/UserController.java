package com.example.ui.controller;

import com.example.ui.dao.DaoPost;
import com.example.ui.dao.DaoUser;
import com.example.ui.entity.User;
import com.example.ui.entity.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private DaoUser daoUser;
    @Autowired
    private DaoPost daoPost;

    @GetMapping("/profile")
    public String getProfile(@RequestParam("userId") Long userId, Model theModel){

        User user = daoUser.getUserById(userId);

        List<VO> list = daoPost.getPostByUserId(userId);
        theModel.addAttribute("user",user);
        theModel.addAttribute("list",list);
        return "Profile";

    }
}
