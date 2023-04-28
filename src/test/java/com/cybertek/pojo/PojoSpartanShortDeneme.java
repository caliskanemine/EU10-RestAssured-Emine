package com.cybertek.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(value = "id", allowSetters = true)

public class PojoSpartanShortDeneme{
    private int id;
    private  String name;
    private String gender;
    private Long phone;

    public PojoSpartanShortDeneme(int id, String name, String gender, Long phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }


    public PojoSpartanShortDeneme() {

    }
}
