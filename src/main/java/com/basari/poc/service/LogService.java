package com.basari.poc.service;

import com.basari.poc.entity.LogEntity;
import com.basari.poc.entity.MenuEntity;
import com.basari.poc.ex.RuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LogService {

    @Autowired
    private LogEntity.Repository repository;




    public void createLog(String functionName, String parameters){
        try {
            LogEntity log = new LogEntity();
            log.setProcessName(functionName);
            log.setProcessTime(System.currentTimeMillis());
            log.setParameters(parameters);
            repository.save(log);
        }catch (Exception e){
            throw new RuntimeException("Log could not created for '" + functionName + "' function!");
        }
    }


    public void deleteAll(){
        repository.deleteAll();
        createLog("Log Delete All", null);
    }


}
