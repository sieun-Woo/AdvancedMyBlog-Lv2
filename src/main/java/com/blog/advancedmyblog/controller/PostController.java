package com.blog.advancedmyblog.controller;

import com.blog.advancedmyblog.dto.PostRequestDto;
import com.blog.advancedmyblog.dto.PostResponseDto;
import com.blog.advancedmyblog.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //전체 게시글 목록 조회
    @GetMapping("/posts")
    public ArrayList<PostResponseDto> getPost() {
        return postService.getPost();
    }
    //게시글을 조회
    @GetMapping("/post/{id}")
    public PostResponseDto getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }
    //게시글 작성
    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto, HttpServletRequest request) {
        return postService.createPost(postRequestDto, request);
    }

    //게시글 수정
    @PostMapping("/post/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, HttpServletRequest request) {
        return postService.updatePost(id, postRequestDto, request);
    }

    //게시글 삭제
    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable Long id, HttpServletRequest request) {
        return postService.deletePost(id, request);
    }
}
