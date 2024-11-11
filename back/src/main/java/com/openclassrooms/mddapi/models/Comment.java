package com.openclassrooms.mddapi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Builder
public class Comment{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        @NotNull
        @Size(min = 3)
        String text;

        @ManyToOne
        @JoinColumn(name = "article_id")
        Article article;
}