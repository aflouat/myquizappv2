package com.openclassrooms.mddapi.controllers;

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
public class PostController implements IPostController {

    Logger logger = LoggerFactory.getLogger(PostController.class);

    private final IPostService postService;
    private final PostMapper postMapper;

    @Override
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PostDto postDto, HttpServletRequest request) {

        Post postToSave = this.postMapper.mapToPost(postDto,request);
        logger.debug("Creating post: {}", postToSave);
            Post savedPost = postService.create(postToSave );
           // User author = userService.fetchUserByToken()

        return ResponseEntity.ok().body(savedPost);
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(String id, PostDto postDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }
}
