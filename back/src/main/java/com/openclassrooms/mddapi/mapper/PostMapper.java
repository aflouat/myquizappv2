package com.openclassrooms.mddapi.mapper;


import com.openclassrooms.mddapi.dto.PostDto;
import com.openclassrooms.mddapi.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "topic.subject", target = "topicSubject")
    PostDto mapToPostDto(Post post);

    @Mapping(source = "topicSubject", target = "topic.subject")
    Post mapToPost(PostDto postDto);
}