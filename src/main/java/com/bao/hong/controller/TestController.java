package com.bao.hong.controller;

import com.bao.hong.service.K2Pool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private K2Pool service;

    @RequestMapping("/getConfig")
    public String getConfig(){

        return null;
    }
}
