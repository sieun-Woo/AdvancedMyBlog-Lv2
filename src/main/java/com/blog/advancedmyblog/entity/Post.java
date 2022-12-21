package com.blog.advancedmyblog.entity;

import com.blog.advancedmyblog.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Post")
@Getter
@RequiredArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @OneToMany
    private List<Comment> Comments = new ArrayList<Comment>();

    public Post(PostRequestDto requestDto, String username) {
        this.username = username;
        this.title  = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(PostRequestDto requestDto)  {
        this.title  = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
