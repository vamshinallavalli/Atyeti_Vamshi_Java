package com.atyeti.example.model;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private Integer pId;
    private String pName;
    private Float price;
    private Float qty;
}