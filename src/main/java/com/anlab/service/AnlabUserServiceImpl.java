package com.anlab.service;

import com.anlab.dao.AnlabUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnlabUserServiceImpl implements AnlabUserService {
    @Autowired
    private AnlabUserDao anlabUserDao;
    @Override
    public List<AnlabUserDao> findAll() {
        return null;
    }
}
