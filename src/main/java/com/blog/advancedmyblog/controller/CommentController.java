package com.blog.advancedmyblog.controller;

import com.blog.advancedmyblog.dto.*;
import com.blog.advancedmyblog.service.CommentService;
import com.blog.advancedmyblog.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/post/{id}-comment")
    public CommentResponseDto createPost(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
        return commentService.createPost(id, commentRequestDto, request);
    }

    //댓글 수정
//    @PostMapping("/post/{id}/comment/{commentid}")
//    public CommentResponseDto updatePost(@PathVariable Long id, @PathVariable Long commentidid, @RequestBody CommentRequestDto commentRequestDto, HttpServletRequest request) {
//        return commentService.updatePost(id, commentRequestDto, request);
//    }
//
//    //댓글 삭제
//    @DeleteMapping("/post/{id}/comment/{commentid}")
//    public StatusResponseDto deletePost(@PathVariable Long id, @PathVariable Long commentidid, HttpServletRequest request) {
//        return commentService.deletePost(id, request);
//    }
}
