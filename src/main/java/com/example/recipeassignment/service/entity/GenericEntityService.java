package com.example.recipeassignment.service.entity;

import java.util.List;

public interface GenericEntityService <T, FORM, ID> {
    T create(FORM form);
    T findById(ID Id);
    List<T> findAll();
    T update(ID id, FORM form);
    void delete(ID id);
}
