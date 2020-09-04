package com.yhp.web;

import com.yhp.bean.Users;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Administrator
 * demoAjax
 * 面向对象面向君  不负代码不负卿
 */
@WebServlet(value = "/getuser")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          ///1.接受参数
        String userid=req.getParameter("uid");
        int uid=Integer.parseInt(userid);
        //2.判断是哪个用户对象
        Users users = new Users();
        if(uid==1){
            users.setUserName("张三");
        }
        if(uid==2){
            users.setUserName("李四");
        }
        if(uid==3){
            users.setUserName("王五");
        }
        //3.将对象返回给客户端，需要转换成json格式

        JSONObject jsonObject = JSONObject.fromObject(users);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(jsonObject);


    }
}
