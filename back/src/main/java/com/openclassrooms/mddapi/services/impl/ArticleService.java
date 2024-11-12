package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.models.Article;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import com.openclassrooms.mddapi.services.interfaces.IArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public List<Article> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
       return articles;
    }
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(Article article) {
        return articleRepository.save(article);
    }
    public Article update(Long id, Article article) {
        article.setId(id);
       return articleRepository.save(article);
    }

}
