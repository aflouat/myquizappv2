package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.dto.TopicDto;
import com.openclassrooms.mddapi.exception.TopicNotFoundException;
import com.openclassrooms.mddapi.mapper.TopicMapper;
import com.openclassrooms.mddapi.models.Topic;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.TopicRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.services.interfaces.ITopicService;
import com.openclassrooms.mddapi.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicService implements ITopicService {


    private final TopicRepository topicRepository;
    private final TopicMapper  topicMapper;



    Logger logger = LoggerFactory.getLogger(TopicService.class);



    public TopicDto create(TopicDto topicDto) {
        return topicMapper.toDto(
                topicRepository.save(topicMapper.toEntity(topicDto)));
    }
@Override
    public Topic findById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }
    public List<TopicDto> findAll() {
        List<Topic> topics = topicRepository.findAll();
        List<TopicDto> topicDtoList = topics.stream().map(topicMapper::toDto).collect(Collectors.toList());

        return topicDtoList;
    }
    public Topic findBySubject(String subject) {
        return topicRepository.findBySubject( subject);
    }
}
