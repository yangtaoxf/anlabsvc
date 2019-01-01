package com.poto.anlab.service.impl;

import com.poto.anlab.model.EApplication;
import com.poto.anlab.service.EApplicationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EApplicationServiceImpl implements EApplicationService {


    @Override
    public List<EApplication> getAllApplications() {
        EApplication app1 = new EApplication(1,"ename1","cnname1");
        EApplication app2= new EApplication(2,"ename2","cnname1");
        EApplication app3 = new EApplication(3,"ename3","cnname1");
        return Arrays.asList(app1,app2,app3);
    }
}
