package com.food.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Food;
@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

	List<Food> findByFname(String foodname);

}
