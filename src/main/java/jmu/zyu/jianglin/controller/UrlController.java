package jmu.zyu.jianglin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jmu.zyu.jianglin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UrlController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "it works!";
    }

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


}
