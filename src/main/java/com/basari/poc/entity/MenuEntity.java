package com.basari.poc.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Document(collection="menu")
@Getter
@Setter
public class MenuEntity {

    @Id
    public String id;

    public String name;


    public interface Repository extends MongoRepository<MenuEntity, String> {

        Optional<MenuEntity> findFirstByName(String name);

    }

}
