package com.dauphine.blogger.services;

import com.dauphine.blogger.entity.Category;

import java.util.List;
import java.util.UUID;


public interface CategoryService {

    List<Category> getAll();

    List<Category> getAllByName(String name);

    Category getById(UUID id);

    Category create(String name);

    Category updateName(UUID id, String name);

    boolean deleteById(UUID id);
}
