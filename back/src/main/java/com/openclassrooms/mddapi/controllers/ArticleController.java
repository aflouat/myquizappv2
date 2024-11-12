package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.ArticleDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/article")
public class ArticleController implements IArticleController {
    @Override
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ArticleDto articleDto) {


        return null;
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(String id, ArticleDto articleDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }
}
