package com.blog.advancedmyblog.entity;

import com.blog.advancedmyblog.dto.CommentRequestDto;
import com.blog.advancedmyblog.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;
    @ManyToOne
    @JoinColumn(name = "Post_ID", nullable = false)
    private Post post;

    public Comment(CommentRequestDto requestDto, String username, Post post) {
        this.username = username;
        this.contents = requestDto.getContents();
        this.post = post;
    }
}
