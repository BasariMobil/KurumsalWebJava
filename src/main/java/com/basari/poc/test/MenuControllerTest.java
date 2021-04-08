package com.basari.poc.test;

import com.basari.poc.entity.MenuEntity;
import com.basari.poc.service.MenuService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MenuControllerTest {



    @Autowired
    private MenuService menuService;



    @Test
    public void getAllMenus() {

        List<String> menuList = menuService.getMenuList();
        MenuEntity menu1 = menuService.createMenu("Menu1");
        MenuEntity menu2 = menuService.createMenu("Menu2");
        menuList.add(menu1.getName());
        menuList.add(menu2.getName());
        Assert.assertArrayEquals(menuList.toArray(), menuService.getMenuList().toArray());
        menuService.delete(menu1);
        menuService.delete(menu2);

    }

}


