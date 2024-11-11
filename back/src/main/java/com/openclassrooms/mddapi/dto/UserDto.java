package com.openclassrooms.mddapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NonNull
    @Size(max = 50)
    @Email
    private String email;

    @NonNull
    @Size(max = 20)
    private String lastName;

    @NonNull
    @Size(max = 20)
    private String firstName;



    @JsonIgnore
    @Size(max = 120)
    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}