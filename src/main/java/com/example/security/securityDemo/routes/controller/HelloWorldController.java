package com.example.security.securityDemo.routes.controller;

import com.example.security.securityDemo.User.Model.User;
import com.example.security.securityDemo.User.Repository.UserRepository;
import com.example.security.securityDemo.routes.dto.HelloWorldDTO;
import com.example.security.securityDemo.routes.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/helloworld")
public class HelloWorldController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/v1/HelloWorld")
    public @ResponseBody HelloWorldDTO getHelloWorld(){
        HelloWorldDTO helloWorldDTO = new HelloWorldDTO();
        helloWorldDTO.setStr("Hello World");
        return helloWorldDTO;
    }
    @PostMapping("/signup")
    public @ResponseBody UserDTO getHelloWorld(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setLogin(userDTO.getLogin());
        user.setName(userDTO.getName());
        user.setPassword(encodePassword(userDTO.getPassword()));
        userRepository.save(user);
        return userDTO;
    }

    private String encodePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
