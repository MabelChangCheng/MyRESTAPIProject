package com.cici.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//MVC model: model-view-controller 接收用户的HTTP请求
public class HelloController {
    //MVC model: model-view-controller 接收用户的HTTP请求

    //http request mapping


    @RequestMapping("/greeting")
    public Greeting greeting() {
        return new Greeting(1, "This is my content");

    }
    @RequestMapping("/greeting/cici")
    public Greeting greeting2() {
        return new Greeting(2, "This is my 2nd content");

    }
}
