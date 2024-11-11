package com.openclassrooms.mddapi.services.impl;

import com.openclassrooms.mddapi.dto.UserDto;
import com.openclassrooms.mddapi.mapper.UserMapper;
import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtServiceImpl jwtServiceImpl;
    private final AuthenticationManager authManager;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private UserMapper userMapper;

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);

    }
    public User update(User user) {
        return userRepository.save(user);
    }
    public void delete(int id) {
        userRepository.deleteById(id);
    }
    public UserDto fetchUserDTOByToken(String token) {
        String email = jwtServiceImpl.extractEmail(token);
        User user = userRepository.findByEmail(email);
        return  userMapper.userToUserDto(user);
    }
    public User fetchUserByToken(String token) {
        String email = jwtServiceImpl.extractEmail(token);
        User user = userRepository.findByEmail(email);
        return  user;
    }

}
