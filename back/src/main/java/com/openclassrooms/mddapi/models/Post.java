package com.openclassrooms.mddapi.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @ManyToOne
    private User author;
    private String content;

    @ManyToOne
    private Topic topic;



}
