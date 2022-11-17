package com.tweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweet.model.Tweets;

@Repository
public interface TweetRepository extends JpaRepository<Tweets, String>{
}
