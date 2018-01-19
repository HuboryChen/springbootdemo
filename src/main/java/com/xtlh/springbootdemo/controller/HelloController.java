package com.xtlh.springbootdemo.controller;

import com.xtlh.springbootdemo.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Autowired
    private PersonProperties personProperties;
    @Value("${name}")
    private String name;

    @Value("${content}")
    private String content;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say()
    {
        //return name+",Hello SpringBoot!"+content;
        return "这是"+personProperties.getName()+personProperties.getAge();
    }
}
