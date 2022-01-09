package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 传统的文件上传
     */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传.........");
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(path);
        //判断：该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdir();
        }
        //创建工厂对象，Servlet的文件上传对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        //解析request对象，获取上传文件项
        List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
//        System.out.println(fileItemList);
        //遍历文件项
        for (FileItem fileItem : fileItemList) {
            //判断：当前fileItem对象是否是文件上传项
            if (fileItem.isFormField()) {
                //说明是个普通的表单项
            } else {
                //说明是一个上传文件项目
                //获取到上传文件的名称
                String filename = fileItem.getName();
                //把文件的名称设置为唯一值：UUID
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                //完成文件上传
                fileItem.write(new File(path, filename));
                //删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }

    /**
     * 利用SpringMVc框架进行文件上传
     * 后端方法的参数名字必须和前端写的name一致
     * springmvc会自动帮我们删掉临时文件
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传.........");
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(path);
        //判断：该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdir();
        }
        //获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件的名称设置为唯一值：UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
       upload.transferTo(new File(path, filename));
        return "success";
    }
    /**
     * 利用SpringMVc框架进行文件上传
     * 后端方法的参数名字必须和前端写的name一致
     * springmvc会自动帮我们删掉临时文件
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传.........");
        //上传的位置
        String path = "http://localhost:9090/uploads/";
       //获取到上传文件的名字
        String filename= upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"_"+filename;
        //完成跨服务器上传
        //创建客户端对象
        Client client  = Client.create();
        //跟图片服务器进行连接
        WebResoure webResoure = client.resource(path+filename);
        //上传文件
        webResoure.put(upload.getBytes());
        return "success";
    }
}
