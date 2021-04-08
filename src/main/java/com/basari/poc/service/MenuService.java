package com.basari.poc.service;

import com.basari.poc.entity.MenuEntity;
import com.basari.poc.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuService {

    @Autowired
    private MenuEntity.Repository repository;

    @Autowired
    private LogService logService;




    public MenuEntity createMenu(String name){
        MenuEntity menu = new MenuEntity();
        menu.setName(name);
        menu = repository.save(menu);
        logService.createLog("Menu Create", name);
        return menu;
    }

    public List<String> getMenuList(){
        return repository.findAll().stream().map(this::getMenuName).collect(Collectors.toList());
    }

    public String getMenuName(MenuEntity menuEntity){
        return menuEntity.getName();
    }

    public void deleteAll(){
        repository.deleteAll();
        logService.createLog("Menu Delete All", null);
    }

    public void delete(MenuEntity menuEntity){
        repository.delete(menuEntity);
    }


}
