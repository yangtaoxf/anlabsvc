package com.poto.anlab.controller;

import com.poto.anlab.dao.UserDao;
import com.poto.anlab.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> findOneCity() {
        return userDao.getUsers();
    }
}
