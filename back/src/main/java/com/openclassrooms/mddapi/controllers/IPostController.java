package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.PostDto;
import org.springframework.http.ResponseEntity;

public interface IPostController {
    public ResponseEntity<?> findById(String id);
    public ResponseEntity<?> create(PostDto postDto);
    public ResponseEntity<?> update(String id, PostDto postDto);
    public ResponseEntity<?> findAll();

}
