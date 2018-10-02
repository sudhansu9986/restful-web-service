package com.sudhansu.rest.webservices.restfulwebservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	PostRepository postRepository;
	@Autowired
	CommentRepository commentRepository;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public Post createPost(@RequestBody Post post) {
		return postRepository.save(post);
	}

	@GetMapping("")
	public PostBuilder listPosts() {
		PostBuilder postBuilder = new PostBuilder();
		postBuilder.getPosts().addAll(postRepository.findAll());
		return postBuilder;
	}

	@GetMapping(value = "/{id}")
	public Post getPost(@PathVariable("id") Integer id) {
		return postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No post found with id=" + id));
	}

	@PutMapping("/{id}")
	public Post updatePost(@PathVariable("id") Integer id, @RequestBody Post post) {
		postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No post found with id=" + id));
		return postRepository.save(post);
	}

	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable("id") Integer id) {
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No post found with id=" + id));
		postRepository.deleteById(post.getId());
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/{id}/comments")
	public void createPostComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {
		Post post = postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No post found with id=" + id));
		post.getComments().add(comment);
	}

	@DeleteMapping("/{postId}/comments/{commentId}")
	public void deletePostComment(@PathVariable("postId") Integer postId,
			@PathVariable("commentId") Integer commentId) {
		commentRepository.deleteById(commentId);
	}

	/*@PostMapping("")
	public ResponseEntity<Post> createPost(@RequestBody @Valid Post post, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(post, HttpStatus.BAD_REQUEST);
		}
		Post savedPost = postRepository.save(post);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader1", "MyValue1");
		responseHeaders.set("MyResponseHeader2", "MyValue2");
		return new ResponseEntity<>(savedPost, responseHeaders, HttpStatus.CREATED);
	}*/
	
	

}
