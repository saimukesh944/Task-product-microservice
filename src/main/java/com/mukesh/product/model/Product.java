package com.mukesh.product.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Document(value="product")
public class Product {
    @Id
    private int id;
    private String name;
    private String description;
    private float price;



}
