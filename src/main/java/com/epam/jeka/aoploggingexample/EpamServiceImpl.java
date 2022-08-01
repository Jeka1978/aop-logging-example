package com.epam.jeka.aoploggingexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpamServiceImpl implements EpamService {

    @Autowired
    private DanonService danonService;

    @Override
    public void doWork(){
        System.out.println("epam work");
        danonService.work();
    }
}
