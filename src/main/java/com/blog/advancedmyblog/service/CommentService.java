package com.blog.advancedmyblog.service;

import com.blog.advancedmyblog.Jwt.JwtUtil;
import com.blog.advancedmyblog.dto.*;
import com.blog.advancedmyblog.entity.Comment;
import com.blog.advancedmyblog.entity.Post;
import com.blog.advancedmyblog.entity.User;
import com.blog.advancedmyblog.entity.UserRoleEnum;
import com.blog.advancedmyblog.repository.CommentRepository;
import com.blog.advancedmyblog.repository.PostRepository;
import com.blog.advancedmyblog.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    // 댓글 작성하기
    @Transactional
    public CommentResponseDto createPost(Long id, CommentRequestDto requestDto, HttpServletRequest request) {
        // Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;
        Post post = postRepository.findPostById(id);

        // 토큰이 있는 경우에만 게시글 작성 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            // 요청받은 DTO 로 DB에 저장할 객체 만들기
            Comment comment = commentRepository.saveAndFlush(new Comment(requestDto, user.getUsername(), post));

            return new CommentResponseDto(comment);
        } else {
            return null;
        }
    }

//    // 선택한 게시글 수정하기
//    @Transactional
//    public CommentResponseDto updatePost(Long id, CommentRequestDto commentRequestDto, HttpServletRequest request) {
//        // Request에서 Token 가져오기
//        String token = jwtUtil.resolveToken(request);
//        Claims claims;
//
//        // 토큰이 있는 경우에만 게시글 수정 가능
//        if (token != null) {
//            if (jwtUtil.validateToken(token)) {
//                // 토큰에서 사용자 정보 가져오기
//                claims = jwtUtil.getUserInfoFromToken(token);
//            } else {
//                throw new IllegalArgumentException("Token Error");
//            }
//
//            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
//            );
//
//            UserRoleEnum userRoleEnum = user.getRole();
//            Comment comment = commentRepository.findcommentById(id);
//            if (userRoleEnum == UserRoleEnum.USER) {
//                // 토큰의 사용자 정보와 게시글의 작성자를 비교
//                if (!(comment.getUsername().equals(user.getUsername()))) {
//                    throw new IllegalArgumentException("작성자가 일치하지 않습니다.");
//                }
//                comment.update(commentRequestDto);
//                return new CommentResponseDto(comment);
//            } else if (userRoleEnum == UserRoleEnum.ADMIN) {
//                comment.update(commentRequestDto);
//                return new CommentResponseDto(comment);
//            } else
//                return null;
//        } else
//            return null;
//    }

    // 선택한 게시글 삭제하기
//    public StatusResponseDto deletePost(Long id, HttpServletRequest request) {
//        // Request에서 Token 가져오기
//        String token = jwtUtil.resolveToken(request);
//        Claims claims;
//
//        // 토큰이 있는 경우에만 게시글 삭제 가능
//        if (token != null) {
//            if (jwtUtil.validateToken(token)) {
//                // 토큰에서 사용자 정보 가져오기
//                claims = jwtUtil.getUserInfoFromToken(token);
//            } else {
//                throw new IllegalArgumentException("Token Error");
//            }
//
//            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
//            );
//
//            // 토큰의 사용자 정보와 게시글의 작성자를 비교
//            Comment comment = commentRepository.findcommentById(id);
//            UserRoleEnum userRoleEnum = user.getRole();
//            if(userRoleEnum == UserRoleEnum.USER) {
//                if (!(comment.getUsername().equals(user.getUsername()))) {
//                    throw new IllegalArgumentException("작성자가 일치하지 않습니다.");
//                }
//                commentRepository.delete(comment);
//                return new StatusResponseDto("200", "댓글이 삭제되었습니다.");
//            } else if (userRoleEnum == UserRoleEnum.ADMIN) {
//                commentRepository.delete(comment);
//                return new StatusResponseDto("200", "관리자 권한으로 댓글이 삭제되었습니다.");
//            } else
//                return null;
//        } else {
//            return null;
//        }
//    }
}
