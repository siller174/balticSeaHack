package com.baltichack.view.controller;

import com.baltichack.view.entity.Event;
import com.baltichack.view.entity.User;
import com.baltichack.view.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/")
    public Iterable<User> listUsers() {

        return userRepo.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEvent(@RequestParam("Event") User user) {

        userRepo.save(user);

        return "redirect:/";
    }
}
