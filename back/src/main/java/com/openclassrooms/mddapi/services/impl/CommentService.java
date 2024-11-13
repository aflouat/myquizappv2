package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.models.Post;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import com.openclassrooms.mddapi.services.interfaces.IPostService;
import com.openclassrooms.mddapi.services.interfaces.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CommentService implements ICommentService {
    private final CommentRepository commentRepository;
    private final IPostService postService;

    public List<Comment> getCommentsByPostId(Long postId) {
        Post post = postService.getPostById(postId);
        return commentRepository.findByPost(post);
    }

    @Override
    public Comment addCommentToPost(Comment comment, Long postId) {
        Post postFromDb = postService.getPostById(postId);
        comment.setPost(postFromDb);
    return commentRepository.save(comment);
    }


}
