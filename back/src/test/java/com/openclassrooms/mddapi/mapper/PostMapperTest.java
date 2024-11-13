package com.openclassrooms.mddapi.mapper;

import com.openclassrooms.mddapi.BaseTestConfig;
import com.openclassrooms.mddapi.services.impl.TopicService;
import com.openclassrooms.mddapi.services.impl.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostMapperTest extends BaseTestConfig {

    @Mock
    private HttpServletRequest request;
    @Mock
    private UserService userService;
    @InjectMocks
    private PostMapper mapper;
    @Mock
    private TopicService topicService;



    @BeforeEach
    public void setUp() {
        when(request.getHeader("Authorization")).thenReturn("token");
        when(userService.fetchUserByToken("token")).thenReturn(userSubscriber);

        when(topicService.findBySubject("Java")).thenReturn(topic);

    }

    @Test
    public void givenPost_whenPostToMapDtoThenReturnPostDto_OK(){
        Assertions.assertEquals(postDto,
                mapper.mapToPostDto(post));

    }

    @Test
    public void givenPostDto_whenPostDtoToPostThenReturnPost_OK(){
        System.out.println(request.getHeader("Authorization"));
        Assertions.assertEquals(
                post,mapper.mapToPost(postDto,request));
    }
}
