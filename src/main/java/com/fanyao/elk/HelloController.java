package com.fanyao.elk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: bugProvider
 * @date: 2021/3/2 13:28
 * @description:
 */
@Slf4j
@RestController
public class HelloController {
    @GetMapping("/hello")
    public void hello() {
        log.debug("hello logstash slf4j debug 中文!");
        log.info("hello logstash slf4j info 中文!");
        log.warn("hello logstash slf4j warn 中文!");
        log.error("hello logstash slf4j error 中文!");
    }
}
