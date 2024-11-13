package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.TopicDto;
import com.openclassrooms.mddapi.mapper.TopicMapper;
import com.openclassrooms.mddapi.models.Topic;
import com.openclassrooms.mddapi.services.impl.TopicService;
import com.openclassrooms.mddapi.services.interfaces.ITopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/topic")
@RequiredArgsConstructor
public class TopicController {

    private final ITopicService topicService;
    private final TopicMapper topicMapper;

    @PostMapping
    public ResponseEntity<?> createTopic(@RequestBody final TopicDto topicDto) {
        return ResponseEntity.ok().body(topicService.create(
                topicMapper.toEntity(topicDto)
        ));

    }

    @GetMapping
    public ResponseEntity<?> getAllTopics() {
        List<Topic> topicList = topicService.findAll();
        List<TopicDto> topicDtoList = topicList.stream().map(topicMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok().body(topicDtoList);
    }


}
