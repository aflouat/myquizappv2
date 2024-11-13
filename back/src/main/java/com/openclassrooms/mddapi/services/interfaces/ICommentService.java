package com.openclassrooms.mddapi.services.interfaces;

import com.openclassrooms.mddapi.models.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> getCommentsByPostId(Long postId) ;
    public Comment addCommentToPost(Comment comment, Long postId) ;
}
