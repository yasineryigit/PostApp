package com.ossovita.postapp.controllers;

import com.ossovita.postapp.business.abstracts.PostService;
import com.ossovita.postapp.core.entities.Category;
import com.ossovita.postapp.core.entities.Post;
import com.ossovita.postapp.core.entities.dto.CreatePostDto;
import com.ossovita.postapp.core.entities.dto.UpdatePostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/posts/{postPk}")
    public Post getPostByPostPk(@PathVariable long postPk) {
        return postService.getPostByPostPk(postPk);
    }

    @PostMapping("/posts")
    public Post createPost(@Validated @RequestBody CreatePostDto createPostDto) {
        return postService.createPost(createPostDto);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PutMapping("/posts/{postPk}")
    public Post updatePost(@Validated @RequestBody UpdatePostDto updatePostDto, @PathVariable long postPk) {
        return postService.updatePost(updatePostDto, postPk);
    }

    @GetMapping("/posts/find-posts-by-author")
    public List<Post> getPostsByAuthor(@RequestParam String author) {
        return postService.getPostsByAuthor(author);
    }

    @GetMapping("/posts/find-posts-by-category")
    public List<Post> getPostsByCategory(@RequestParam Category category) {
        return postService.getPostsByCategory(category);
    }

    @GetMapping("/posts/get-latest-three-post")
    public List<Post> getLatestThreePost(){
        return postService.getLatestThreePost();
    }

    @DeleteMapping("/posts/delete-post-by-postpk/{postPk}")
    public void deletePostByPostPk(@PathVariable long postPk){
        postService.deletePostByPostPk(postPk);
    }


}
