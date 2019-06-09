package com.lab3.demo.controller;

import com.lab3.demo.response.GreetingResponse;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HelloController {
    @CrossOrigin(origins = "*")
    @RequestMapping("/hello")
    public String index() {
        return "Hello, World!";
    }


    private final AtomicLong counter = new AtomicLong();//用来从 1 开始计数的，每次接口被调用时将 counter 加一
    @RequestMapping("/greeting") //将本接口注册到 /greeting 上
    public @ResponseBody GreetingResponse greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new GreetingResponse(counter.incrementAndGet(), "Hello, " + name + "!");
    }


}
