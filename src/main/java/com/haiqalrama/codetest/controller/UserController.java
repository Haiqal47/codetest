package com.haiqalrama.codetest.controller;

import com.haiqalrama.codetest.dto.ResponseDto;
import com.haiqalrama.codetest.dto.user.UserRequestDto;
import com.haiqalrama.codetest.dto.user.UserResponseDto;
import com.haiqalrama.codetest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<UserResponseDto>>> getAllUser() {
        List<UserResponseDto> all = userService.findAll();

        return ResponseEntity.ok(ResponseDto.success(all));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<UserResponseDto>> getUser(@PathVariable Long id) {
        UserResponseDto user = userService.findOneById(id);

        return ResponseEntity.ok(ResponseDto.success(user));
    }

    @PostMapping
    public ResponseEntity<ResponseDto<UserResponseDto>> createNewUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.create(userRequestDto);

        return ResponseEntity.status(201).body(ResponseDto.created(userResponseDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<UserResponseDto>> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto user = userService.update(id, userRequestDto);

        return ResponseEntity.ok(ResponseDto.success(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Long>> deleteUser(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.ok(new ResponseDto<>(null, 200, "deleted"));
    }
}
