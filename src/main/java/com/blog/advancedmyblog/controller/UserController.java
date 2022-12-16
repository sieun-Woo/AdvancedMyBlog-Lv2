package com.blog.advancedmyblog.controller;

import com.blog.advancedmyblog.dto.LoginRequestDto;
import com.blog.advancedmyblog.dto.StatusResponseDto;
import com.blog.advancedmyblog.dto.SignupRequestDto;
import com.blog.advancedmyblog.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public StatusResponseDto signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);

    }

    @ResponseBody
    @PostMapping("/login")
    public StatusResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        return userService.login(loginRequestDto, response);
    }
}
