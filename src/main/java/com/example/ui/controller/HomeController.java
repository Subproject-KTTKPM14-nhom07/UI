package com.example.ui.controller;

import com.example.ui.dao.DaoPost;
import com.example.ui.dao.DaoUser;
import com.example.ui.entity.Post;
import com.example.ui.entity.User;
import com.example.ui.entity.VO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/home")
@Slf4j
public class HomeController {

    @Autowired
    private DaoUser daoUser;

    @Autowired
    private DaoPost daoPost;

    @GetMapping("/")
    public String home(HttpServletRequest httpServletRequest, Model model){
        String token = "";
        User user = null;
        if(httpServletRequest.getCookies() == null){
            return "redirect:/login";
        }
        for (Cookie cookie : httpServletRequest.getCookies()) {
            if(cookie.getName().equals("token")){
                token = cookie.getValue();
            }
        }
//        log.info(token);
        if(token != ""){
            user = daoUser.checkUserJWT(token);
        }
        if(user == null){
            return "redirect:/login";

        }
        List<VO> list = daoPost.getAllPosts();
        model.addAttribute("listAllPosts",list);
        model.addAttribute("userId",user.getId());
        return "Home";
    }


    @PostMapping("/summit")
    public String summit(@ModelAttribute("post") Post post, Model theModel, HttpServletResponse response){

//        String userId = theModel.getAttribute("userId").toString();
//        log.info(userId);
//        post.setId(Long.parseLong(userId));

        Post post1 = daoPost.savePost(post);

        return "redirect:/home/";

    }
}
