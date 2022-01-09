package com.itcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//默认下面的方法都是json或者字符串格式的(=Controller+ResponseBody)
@RestController
public class QuickController {

    @RequestMapping("/quick2")
    public String quick(){
        return "springBoot!!!";
    }
}
