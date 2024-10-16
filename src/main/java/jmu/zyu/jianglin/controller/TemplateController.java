package jmu.zyu.jianglin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jmu.zyu.jianglin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class TemplateController {


    @Autowired
    UserService userService;

    @GetMapping("")
    @ResponseBody
    public String index_noSlash() {
        System.out.println("at root url");
        return "qwq \n template root without slash!";
    }

//    @GetMapping("/")
//    @ResponseBody
//    public String index_withSlash() {
//        System.out.println("at root url");
//        return "template root wish slash!";
//    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, String username, String password, Model model) {
        if ("root".equals(username) && "123456".equals(password)) {
            userService.login(request.getSession(), "admin");
            return "redirect:/Catalog";
        } else {
            model.addAttribute("message", "Invalid username or password.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        userService.logout(request.getSession());
        return "redirect:/login";
    }


    @GetMapping("/Catalog")
    public String Catalog() { return "Catalog"; }

    @GetMapping("/AdminList/{tablename}")
    public String AdminList(){ return "AdminList"; }

    @GetMapping("/testUpload")
    public String testUpload() { return "testUpload"; }

    @GetMapping("/WorkAlbum")
    public String WorkAlbum() { return "WorkAlbum"; }

    @GetMapping("/ClothingAlbum")
    public String ClothingAlbum() { return "ClothingAlbum"; }

    @GetMapping("/manageAlbum/{typeid}")
    public String manageAlbum(){ return "manageAlbum"; }

    @GetMapping("/manageClothing/{clothing_id}")
    public String manageClothing(){ return "manageClothing"; }

}
