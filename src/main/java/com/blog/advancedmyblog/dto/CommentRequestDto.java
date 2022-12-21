package com.blog.advancedmyblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor

public class CommentRequestDto {
    private String username;
    private String contents;

}