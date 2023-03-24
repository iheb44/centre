package com.example.centre.d.occupation;

import org.springframework.data.annotation.Id;

public class Enfants {
    @Id
    private String id;
    private String street;
    private String city;
    private String state;
    private String postalCode;
}
