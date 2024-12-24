package com.questionpro.app.grocery.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionpro.app.grocery.entity.GroceryItem;

public interface GroceryItemDao extends JpaRepository<GroceryItem, Long> {

}
