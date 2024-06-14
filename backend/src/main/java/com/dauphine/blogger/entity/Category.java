package com.dauphine.blogger.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    public Category(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}