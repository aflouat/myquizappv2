package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.models.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class PostDto {
    private String title;
    private String content;
    private String topicSubject;
    private LocalDateTime createdAt;

}
