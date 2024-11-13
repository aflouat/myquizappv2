package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.models.Post;
import com.openclassrooms.mddapi.models.Topic;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.PostRepository;
import com.openclassrooms.mddapi.services.impl.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    PostRepository postRepository;


    @InjectMocks
    PostService postService;
    private Post post;
    private User user;
    @BeforeEach
    void setUp() {
        user = User.builder().firstName("John").lastName("Doe").email("test@gmail.com").password("pwd").build();
        Topic topic = Topic.builder().subject("Test Topic").build();
        post = Post.builder().id(1L).topic(topic).title("Tutorial JUnit").
                content("Avec Maven ou  gradle, JUnit peut être facilement ajouté à votre projet")
                .author(user).build();
    }


    @Test
    public void testSetUp() {
        Assertions.assertTrue(true);

    }

    @Test
    public void testGetPostById() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        Post foundPost = postService.getPostById(1L);
        Assertions.assertEquals(post, foundPost);
        verify(postRepository,times(1)).findById(1L);

    }



    @Test
    public void testGetAllPosts() {
        when(postRepository.findAll()).thenReturn(new ArrayList<Post>());
       List<Post> foundPosts = postService.getAllPosts();
        Assertions.assertEquals(new ArrayList<Post>(), foundPosts);
        verify(postRepository,times(1)).findAll();

    }



}
