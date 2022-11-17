package com.seatbooking.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seatbooking.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
