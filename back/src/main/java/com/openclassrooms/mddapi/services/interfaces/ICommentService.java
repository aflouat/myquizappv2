package com.openclassrooms.mddapi.services.interfaces;

import com.openclassrooms.mddapi.models.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> getComments();
    public Comment create(Comment comment);
}
