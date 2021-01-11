package com.huilong.controller;

import com.huilong.controller.vo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;

/**
 * 跨域配置
 * <p>
 * 全局跨域配置 {@link com.huilong.config.MyWebMvcConfigurer#addCorsMappings(CorsRegistry)}
 *
 * @author daocr
 * @date 2021/1/11
 */
@Slf4j
@RestController
@RequestMapping("/cors")
public class CorsController {

    /**
     * 跨域首页
     *
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String handle(Model model) {
        return "cors";
    }


    /**
     * 允许所有的请求
     *
     * @return
     */
    @CrossOrigin
    @GetMapping("/cors-all")
    public Person corsAll() {
        Person person = new Person();
        person.setId(1);
        person.setName("李四");
        return person;
    }

    /**
     * 只允许 domain2.com 域名过来的请求
     *
     * @return
     */
    @CrossOrigin(origins = {"https://domain2.com"})
    @GetMapping("/allow-domain2")
    public Person allowDomain2() {

        Person person = new Person();
        person.setId(1);
        person.setName("李四");
        return person;

    }

}
