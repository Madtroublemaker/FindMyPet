package kz.kbtu.sf.findmypet.service;

import kz.kbtu.sf.findmypet.model.Comment;
import kz.kbtu.sf.findmypet.repository.CommentRepository;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getAllComments();
    Optional<Comment> getCommentById(Long id);
    Comment createComment(Comment comment);
    void deleteComment(Long id);
}
