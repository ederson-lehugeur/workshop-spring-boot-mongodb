package br.com.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.workshopmongodb.domains.User;
import br.com.workshopmongodb.dto.UserDTO;
import br.com.workshopmongodb.repositories.UserRepository;
import br.com.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}

}
