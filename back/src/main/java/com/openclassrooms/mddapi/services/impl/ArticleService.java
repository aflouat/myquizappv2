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
    @Override
    public List<Comment> getAllComments(Long id) {
        return List.of();
    }

    @Override
    public void addComment(Long id, Comment comment) {

        articleRepository.findById(id).ifPresent(article -> {
            article.getComments().add(comment);
            articleRepository.save(article);
        });

    }

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public List<Article> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        for (Article article : articles) {
            article.setComments(commentRepository.findByArticle(article));
        }
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
