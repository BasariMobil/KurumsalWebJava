package com.basari.poc.controller;

import com.basari.poc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @GetMapping("/all-list")
    public List<String> getMenuList(){
        return menuService.getMenuList();
    }


}
