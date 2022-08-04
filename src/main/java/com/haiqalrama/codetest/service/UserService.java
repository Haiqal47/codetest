package com.haiqalrama.codetest.service;

import com.haiqalrama.codetest.dto.user.UserRequestDto;
import com.haiqalrama.codetest.dto.user.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAll();

    UserResponseDto findOneById(Long id);

    UserResponseDto create(UserRequestDto userRequestDto);

    UserResponseDto update(Long id, UserRequestDto userRequestDto);

    void delete(Long id);
}
