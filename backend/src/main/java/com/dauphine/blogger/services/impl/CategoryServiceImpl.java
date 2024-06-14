package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.services.CategoryService;
import com.dauphine.blogger.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category getById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category create(String name) {
        Category category = new Category(name);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateName(UUID id, String name) {
        Category category = getById(id);
        if (category == null) {
            return null;
        }
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteById(UUID id) {
        categoryRepository.deleteById(id);
        return true;
    }
}