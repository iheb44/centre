package com.example.centre.d.occupation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

public class Groupe {
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    @DBRef
    private List<Enfants> Grpenfants;
    @DBRef
    private Responsable resp;
}
