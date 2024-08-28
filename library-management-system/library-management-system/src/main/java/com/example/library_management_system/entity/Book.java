package com.example.library_management_system.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // To be able to create an instance of type book;
@Entity // Adding JPA annotation, which helps, to generate the table by default;
@Table(name = "books") //To update the name of table, we use the table annotation
public class Book {

    @Id // --> Adding primary key using javax persistence.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // --> Key generation strategy
    private Long id;

    private String name;

    private String description;

    private double price;
}
