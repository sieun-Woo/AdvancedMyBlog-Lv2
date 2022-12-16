package com.blog.advancedmyblog.dto;

import com.blog.advancedmyblog.entity.Post;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String contents;



    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.username = post.getUsername();
        this.title  = post.getTitle();
        this.contents = post.getContents();
    }
}
