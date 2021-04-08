package com.basari.poc.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Document(collection="log")
@Getter
@Setter
public class LogEntity {

    @Id
    public String id;

    public Long processTime;

    private String processName;

    private String parameters;




    public interface Repository extends MongoRepository<LogEntity, String> {


    }

}
