package com.lxs.travel.controller;

import com.github.pagehelper.PageInfo;
import com.lxs.travel.domain.Category;
import com.lxs.travel.domain.Route;
import com.lxs.travel.domain.Seller;
import com.lxs.travel.service.CategoryService;
import com.lxs.travel.service.RouteService;
import com.lxs.travel.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/route/")
public class RouteController {

    @Autowired
    private RouteService routeService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SellerService sellerService;

    /**
     * 分页
     * @param route
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping("/page")
    public String page(
            Route route,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            Model model) {
        PageInfo<Route> page = routeService.findPage(route, pageNum, pageSize);
        model.addAttribute("page", page);

        //查询所有分类生成下拉框
        List<Category> categories = categoryService.find();
        model.addAttribute("categories", categories);
        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers", sellers);

        //用于页面回显
        model.addAttribute("route", route);

        return "route/list";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        routeService.delete(id);
        return "redirect:/admin/route/page";
    }

    /**
     * 跳到添加页面
     * @param model
     * @return
     */
    @RequestMapping("/toadd")
    public String toAdd(Model model) {
        //查询所有分类生成下拉框
        List<Category> categories = categoryService.find();
        model.addAttribute("categories", categories);
        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers", sellers);

        return "route/add";
    }

    /**
     * 执行添加
     * @param route
     * @param rimageFile
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/doadd")
    public String doAdd(Route route, @RequestParam("rimageFile") MultipartFile rimageFile, HttpServletRequest request) throws IOException {
        routeService.add(route);
        return "redirect:/admin/route/page";
    }

    /**
     * 根据id查询，跳转到修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable Integer id, Model model) {
        //查询所有分类生成下拉框
        List<Category> categories = categoryService.find();
        model.addAttribute("categories", categories);
        List<Seller> sellers = sellerService.find(new Seller());
        model.addAttribute("sellers", sellers);

        Route route = routeService.findById(id);
        model.addAttribute("route", route);

        return "route/update";
    }

    @RequestMapping("/doupdate")
    public String doUpdate(Route route, @RequestParam("rimageFile") MultipartFile rimageFile, HttpServletRequest request) throws IOException {
        routeService.update(route);
        return "redirect:/admin/route/page";
    }

}
