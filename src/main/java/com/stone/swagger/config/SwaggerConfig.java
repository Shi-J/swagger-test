package com.stone.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sun.dc.pr.PathStroker;

import java.util.ArrayList;

@Configuration // 添加该注解会自动配置到springboot里面
@EnableSwagger2 //  开启swagger2
public class SwaggerConfig
{


    //  配置swagger的Docket的bean实例
    @Bean
    public Docket docket()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //  groupName 设置分组
                .groupName("shij")
                //  enable 设置启动或者不启动swagger true：启动 false：不启动，则swagger不能再游览器中使用
                .enable(true)
                /*  RequestHandlerSelectors
                    basePackage("包名") 指定swagger扫描的包
                    any() 扫描全部
                    none() 不扫描
                    withClassAnnotation() 扫描类上的注解  参数是一个注解的反射对象
                    withMethodAnnotation() 扫描方法上的注解 参数是一个注解的反射对象
                 */
                .select().apis(RequestHandlerSelectors.basePackage("com.stone.swagger"))
                /*
                    paths过滤什么路径
                     any():过滤全部
                     none(): 全部不过滤
                     regex():正则表达式 过滤
                     ant(): 根据路径过滤  比如.ant("/hello/**") ：意思是只扫描/hello/** 接口
                */
                .paths(PathSelectors.ant("/**")).build()
                ;
    }

    /*
       配置swagger的信息 apiInfo
       String title ：标题
       String description ：描述
       String version ： 版本
       String termsOfServiceUrl：
       Contact contact：作者信息
       String license ：出版社一样的 不需要动
       String licenseUrl：出版社的地址 不需要动
       Collection<VendorExtension> vendorExtensions) {

     */
    private ApiInfo apiInfo()
    {
        /*
            contact作者信息
            name ：姓名
            url：url地址
            email：邮箱
        */
        Contact contact = new Contact("shij", "http://123", "2974743696@qq.com");
        return new ApiInfo(
                "shij - swagger",
                "这是shij 第一次使用swagger",
                "1.0",
                "http://123",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }



    //  创建多个分组
    @Bean
    public Docket docket1(){
       return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
}
