package com.openclassrooms.mddapi.services.interfaces;

import com.openclassrooms.mddapi.models.Topic;

import java.util.List;

public interface ITopicService {
    public Topic create(Topic topic);
    public List<Topic> findAll();
}
