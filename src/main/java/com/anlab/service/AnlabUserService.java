package com.anlab.service;

import com.anlab.dao.AnlabUserDao;

import java.util.List;

public interface AnlabUserService {
    List<AnlabUserDao> findAll();
}
