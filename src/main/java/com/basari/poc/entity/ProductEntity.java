package com.basari.poc.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.persistence.Column;
import java.util.Optional;

@Document(collection="product")
@Getter
@Setter
@ToString
public class ProductEntity {

    @Id
    public String id;

    @Column(unique = true)
    public String phone;

    private String userName;

    private String billPlan;

    private String lineStatus;

    private String paymentType;

    private Integer shortNumber;




    public interface Repository extends MongoRepository<ProductEntity, String> {

        Optional<ProductEntity> findFirstByPhone(String phone);

    }



}
