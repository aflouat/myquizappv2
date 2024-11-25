package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.TopicDto;
import com.openclassrooms.mddapi.services.impl.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/subscription")
@RequiredArgsConstructor
public class SubscriptionController {


    private final SubscriptionService subscriptionService;


    @PostMapping("/{idTopic}")
    public ResponseEntity<?> subscribeUserToTopic(@PathVariable final Long idTopic) {
        subscriptionService.subscribe(idTopic);

        return ResponseEntity.ok().body("Abonnement effectué");

    }
    @DeleteMapping("{idTopic}")
    public ResponseEntity<?> unsubscribeUserFromTopic(@PathVariable final Long idTopic) {
        subscriptionService.unSubscribe(idTopic);
        return ResponseEntity.ok().body("Désabonnement effectué");
    }

    @GetMapping("/topics")
    public ResponseEntity<?> getAllSubscribedTopics() {
        List<TopicDto> topicDtoList = subscriptionService.getSubscribedTopics();
        return ResponseEntity.ok().body(topicDtoList);
    }

}
