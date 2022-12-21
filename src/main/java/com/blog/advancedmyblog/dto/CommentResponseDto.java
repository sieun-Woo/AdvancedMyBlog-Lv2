package com.blog.advancedmyblog.dto;

import com.blog.advancedmyblog.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor

public class CommentResponseDto {
    private String username;
    private String contents;

    public CommentResponseDto(Comment comment) {
        this.username = comment.getUsername();
        this.contents = comment.getContents();
    }
}