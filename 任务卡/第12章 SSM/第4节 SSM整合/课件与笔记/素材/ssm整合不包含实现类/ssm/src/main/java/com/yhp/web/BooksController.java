package com.yhp.web;

import com.yhp.bean.Books;
import com.yhp.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Administrator
 * ssm
 * 面向对象面向君  不负代码不负卿
 */
@Controller
public class BooksController {

    @Resource
    private BooksService booksService;
    //匹配请求，调取service方法
    @RequestMapping("/getallbooks")
    public String getall(ModelMap map){
        List<Books> books = booksService.getall();
        map.addAttribute("booklist",books);
        return "show";
    }

}
