package com.openclassrooms.mddapi.services.interfaces;

import com.openclassrooms.mddapi.models.Article;
import com.openclassrooms.mddapi.models.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> getCommentsByArticleId(Long articleId) ;
    public Comment addCommentToArticle(Comment comment, Long articleIdS) ;
}
