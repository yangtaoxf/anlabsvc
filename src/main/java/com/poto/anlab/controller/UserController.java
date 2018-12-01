package com.poto.anlab.controller;

import com.poto.anlab.model.AnlabUser;
import com.poto.anlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<AnlabUser> findAllUsers() {
        return userService.getAllUsers();
    }
}
