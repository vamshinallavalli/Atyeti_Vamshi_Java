package com.neobank.userservice.mapper;

import com.neobank.userservice.dto.UserDto;
import com.neobank.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}