package com.openclassrooms.mddapi.services.interfaces;

import com.openclassrooms.mddapi.models.Article;
import com.openclassrooms.mddapi.models.Comment;

import java.util.List;

public interface IArticleService {
    public List<Article> getAllArticles() ;
    public Article getArticleById(Long id) ;

    public Article create(Article article);
    public Article update(Long id, Article article) ;
    public List<Comment> getAllComments(Long id) ;
    public void addComment(Long id, Comment comment); ;
}
