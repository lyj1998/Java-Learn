package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.cglib.core.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class ParamController {


    @RequestMapping("/saveAccount")
    public String testParam(Account account){
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String testParam(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServlet")
    public String testParam(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request"+request);
        HttpSession session = request.getSession();
        System.out.println("session"+session);
        ServletContext servletContext = session.getServletContext();
        System.out.println("servletContext"+servletContext);
        System.out.println("response"+response);
        return "success";
    }
}
