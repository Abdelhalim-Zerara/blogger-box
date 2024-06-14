package com.dauphine.blogger.repositories;

import com.dauphine.blogger.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findAllByCategoryId(UUID uuid);

    List<Post> findAllByTitleOrContent(String title, String content);
}