package com.fanyao.elk.controller;

import com.fanyao.elk.dao.Menu;
import com.fanyao.elk.dto.PostDTO;
import com.fanyao.elk.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: bugProvider
 * @date: 2021/3/2 13:28
 * @description:
 */
@Slf4j
@RestController
public class HelloController {
    @Autowired
    private IMenuService menuService;

    @GetMapping("/hello")
    public void hello() {
        log.debug("hello logstash slf4j debug 中文!");
        log.info("hello logstash slf4j info 中文!");
        log.warn("hello logstash slf4j warn 中文!");
        log.error("hello logstash slf4j error 中文!");
    }

    @GetMapping("/mybatis")
    public String test(@RequestParam String data) {
        Menu menu = menuService.getById("1");
        System.out.println(menu);

        return "return mybatis";
    }

    @PostMapping("/post")
    public String testPost(@RequestBody PostDTO postDTO) {
        return "return post";
    }
}
