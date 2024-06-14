package com.dauphine.blogger.controllers;

import com.dauphine.blogger.services.PostService;
import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.dto.UpdatePostRequest;
import com.dauphine.blogger.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("api/posts")
public class PostController {
    @Autowired
    private  PostService postService;

    @GetMapping("")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String value) {
        List<Post> posts = postService.getAll();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<Post>> getPostsByCategoryId(@PathVariable UUID categoryId) {
        List<Post> posts = postService.getAllByCategoryId(categoryId);
        if (posts == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(posts);
    }

    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody CreationPostRequest createPostRequestBody) {
        Post post = postService.create(createPostRequestBody.getTitle(), createPostRequestBody.getContent(), createPostRequestBody.getCategoryId());
        return ResponseEntity
                .created(URI.create("v1/posts/" + post.getId()))
                .body(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable UUID id, UpdatePostRequest updatePostRequestBody) {
        try {
            Post updatedPost = postService.update(id, updatePostRequestBody.getTitle(), updatePostRequestBody.getContent());
            if (updatedPost == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedPost);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating post: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable UUID id){
        try {
            boolean deleted = postService.deleteById(id);
            if (deleted) {
                return ResponseEntity.ok().body("Post deleted successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting post: " + e.getMessage());
        }
    }
}
