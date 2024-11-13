package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.PostDto;
import com.openclassrooms.mddapi.mapper.PostMapper;
import com.openclassrooms.mddapi.models.Post;
import com.openclassrooms.mddapi.services.impl.UserService;
import com.openclassrooms.mddapi.services.interfaces.IPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController implements IPostController {

    private final IPostService postService;
    private final PostMapper postMapper;
    private final UserService userService;
    @Override
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PostDto postDto) {
            Post post = postService.create(
                    this.postMapper.mapToPost(postDto));
           // User author = userService.fetchUserByToken()

        return ResponseEntity.ok().body(this.postMapper.mapToPostDto(post));
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
