package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.models.Post;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.models.Topic;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import com.openclassrooms.mddapi.services.impl.PostService;
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
    private PostService postService;
    private Comment comment;
    private Post post;
    private User user;

    @BeforeEach
    void setUp() {
        commentService = new CommentService(commentRepository, postService);
        user = User.builder().firstName("John").lastName("Doe").email("test@gmail.com").password("pwd").build();
        Topic topic = Topic.builder().subject("Test Topic").build();

        post = Post.builder().id(1L).topic(topic).title("Tutorial JUnit").
                    content("Avec Maven ou  gradle, JUnit peut être facilement ajouté à votre projet")
                    .author(user).build();

    }

    @Test
    public void testGetAllCommentsByPostId() {
        Comment expectedComment = Comment.builder().text("Le TDD m'intéresse!").post(post).build();
        when(postService.getPostById(1L)).thenReturn(post);
        when(commentRepository.save(expectedComment)).thenReturn(expectedComment);
        Comment actualComment = commentService.addCommentToPost(expectedComment,1L);
        Assertions.assertSame(expectedComment, actualComment);

    }
}
