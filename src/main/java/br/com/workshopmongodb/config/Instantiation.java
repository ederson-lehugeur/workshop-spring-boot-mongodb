package br.com.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.workshopmongodb.domains.Comment;
import br.com.workshopmongodb.domains.Post;
import br.com.workshopmongodb.domains.User;
import br.com.workshopmongodb.dto.AuthorDTO;
import br.com.workshopmongodb.dto.PostDTO;
import br.com.workshopmongodb.repositories.CommentRepository;
import br.com.workshopmongodb.repositories.PostRepository;
import br.com.workshopmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		commentRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(bob));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(bob));

		postRepository.saveAll(Arrays.asList(post1, post2));

		Comment comment1 = new Comment(null, "Boa viagem mano!", sdf.parse("21/03/2018"), new PostDTO(post1), new AuthorDTO(alex));
		Comment comment2 = new Comment(null, "Aproveite", sdf.parse("22/03/2018"), new PostDTO(post1), new AuthorDTO(maria));
		Comment comment3 = new Comment(null, "Tenha um ótimo dia!", sdf.parse("23/03/2018"), new PostDTO(post2), new AuthorDTO(maria));

		commentRepository.saveAll(Arrays.asList(comment1, comment2, comment3));

		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().add(comment3);

		postRepository.saveAll(Arrays.asList(post1, post2));

		bob.getPosts().addAll(Arrays.asList(post1, post2));

		userRepository.save(bob);
	}

}
