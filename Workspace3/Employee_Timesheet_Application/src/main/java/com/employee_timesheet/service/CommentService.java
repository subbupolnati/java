package com.employee_timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_timesheet.exception.NotFoundException;
import com.employee_timesheet.model.Comment;
import com.employee_timesheet.repository.CommentRepository;
//in this class perform database logics 
@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	//This method save comments in database using predefined save method  
	public Comment insertComment(Comment comment) {
		return commentRepository.save(comment);
	}
	//this method getting all comments in comment table
	public List<Comment> getAllComments(){
		return commentRepository.findAll();
	}
	//this method getting comment details based on comment id
	public Comment getCommentById(int commentId) {
		//this statement get comment based on id if comment is not available optional is null
		Comment comment=commentRepository.findById(commentId).get();
		//if comment instance not null execute if block other wise it returns comment null;
		if(comment!=null)
			return comment;
		else
            throw new NotFoundException("Comment not found for id : " +commentId);
	}
	//this method update comment based on commentId
	public Comment updateComment(Comment comment,int commentId) {
		Optional<Comment> optional=commentRepository.findById(commentId);
        if (optional.isPresent()) {
            comment.setCommentId(commentId);
            return commentRepository.save(comment);
        }
        else
            throw new NotFoundException("Comment not found for id : " +commentId);
	}
	//In this method delete comment based on id
	public void deleteComment(int commentId) {
		commentRepository.deleteById(commentId);
	}
}
