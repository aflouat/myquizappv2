package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.models.Article;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.models.Topic;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import com.openclassrooms.mddapi.services.impl.ArticleService;
import com.openclassrooms.mddapi.services.impl.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {
    @Mock
    private CommentRepository commentRepository;
    @InjectMocks
    private CommentService commentService;
    @Mock
    private ArticleService articleService;
    private Comment comment;
    private Article article;
    private User user;

    @BeforeEach
    void setUp() {
        commentService = new CommentService(commentRepository, articleService);
        user = User.builder().firstName("John").lastName("Doe").email("test@gmail.com").password("pwd").build();
        Topic topic = Topic.builder().title("Test Topic").build();

        article = Article.builder().id(1L).topic(topic).title("Tutorial JUnit").
                    content("Avec Maven ou  gradle, JUnit peut être facilement ajouté à votre projet")
                    .author(user).build();

    }

    @Test
    public void testGetAllCommentsByArticleId() {
        Comment expectedComment = Comment.builder().text("Le TDD m'intéresse!").article(article).build();
        when(articleService.getArticleById(1L)).thenReturn(article);
        when(commentRepository.save(expectedComment)).thenReturn(expectedComment);
        Comment actualComment = commentService.addCommentToArticle(expectedComment,1L);
        Assertions.assertSame(expectedComment, actualComment);

    }
}
