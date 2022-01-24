package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import web.service.UserService;
import web.model.User;

import java.util.List;
@Transactional
@Controller
public class UserController {



    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ModelAndView allUsers() {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView("users");
        //modelAndView.setViewName("users");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }
    @GetMapping(value = "/edit")
    public ModelAndView GetEditPage(@RequestParam(name="id",required = true) int id) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView("editPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView PostEditPage(@ModelAttribute("user") User user) {
        userService.edit(user);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        //modelAndView.addObject("model", model);
        return modelAndView;
    }

    @GetMapping(value = "/delete")
    public ModelAndView GetDelete(@RequestParam(name="id",required = true) int id) {
        userService.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView GetAdd() {
        User user = userService.add();
        ModelAndView modelAndView = new ModelAndView("addPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
