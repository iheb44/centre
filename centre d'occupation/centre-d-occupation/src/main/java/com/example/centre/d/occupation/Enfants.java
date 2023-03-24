package com.example.centre.d.occupation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

public class Enfants {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    @DBRef
    private Responsable Resp;

}
