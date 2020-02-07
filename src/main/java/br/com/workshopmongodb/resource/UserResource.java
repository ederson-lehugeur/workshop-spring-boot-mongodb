package br.com.workshopmongodb.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.workshopmongodb.domain.User;

@RestController
@RequestMapping(value="users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User(null, "Maria Brow", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");

		List<User> list = new ArrayList<User>();
		list.addAll(Arrays.asList(maria, alex));

		return ResponseEntity.ok().body(list);
	}
}
