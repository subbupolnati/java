package com.food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.food.model.Food;
import com.food.repo.FoodRepository;

@Service
public class FoodService {
	@Autowired
	private FoodRepository fr;

	public FoodRepository getFr() {
		return fr;
	}

	public void setFr(FoodRepository fr) {
		this.fr = fr;
	}
	public Food insert(Food f) {
		return fr.save(f);
	}
	public Food update(int id) {
		Optional<Food> optional = fr.findById(id);
        Food food = null;
        if (optional.isPresent())
            food = optional.get();
        else
            throw new RuntimeException(
                "Food not found for id : " + id);
        return food;
	}
	public void delete(int id) {
		fr.deleteById(id);
	}
	public List<Food> getFood(){
		List<Food> f=fr.findAll();
		return f;
	}
	public List<Food>search(String fname){
		return fr.findByFname(fname);
	}
}
