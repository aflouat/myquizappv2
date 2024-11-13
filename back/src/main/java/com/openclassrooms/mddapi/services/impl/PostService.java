package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.models.Post;
import com.openclassrooms.mddapi.repositories.PostRepository;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import com.openclassrooms.mddapi.services.interfaces.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
       return posts;
    }
    public Post getPostById(Long id) {

        return postRepository.findById(id).orElse(null);
    }

    public Post create(Post post) {
        Post postToSave = post;


        postToSave = postRepository.save(postToSave);
        return postRepository.save(post);
    }
    public Post update(Long id, Post post) {
        post.setId(id);
       return postRepository.save(post);
    }

}
