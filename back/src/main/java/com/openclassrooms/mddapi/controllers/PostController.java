package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.CommentDto;
import com.openclassrooms.mddapi.dto.PostDto;
import com.openclassrooms.mddapi.mapper.PostMapper;
import com.openclassrooms.mddapi.models.Post;
import com.openclassrooms.mddapi.services.impl.UserService;
import com.openclassrooms.mddapi.services.interfaces.IPostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController  {


    private final IPostService postService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PostDto postDto, HttpServletRequest request) {

            PostDto savedPostDto = postService.create(postDto );

        return ResponseEntity.ok().body(savedPostDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(postService.getPostById(id));
    }


    @GetMapping
    public ResponseEntity<?> getAllFeeds() {
        return ResponseEntity.ok().body(postService.findAllFeeds());
    }



}
