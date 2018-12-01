package com.poto.anlab.service.impl;

import com.poto.anlab.mapper.UserMapper;
import com.poto.anlab.model.AnlabUser;
import com.poto.anlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;
    public List<AnlabUser> getAllUsers(){
        return  userDao.getUsers();
    }

}
