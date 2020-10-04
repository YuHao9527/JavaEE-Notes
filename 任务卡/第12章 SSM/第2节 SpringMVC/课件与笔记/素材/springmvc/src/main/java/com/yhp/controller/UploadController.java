package com.yhp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Administrator
 * springmvc
 * 面向对象面向君  不负代码不负卿
 */
@Controller
public class UploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile myfile, HttpServletRequest request){
        //处理上传的文件内容
        //1.将上传的文件夹转换成服务器路径
        String realPath = request.getRealPath("/uploadimg");
        System.out.println("realpath="+realPath);
        //2.得到上传的文件名
        String filename = myfile.getOriginalFilename();
        //3.上传
        try {
            myfile.transferTo(new File(realPath+"/"+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.setAttribute("filename",filename);
        return "uploadsuccess";
    }
}
