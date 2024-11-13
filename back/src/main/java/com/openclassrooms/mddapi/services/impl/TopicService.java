package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.models.Topic;
import com.openclassrooms.mddapi.repositories.TopicRepository;
import com.openclassrooms.mddapi.services.interfaces.ITopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService implements ITopicService {
    private final TopicRepository topicRepository;

    public Topic create(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
    public Topic findBySubject(String subject) {
        return topicRepository.findBySubject( subject);
    }
}
