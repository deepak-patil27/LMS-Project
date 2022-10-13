package com.bridgelabz.admin.dto;

import com.bridgelabz.admin.entity.User;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        super();
        this.message = message;
        this.data = data;
    }
}
