package com.fanyao.elk.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fanyao.elk.dao.Menu;
import com.fanyao.elk.dao.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: bugProvider
 * @date: 2020/2/11 13:39
 * @description:
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Resource
    private MenuMapper menuMapper;

}
