package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.dto.CommentDto;
import com.openclassrooms.mddapi.dto.PostDto;
import com.openclassrooms.mddapi.dto.TopicDto;
import com.openclassrooms.mddapi.mapper.CommentMapper;
import com.openclassrooms.mddapi.mapper.PostMapper;
import com.openclassrooms.mddapi.models.Comment;
import com.openclassrooms.mddapi.models.Post;
import com.openclassrooms.mddapi.repositories.PostRepository;
import com.openclassrooms.mddapi.repositories.CommentRepository;
import com.openclassrooms.mddapi.services.interfaces.ICommentService;
import com.openclassrooms.mddapi.services.interfaces.IPostService;
import com.openclassrooms.mddapi.services.interfaces.ISubscriptionService;
import com.openclassrooms.mddapi.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {


    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final IUserService userService;

    private final ISubscriptionService subscriptionService;

    Logger logger = LoggerFactory.getLogger(PostService.class);

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
       return posts;
    }

    @Override
    public List<PostDto> findAllFeeds() {
        List<TopicDto> topicDtoList = subscriptionService.getSubscribedTopics();
        List<PostDto> postDtoList = new ArrayList<>();
        for (TopicDto topicDto : topicDtoList) {
            postDtoList.addAll(
                    postMapper.mapToPostDtoList(
                            postRepository.findByTopicSubject(
                                    topicDto.getSubject())));
        }

        return postDtoList;
    }

    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new RuntimeException("Post not found");
        }

        return postMapper.mapToPostDto(post);
    }

    public PostDto create(PostDto postDtoSave) {

        Post postToSave = this.postMapper.mapToPost(postDtoSave);
        postToSave.setAuthor(userService.getConnectedUser());
        logger.debug("Creating post: {}", postToSave);

        Post savedPost=postRepository.save(postToSave);


         return postMapper.mapToPostDto(savedPost);
    }
    public Post update(Long id, Post post) {
        post.setId(id);
       return postRepository.save(post);
    }
    @Override
    public Post findById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new RuntimeException("Post not found");
        }
        return post;
    }


}
