package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import com.openclassrooms.mddapi.services.interfaces.ICommentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CommentService implements ICommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }


}
