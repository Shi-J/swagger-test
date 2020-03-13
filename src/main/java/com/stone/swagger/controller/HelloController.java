package com.stone.swagger.controller;

import com.stone.swagger.model.Student;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 声明这个类不进行跳转只显示数据
public class HelloController
{
    @GetMapping("/hello")
    public String swaggerHello(){

        return "success";
    }


    //  只要在接口中存在model 就会返回给swagger
    @ApiOperation("我是学生的控制类哦")
    @PostMapping("/student")
    public Student helloStudent(){

        return new Student();
    }
    
    @ApiOperation("我是hello2")
    @PostMapping("/hello2")
    public String swaggerHello2(@ApiParam("姓名信息") String name){

        return "我是"+name;
    }
}
