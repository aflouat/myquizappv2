package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.mapper.UserMapper;
import com.openclassrooms.mddapi.services.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
@Controller
@RequiredArgsConstructor
public class UserController {
    //private final UserMapper userMapper;
    private final UserService userService;

}
