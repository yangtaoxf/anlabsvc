package com.anlab.controller;

import com.anlab.dao.AnlabUserDao;
import com.anlab.model.AnlabUser;
import com.anlab.service.AnlabUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class UserController {
    @Autowired
    private AnlabUserService anlabUserService;
    @RequestMapping("/all")
    public List<AnlabUser> greeting2() {
        AnlabUser user = new AnlabUser(11,"st");
        AnlabUser user2 = new AnlabUser(12,"st2");
        List<AnlabUser> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        return users;
    }
}
