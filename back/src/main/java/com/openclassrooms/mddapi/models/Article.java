package com.openclassrooms.mddapi.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @ManyToOne
    private User author;
    private String content;
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;



}
