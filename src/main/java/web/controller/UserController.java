package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import web.service.UserService;
import web.user.User;

import java.util.List;
@Transactional
@Controller
public class UserController {



    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@RequestMapping(value = "/", method = RequestMethod.GET)
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
        //modelAndView.addObject("user", user);
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

//    @GetMapping(value = "/")
//    //@RequestParam(name = "count", required = false, defaultValue = "5") String count, ModelMap model
//    public String allUsers(ModelMap model){
//        model.addAttribute("userList", userService.allUsers());
//        return "users";
//    }


//    @GetMapping(value = "/edit")
//    public String edit(){
//        return "editPage";
//    }



//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView allUsers() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("users.html");
//        return modelAndView;
//    }
//

//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView allUsers(@RequestParam(defaultValue = "1") int page) {
//        List<User> users = userService.allUsers();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("users");
//        modelAndView.addObject("usersList", users);
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public ModelAndView editPage(@PathVariable("id") int id) {
//        User user = userService.getById(id);
//        ModelAndView modelAndView = new  ModelAndView();
//        modelAndView.setViewName("editPage");
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/edit", method =  RequestMethod.POST)
//    public ModelAndView editUser(@ModelAttribute("user") User user){
//        ModelAndView modelAndView =new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        userService.edit(user);
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public ModelAndView addPage(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editPage");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ModelAndView addUser(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        userService.add(user);
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView deleteUser(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new  ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        User user = userService.getById(id);
//        userService.delete(user);
//        return modelAndView;
//    }



//    private static User user;
//
//    static {
//        user = new User();
//        user.setAge(43);
//        user.setName("Ira");
//        user.setLastName("Razumova");
//    }


}
