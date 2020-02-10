package br.com.workshopmongodb.dto;

import java.io.Serializable;

import br.com.workshopmongodb.domains.Post;

public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String title;

	public PostDTO() {}

	public PostDTO(Post post) {
		id = post.getId();
		title = post.getTitle();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
