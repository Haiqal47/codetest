package com.haiqalrama.codetest.dto;

public class ResponseDto<T> {
    private T data;
    private Integer status;
    private String message;

    public ResponseDto(T data, Integer status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto<>(data, 200, "success");
    }

    public static <T> ResponseDto<T> error(Integer status, String message) {
        return new ResponseDto<>(null, status, message);
    }

    public static <T> ResponseDto<T> created(T data) {
        return new ResponseDto<>(data, 201, "created");
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
