package org.example.PP_3_1_2_SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.example.PP_3_1_2_SpringBoot.entity.User;
import org.example.PP_3_1_2_SpringBoot.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "edit-user";
    }

    @PostMapping
    public String updateUser(@ModelAttribute("user") User user) {
        if (user.getId() > 0)
            userService.updateUser(user);
        else userService.saveUser(user);
        return "redirect:/";
    }
}

