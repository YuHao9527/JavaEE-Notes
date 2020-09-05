package com.yhp.web;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

/**
 * Administrator
 * uploadProject
 * 面向对象面向君  不负代码不负卿
 */
@WebServlet(value = "/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //1.创建对象
        SmartUpload smartUpload = new SmartUpload();
        //2.初始化
        PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, false, 1024 * 5, true);
        smartUpload.initialize(pageContext);
        //3.设置编码方式
        smartUpload.setCharset("utf-8");
        //4.上传
        try {
            smartUpload.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //5.保存文件
        File file = smartUpload.getFiles().getFile(0);
        //6.得到文件的基本信息
        String fileName = file.getFileName();
        //指定服务器保存文件的路径
        String url="uploadfile/"+fileName;
        //保存文件
        try {
            file.saveAs(url,File.SAVEAS_VIRTUAL);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //是否保存成功?--->如果上传成功，则页面中显示该文件
        req.setAttribute("filename",fileName);
        //7.测试:除文件以外的内容如何获取
        String uname = smartUpload.getRequest().getParameter("uname");
        System.out.println("uname="+uname);
        //8.跳转页面
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }
}
