package com.haiqalrama.codetest.dto.user;

public class UserResponseDto {
    private Long id;
    private String name;

    public UserResponseDto() {
    }

    public UserResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
