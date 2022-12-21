package com.blog.advancedmyblog.dto;

import com.blog.advancedmyblog.entity.Comment;
import com.blog.advancedmyblog.entity.Post;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String contents;
    private List<Comment> comments;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.username = post.getUsername();
        this.title = post.getTitle();
        this.contents = post.getContents();
    }

    public PostResponseDto(Post post, List<Comment> comments) {
        this.id = post.getId();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.username = post.getUsername();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.comments = comments;
    }

}
