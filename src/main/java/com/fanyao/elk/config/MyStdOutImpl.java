package com.fanyao.elk.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;

/**
 * @author: bugProvider
 * @date: 2021/3/3 14:43
 * @description: 执行sql打印并记录到日志文件里
 */
@Slf4j
public class MyStdOutImpl implements Log {
    public MyStdOutImpl(String clazz) {
        log.debug("StdOutImpl::{}", clazz);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void error(String s, Throwable e) {
        log.error("StdOutImpl:::{}", s);
        e.printStackTrace(System.err);
    }

    @Override
    public void error(String s) {
        log.error("StdOutImpl:::{}", s);
    }

    @Override
    public void debug(String s) {
        log.debug("StdOutImpl:::{}", s);
    }

    @Override
    public void trace(String s) {
        log.trace("StdOutImpl:::{}", s);
    }

    @Override
    public void warn(String s) {
        log.warn("StdOutImpl:::{}", s);
    }
}

