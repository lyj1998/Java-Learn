package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testParam(@RequestParam(name="name") String username){
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    /**
     * 控制器类的方法有两种写法：有返回值和没有返回值，下面分别演示：
     * 1.有返回值
     * 2.无返回值
     * @param user
     * @return
     */

    /**
   @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }
     * 该方法会先执行（通过用户名就可以查询到其他信息）
     * @return
     */
 /**
    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了...");
        //通过用户名查询数据库(模拟)
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }
   ***/
 @RequestMapping("/testModelAttribute")
 public String testModelAttribute(@ModelAttribute("abc") User user){
     System.out.println("testModelAttribute执行了...");
     System.out.println(user);
     return "success";
 }
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map){
        System.out.println("showUser执行了...");
        //通过用户名查询数据库(模拟)
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes...");
        //底层会存储到reques域对象中
        model.addAttribute("msg","测试测试测试");
        return "success";
    }


    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes...");
      status.setComplete();
        return "success";
    }





    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value = "id") String path){
        System.out.println(path);
        return "success";
    }


}
