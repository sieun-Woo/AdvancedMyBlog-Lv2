package com.blog.advancedmyblog.service;

import com.blog.advancedmyblog.Jwt.JwtUtil;
import com.blog.advancedmyblog.dto.PostRequestDto;
import com.blog.advancedmyblog.dto.PostResponseDto;
import com.blog.advancedmyblog.entity.Post;
import com.blog.advancedmyblog.entity.User;
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
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    // 게시글 작성하기
    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto, HttpServletRequest request) {
        // Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

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
            Post post = postRepository.saveAndFlush(new Post(requestDto, user.getUsername()));

            return new PostResponseDto(post);
        } else {
            return null;
        }
    }

    // 전체 게시글 목록 조회하기
    @Transactional(readOnly = true)
    public ArrayList<PostResponseDto> getPost() {
        ArrayList<PostResponseDto> PostResponseDtoList = new ArrayList<>();
        for (Post post : postRepository.findAllByOrderByModifiedAtDesc()) {
            PostResponseDto postResponseDto = new PostResponseDto(post);
            PostResponseDtoList.add(postResponseDto);
        }
        return PostResponseDtoList;
    }

    // 게시글 조회하기
    @Transactional(readOnly = true)
    public PostResponseDto getPostById(Long id) {
        return new PostResponseDto(postRepository.findPostById(id));
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto postRequestDto, HttpServletRequest request) {
        // Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        // 토큰이 있는 경우에만 게시글 수정 가능
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

            // 토큰의 사용자 정보와 게시글의 작성자를 비교
            Post post = postRepository.findPostById(id);
            if(!(post.getUsername().equals(user.getUsername()))) {
                throw new IllegalArgumentException("작성자가 일치하지 않습니다.");
            }
            post.update(postRequestDto);
            return new PostResponseDto(post);
        } else {
            return null;
        }
    }

    public String deletePost(Long id, HttpServletRequest request) {
        // Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        // 토큰이 있는 경우에만 게시글 수정 가능
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

            // 토큰의 사용자 정보와 게시글의 작성자를 비교
            Post post = postRepository.findPostById(id);
            if(!(post.getUsername().equals(user.getUsername()))) {
                throw new IllegalArgumentException("작성자가 일치하지 않습니다.");
            }
            postRepository.delete(post);
            return "게시글이 삭제되었습니다.";
        } else {
            return null;
        }
    }
}
