package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.models.Article;
import org.springframework.http.ResponseEntity;

public interface IArticleController {
    public ResponseEntity<?> findById(String id);
    public ResponseEntity<?> create(ArticleDto articleDto);
    public ResponseEntity<?> update(String id, ArticleDto articleDto);
    public ResponseEntity<?> findAll();

}
