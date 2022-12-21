package com.blog.advancedmyblog.repository;

import com.blog.advancedmyblog.entity.Comment;
import com.blog.advancedmyblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentByPost(Post post);
}
