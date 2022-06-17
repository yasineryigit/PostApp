package com.ossovita.postapp.core.dataAccess;

import com.ossovita.postapp.core.entities.Category;
import com.ossovita.postapp.core.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostsByAuthor(String author);

    List<Post> findPostsByCategory(Category category);

    List<Post> findFirst3ByOrderByCreatedAtDesc();
}
