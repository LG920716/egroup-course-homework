package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {
     
    @GetMapping("/test")
    @ResponseBody //如果是直接用裡面的內容就可以用這個 但如果是網頁的話這個要拿掉
    public String index() {
        return "<h1>Hi this is Test!</h1>";
    }

    @GetMapping("/Customer")
    public String getCustomer() {
        return "customer.html";
    }

    @GetMapping("/test/request")
    @ResponseBody
    //1 public String request(HttpServletRequest request){
    //2 public String request(@RequestParam(value = "id", required = false, defaultValue = "world") String name){
    public String request(@ModelAttribute("id") String name){
        //1 String name = request.getParameter("id");
        return name;
    }
}
