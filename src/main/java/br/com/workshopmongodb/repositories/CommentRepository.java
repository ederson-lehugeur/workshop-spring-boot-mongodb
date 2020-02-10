package br.com.workshopmongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.workshopmongodb.domains.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

	List<Comment> findByTextContaining(String text);
}
