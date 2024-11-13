package com.openclassrooms.mddapi.services.interfaces;

import com.openclassrooms.mddapi.models.Post;

import java.util.List;

public interface IPostService {
    public List<Post> getAllPosts() ;
    public Post getPostById(Long id) ;

    public Post create(Post post) ;
    public Post update(Long id, Post post) ;
}
