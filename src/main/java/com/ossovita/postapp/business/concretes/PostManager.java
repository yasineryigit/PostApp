package com.ossovita.postapp.business.concretes;

import com.ossovita.postapp.business.abstracts.PostService;
import com.ossovita.postapp.core.dataAccess.PostRepository;
import com.ossovita.postapp.core.entities.Category;
import com.ossovita.postapp.core.entities.Post;
import com.ossovita.postapp.core.entities.dto.CreatePostDto;
import com.ossovita.postapp.core.entities.dto.UpdatePostDto;
import com.ossovita.postapp.core.utilities.error.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostManager implements PostService {

    PostRepository postRepository;

    public PostManager(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    @Override
    public Post createPost(CreatePostDto createPostDto) {
        Post post = Post.builder()
                .author(createPostDto.getAuthor())
                .title(createPostDto.getTitle())
                .createdAt(LocalDateTime.now())
                .createdBy(createPostDto.getCreatedBy())
                .text(createPostDto.getText())
                .category(createPostDto.getCategory())
                .build();
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(UpdatePostDto updatePostDto, long postPk) {
        Post postInDB = postRepository.findById(postPk).orElseThrow(() -> new NotFoundException("Post not found by given id"));

        postInDB.setAuthor(updatePostDto.getAuthor());
        postInDB.setTitle(updatePostDto.getTitle());
        postInDB.setUpdatedAt(LocalDateTime.now());
        postInDB.setUpdatedBy(updatePostDto.getUpdatedBy());
        postInDB.setText(updatePostDto.getText());
        postInDB.setCategory(updatePostDto.getCategory());

        return postRepository.save(postInDB);
    }

    @Override
    public Post getPostByPostPk(long postPk) {
        return postRepository.findById(postPk).orElseThrow(() -> new NotFoundException("Post not found by given id"));
    }

    @Override
    public List<Post> getPostsByAuthor(String author) {
        return postRepository.findPostsByAuthor(author);
    }

    @Override
    public List<Post> getPostsByCategory(Category category) {
        return postRepository.findPostsByCategory(category);
    }

    @Override
    public List<Post> getLatestThreePost() {
        return postRepository.findFirst3ByOrderByCreatedAtDesc();
    }

    @Override
    public void deletePostByPostPk(long postPk) {
        postRepository.deleteById(postPk);
    }

}
