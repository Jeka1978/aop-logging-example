package com.epam.jeka.aoploggingexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DanonService {


    @Autowired
    private DanonService proxy;

    @Benchmark
    public void doStuff(){
        System.out.println("STUFF");
    }

    public void work() {
        System.out.println("danon is working");
        proxy.doStuff();

    }
}
