package com.blog.advancedmyblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor

public class PostRequestDto {
    private String username;
    private String title;
    private String contents;

}
