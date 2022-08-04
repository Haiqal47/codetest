package com.haiqalrama.codetest.service.impl;

import com.haiqalrama.codetest.dto.user.UserRequestDto;
import com.haiqalrama.codetest.dto.user.UserResponseDto;
import com.haiqalrama.codetest.entity.User;
import com.haiqalrama.codetest.repository.UserRepository;
import com.haiqalrama.codetest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDto> findAll() {
        List<User> all = userRepository.findAll();
        return all.stream().map(this::userToUserResponseDto).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto findOneById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) {
        User newUser = userRequestDtoToUser(userRequestDto);
        User savedUser = userRepository.save(newUser);
        return userToUserResponseDto(savedUser);
    }

    @Override
    public UserResponseDto update(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (userRequestDto.getName() != null) {
            user.setName(userRequestDto.getName());
        }
        User savedUser = userRepository.save(user);
        return userToUserResponseDto(savedUser);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
    }

    private UserResponseDto userToUserResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getName());
    }

    private User userRequestDtoToUser(UserRequestDto userRequestDto) {
        return new User(userRequestDto.getName());
    }
}
