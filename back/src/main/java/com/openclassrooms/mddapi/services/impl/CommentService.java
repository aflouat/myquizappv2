package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.models.Article;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import com.openclassrooms.mddapi.services.interfaces.IArticleService;
import com.openclassrooms.mddapi.services.interfaces.ICommentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CommentService implements ICommentService {
    private final CommentRepository commentRepository;
    private final IArticleService articleService;

    public List<Comment> getCommentsByArticleId(Long articleId) {
        Article article = articleService.getArticleById(articleId);
        return commentRepository.findByArticle(article);
    }

    @Override
    public Comment addCommentToArticle(Comment comment, Long articleId) {
        Article articleFromDb = articleService.getArticleById(articleId);
        comment.setArticle(articleFromDb);
    return commentRepository.save(comment);
    }


}
