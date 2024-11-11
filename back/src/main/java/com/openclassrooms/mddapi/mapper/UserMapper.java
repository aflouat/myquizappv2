package com.openclassrooms.mddapi.mapper;


import com.openclassrooms.mddapi.dto.UserDto;
import com.openclassrooms.mddapi.models.User;
import org.mapstruct.Mapper;


@Mapper
public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);

}
