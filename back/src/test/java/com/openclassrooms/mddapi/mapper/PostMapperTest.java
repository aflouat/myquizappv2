package com.openclassrooms.mddapi.mapper;

import com.openclassrooms.mddapi.BaseTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
public class PostMapperTest extends BaseTestConfig {

    private PostMapper mapper = Mappers.getMapper(PostMapper.class);



    @BeforeEach
    public void setUp() {

    }

    @Test
    public void givenPost_whenPostToMapDtoThenReturnPostDto_OK(){
        Assertions.assertEquals(postDto,
                mapper.mapToPostDto(post));

    }

    @Test
    public void givenPostDto_whenPostDtoToPostThenReturnPost_OK(){
        Assertions.assertEquals(
                post,mapper.mapToPost(postDto));
    }
}
