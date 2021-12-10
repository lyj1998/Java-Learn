package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }

    @RequestMapping(value = "/testRestMapping", method = {RequestMethod.POST})
    public String testRestMapping(){
        System.out.println("Hello testRestMapping");
        return "success";
    }

}
