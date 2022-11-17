package com.tweet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.model.Tweets;
import com.tweet.repository.TweetRepository;

@Service
public class TweetService {

	@Autowired
	TweetRepository tr;
	int tweetCount=0;
	int followingCount=0;
	public Tweets insertNewTweet(Tweets tweet) {
		return tr.save(tweet);
	}
	public Tweets getTweets(String username) {
		Optional<Tweets>optional=tr.findById(username);
		Tweets t=null;
		if(optional.isPresent()) {
			t=optional.get();
		}
		return t;
	}
	public List<Tweets> getAllTweets(){
		return tr.findAll();
	}
	public Tweets updateTweet(String username) {
		Optional<Tweets> optional=tr.findById(username);
		System.out.println(optional);
		Tweets tweet=null;
		if(optional.isPresent()) {
			tweet=optional.get();
			tweetCount=tweet.getTweet();
			tweetCount+=1;
			//System.out.println(tweetCount);
			tweet.setTweet(tweetCount);
			//System.out.println(tweet);
			return tr.save(tweet);
		}
		return tweet;
	}
	public Tweets updateFollowings(String username) {
		Optional<Tweets> optional=tr.findById(username);
		Tweets tweet=null;
		if(optional.isPresent()) {
			tweet=optional.get();
			followingCount=tweet.getFollowings();
			followingCount+=1;
			tweet.setFollowings(followingCount);
			return tr.save(tweet);
		}
		return tweet;
	}
}
