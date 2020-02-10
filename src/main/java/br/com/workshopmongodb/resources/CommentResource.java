package br.com.workshopmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.workshopmongodb.domains.Comment;
import br.com.workshopmongodb.services.CommentService;

@RestController
@RequestMapping(value="comments")
public class CommentResource {

	@Autowired
	private CommentService commentService;

	@GetMapping
	public ResponseEntity<List<Comment>> findAll() {
		List<Comment> comments = commentService.findAll();

		return ResponseEntity.ok().body(comments);
	}

}
