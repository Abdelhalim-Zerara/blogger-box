package com.dauphine.blogger.repositories;

import com.dauphine.blogger.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    List<Category> findByName(String name);
}
