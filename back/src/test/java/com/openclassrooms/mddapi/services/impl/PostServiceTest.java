package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.BaseTestConfig;
import com.openclassrooms.mddapi.dto.PostDto;
import com.openclassrooms.mddapi.models.Post;
import com.openclassrooms.mddapi.models.Topic;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.PostRepository;
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
public class PostServiceTest  {

    @Mock
    PostRepository postRepository;


    @InjectMocks
    PostService postService;
    protected  static User userSubscriber;
    protected static Post post;
    protected  static PostDto postDto;
    protected  static Topic topic;
    {}
    @BeforeEach
    void setUp() {
        {
            userSubscriber = User.builder().id(1L).email("test@gmail.com").firstName("Joseph").lastName("Smith").password("pwd").build();
            post = Post.builder().title("Un livre sur typescript")
                    .content("un langage orienté objet")
                    .topic(Topic.builder().subject("Java").build()).author(userSubscriber).build();
            postDto = PostDto.builder().title("Un livre sur typescript")
                    .content("un langage orienté objet").topicSubject("Java").build();
            topic = Topic.builder().subject("Java").build();
        }
      /*  user = User.builder().firstName("John").lastName("Doe").email("test@gmail.com").password("pwd").build();
        Topic topic = Topic.builder().subject("Test Topic").build();
        post = Post.builder().id(1L).topic(topic).title("Tutorial JUnit").
                content("Avec Maven ou  gradle, JUnit peut être facilement ajouté à votre projet")
                .author(user).build();*/
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
        postRepository.saveAndFlush(post);
        List<Post> expectedPosts = List.of(post);
        when(postRepository.findAll()).thenReturn(List.of(post));
       List<Post> actualPosts = postService.getAllPosts();
        Assertions.assertEquals(expectedPosts, actualPosts);
        verify(postRepository,times(1)).findAll();

    }

    @Test
    public void testCreate_OK() {
        when(postRepository.save(post)).thenReturn(post);
        Post actualPost = postService.create(post);
        Assertions.assertNotNull(actualPost);
        verify(postRepository,times(1)).save(post);
        Assertions.assertEquals(post, actualPost);
    }



}
