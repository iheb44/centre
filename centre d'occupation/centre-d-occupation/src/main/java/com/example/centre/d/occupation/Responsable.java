package com.example.centre.d.occupation;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Document
public class Responsable extends Personne{
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String ResponsableNumber;
    @DBRef
    private Groupe groupe;
}
