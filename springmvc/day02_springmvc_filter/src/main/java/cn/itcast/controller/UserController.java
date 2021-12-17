package cn.itcast.controller;

import cn.itcast.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException {
        try {
            int a = 10 /0;
        }catch (Exception e){
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询所有用户出现了错误。。。。");
        }
        return "success";
    }
}
