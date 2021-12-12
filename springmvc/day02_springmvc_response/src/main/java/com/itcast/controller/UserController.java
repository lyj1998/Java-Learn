package com.itcast.controller;


import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了......");
        //模拟从数据库中查询一个用户的对象
        User user = new User();
        user.setUsername("hehe");
        user.setAge(40);
        //model对象
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 如果返回值是void，则会默认返回一个跟请求路径同名的jsp页面
     * 而我们显然没有准备这个页面，所以就报404错误了，那么要怎样才能让他返回success.jsp页面呢
     * 我们需要借助原生API：HttpServletRequest request,HttpServletResponse reponse
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了......");
        //①编写请求转发的程序
        //（实际访问的路径跟地址栏的路径一样，没有发生改变）
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //②编写重定向的程序
//        response.sendRedirect(request.getContextPath()+"/user/testRedirect");
        //③直接进行响应，解决中文乱码问题
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("hello");
        return;
    }

    //重定向是会改变地址栏的URL的，所以说重定向是两次请求，而请求转发是一次请求
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect方法执行了......");
        return "success";
    }


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法执行了...");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("哈哈");
        user.setPassword("123");
        user.setAge(21);
        //把user对象存储到mv对象中，它底层会把user对象存入到request域对象中
        mv.addObject("user", user);
        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }
    @RequestMapping("/testForwardOrRedirect1")
    public String testForwardOrRedirect1() {
        System.out.println("testForwardOrRedirect方法执行了...");
        //请求的转发
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testForwardOrRedirect2")
    public String testForwardOrRedirect2() {
        System.out.println("testForwardOrRedirect方法执行了...");
        //重定向
        return "redirect:/user/testRedirect";
    }

   /* @RequestMapping("/testAjax")
    public void testAjax(@RequestBody User user) {
        System.out.println("testAjax方法执行了...");
        //客户端发ajax的请求，传的是json字符串，后端利用jacksonjar包把json字符串封装到user对象中
        System.out.println(user);
    }*/

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax方法执行了...");
        //客户端发送ajax请求，传的是json字符串，后端把json封装到user对象中
        System.out.println(user);
        //模拟查询数据库
        user.setUsername("update");
        user.setAge(23);
        return user;
    }









}
