package br.com.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.workshopmongodb.domains.Comment;
import br.com.workshopmongodb.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

}
