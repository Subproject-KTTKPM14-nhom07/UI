package com.example.ui.dao;

import com.example.ui.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DaoUser {

    @Autowired
    private RestTemplate restTemplate;

//    public DaoUser() {
//        RestTemplate restTemplate = new RestTemplate();
//        this.restTemplate = restTemplate;
//    }
//
//    public DaoUser(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public User saveUser(User user){

        User user1 = restTemplate.postForObject("http://18.142.162.108:9191/api/register",user,User.class);
        return user1;
    }
//    public List<User> getAllUsers(){
//
//    }

    public User getUserById(Long userId){
        User user1 = restTemplate.getForObject("http://18.142.162.108:9191/user/" + userId,User.class);
        return user1;
    }
//    public boolean deleteUser(Long userId);
//    public User getUserByPhone(String phone){
//        User user1 = restTemplate.getForObject("http://18.136.126.140:8000/user/" + userId,User.class);
//        return user1;
//    }
    public String login(User user){
        String result = restTemplate.postForObject("http://18.142.162.108:9191/api/login",user , String.class);

        return result;
    }

    public User checkUserJWT(String token) {

        User u = new User();
        u.setName(token);
        User user = restTemplate.postForObject("http://18.142.162.108:9191/user/userFromToken", u , User.class);

        return user;
    }
}
