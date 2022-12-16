package com.blog.advancedmyblog.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Setter
@Getter
public class SignupRequestDto {
    @Size(min = 4, max = 10)
    @Pattern(regexp = "^[0-9a-z]*$")
    private String username;

    @Size(min = 8, max = 15)
    @Pattern(regexp = "^[0-9a-zA-Z]*$")
    private String password;


}
