package com.yhp.controller;

import com.github.pagehelper.PageInfo;
import com.yhp.bean.Bills;
import com.yhp.bean.Billtype;
import com.yhp.service.BillTypesService;
import com.yhp.service.BillsService;
import com.yhp.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Administrator
 * ssm_project
 * 面向对象面向君  不负代码不负卿
 */
@Controller
public class BillsController {
    @Resource
    private BillTypesService typesService;
    @Resource
    private BillsService billsService;

    //删除操作
    @RequestMapping("/deleteById")
    public void delete(int bid, HttpServletResponse response){
        int i = billsService.deleteByPrimaryKey(bid);
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            if(i>0){
                 writer.print("<script>alert('删除成功');location.href='/gettypes'</script>");
                 return;
            }
            writer.print("<script>alert('删除失败');location.href='/gettypes'</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/findById")
    public String findById(int bid,ModelMap map){
        Bills bills = billsService.selectByPrimaryKey(bid);
        List<Billtype> types = typesService.getTypes();
        map.addAttribute("types",types);
        map.addAttribute("bills",bills);
        return "update";
    }
    //修改
    @RequestMapping("/updateBill")
    public String updateBill(Bills bills){
        int i = billsService.updateByPrimaryKey(bills);
        if(i>0){
            return "redirect:/gettypes";
        }
        return "redirect:/findById?bid="+bills.getId();
    }

    //查询账单类型
    @RequestMapping("/getBillType")
    public String getBillType(ModelMap map){
        List<Billtype> types = typesService.getTypes();
        map.addAttribute("types",types);
        return "add";
    }


//新增账单
    @RequestMapping("/insertBill")
    public String add(Bills bills){
        int insert = billsService.insert(bills);
        if(insert>0){
            return "redirect:/gettypes";//回到主页面:show.jsp
        }
        return "redirect:/getBillType";//重新回到新增页面
    }

    @RequestMapping("/gettypes")
    public String gettypes(ModelMap map){
        //1.查询所有的类型
        List<Billtype> types = typesService.getTypes();
        //2.查询所有的账单
        PageInfo<Bills> info = billsService.getBills(-1, null, null, 1, PageUtil.PAGESIZE);
        //3.保存数据给前台
        map.addAttribute("types",types);
        map.addAttribute("info",info);
        return "show";
    }
    //查询所有的账单
    @RequestMapping("/getAllBills")
    public String getBills(@RequestParam(defaultValue = "1") int index,@RequestParam(defaultValue = "-1") Integer typeid, String begin, String end, ModelMap map){
        PageInfo<Bills> info = billsService.getBills(typeid, begin, end, index, PageUtil.PAGESIZE);
        map.addAttribute("info",info);
        List<Billtype> types = typesService.getTypes();
        map.addAttribute("types",types);
        //数据回显
        //将模糊查询的值再返回给前台
        map.addAttribute("tid",typeid);
        map.addAttribute("begintime",begin);
        map.addAttribute("endtime",end);
        return "show";
    }
}
