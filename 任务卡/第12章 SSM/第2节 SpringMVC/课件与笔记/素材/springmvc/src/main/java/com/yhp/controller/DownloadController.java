package com.yhp.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Administrator
 * springmvc
 * 面向对象面向君  不负代码不负卿
 */
@Controller
public class DownloadController {
    @RequestMapping("/download")
    public ResponseEntity<byte[]> down(String filename, HttpServletRequest request) throws UnsupportedEncodingException, IOException {
        //1.转换服务器地址
        String realPath = request.getRealPath("/uploadimg");
        //2.得到要下载的文件路径
       String filePath= realPath+"/"+filename;
       //3.设置响应的头信息
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //给用户弹窗的方式进行下载
        //attachment 用来表示以附件的形式响应给客户端
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode(filename,"UTF-8"));
        //4.创建文件
        File file = new File(filePath);
        //5.将文件进行返回
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),httpHeaders, HttpStatus.CREATED);
        return responseEntity;
    }
}
