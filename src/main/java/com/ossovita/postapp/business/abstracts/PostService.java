package com.ossovita.postapp.business.abstracts;

import com.ossovita.postapp.core.entities.Category;
import com.ossovita.postapp.core.entities.Post;
import com.ossovita.postapp.core.entities.dto.CreatePostDto;
import com.ossovita.postapp.core.entities.dto.UpdatePostDto;

import java.util.List;

public interface PostService {

    Post createPost(CreatePostDto createPostDto);

    Post updatePost(UpdatePostDto updatePostDto, long postPk);

    Post getPostByPostPk(long postPk);

    List<Post> getPostsByAuthor(String author);

    List<Post> getPostsByCategory(Category category);

    List<Post> getLatestThreePost();

    List<Post> getAllPosts();

    void deletePostByPostPk(long postPk);
}
