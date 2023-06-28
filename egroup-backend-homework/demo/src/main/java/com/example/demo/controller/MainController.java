package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MainController {
    
    @GetMapping({"/", "/hello"})
    @ResponseBody //像這個他就會找不到
    public String index() {
        return "<h1>Hi</h1>";
    }

    @GetMapping("/request")
    @ResponseBody
    public String request(HttpServletRequest request){
        String name = request.getParameter("id");
        return name;
    }

    @PostMapping("/request")
    @ResponseBody
    public String postRequest(@ModelAttribute Customer customer){
        System.out.println("here");
        return "<div><p>姓名： "+customer.getName()+"</p><p>年齡： "+customer.getAge()+"</p></div>";
    }
}
