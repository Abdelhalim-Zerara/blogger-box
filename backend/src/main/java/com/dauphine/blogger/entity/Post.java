package com.dauphine.blogger.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "content",length=1000)
    private String content;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Post(String title, String content, Category category) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
        this.category = category;
    }
}