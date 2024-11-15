package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.repositories.TopicRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TopicServiceTest {
    @InjectMocks
    private TopicService topicService;

    @Mock
    private TopicRepository topicRepository;

    @Test
    void create() {
        //when(topicRepository.save(top)).thenAnswer(invocation -> invocation.getArgument(0));
    }

    @Test
    void findAll() {
    }

    @Test
    void findBySubject() {
    }
}