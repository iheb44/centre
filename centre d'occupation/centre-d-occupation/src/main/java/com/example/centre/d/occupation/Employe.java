package com.example.centre.d.occupation;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Employe extends Personne{
    @Id
    private String id;
    private String salary;
}
