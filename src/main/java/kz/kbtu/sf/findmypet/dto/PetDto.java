package kz.kbtu.sf.findmypet.dto;

import lombok.Data;

@Data
public class PetDto {
    private String name;
    private String type;
    private String breed;
    private int age;
    private String status;
    private String photo;
}
