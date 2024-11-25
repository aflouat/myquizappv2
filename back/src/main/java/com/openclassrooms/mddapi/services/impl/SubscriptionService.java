package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.dto.TopicDto;
import com.openclassrooms.mddapi.exception.TopicNotFoundException;
import com.openclassrooms.mddapi.mapper.TopicMapper;
import com.openclassrooms.mddapi.models.Subscription;
import com.openclassrooms.mddapi.models.Topic;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.SubscriptionRepository;
import com.openclassrooms.mddapi.services.interfaces.ISubscriptionService;
import com.openclassrooms.mddapi.services.interfaces.ITopicService;
import com.openclassrooms.mddapi.services.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService implements ISubscriptionService {

    private final ITopicService topicService;
    private final IUserService userService;
    private final SubscriptionRepository subscriptionRepository;
    private final TopicMapper topicMapper;

    Logger logger = LoggerFactory.getLogger(SubscriptionService.class);
    @Override
    public void subscribe(Long idTopic) {
        Topic foundTopic = topicService.findById(idTopic);
        if (foundTopic == null) {
            throw new TopicNotFoundException("topic not found");

        }
        User foundUser = userService.getConnectedUser();
        logger.debug("subscribeUserToTopic foundUser = {}", foundUser);
        if (foundUser == null) {
            throw new UsernameNotFoundException("user not found");
        }

        Optional<Subscription> foundSubscription = subscriptionRepository.findByTopicIdAndUserId(idTopic, foundUser.getId());
        if (!foundSubscription.isPresent()) {
            subscriptionRepository.save(Subscription.builder().id(null).topic(foundTopic).user(foundUser).build());
        }

    }

    @Override
    public void unSubscribe(Long idTopic) {
        Topic foundTopic = topicService.findById(idTopic);
        if (foundTopic == null) {
            throw new TopicNotFoundException("topic not found");

        }
        User foundUser = userService.getConnectedUser();

        Optional<Subscription> foundSubscription = subscriptionRepository.findByTopicIdAndUserId(idTopic, foundUser.getId());
        subscriptionRepository.delete(foundSubscription.get());

    }

    @Override
    public List<TopicDto> getSubscribedTopics() {
        User currentUser = userService.getConnectedUser();
        List<Subscription> subscriptionList = subscriptionRepository.findByUserId(currentUser.getId());


        List<TopicDto> topicDtoList = new ArrayList<>();
        for (Subscription subscription : subscriptionList) {
            topicDtoList.add(topicMapper.toDto(subscription.getTopic()));
        }
        return topicDtoList;
    }


}
