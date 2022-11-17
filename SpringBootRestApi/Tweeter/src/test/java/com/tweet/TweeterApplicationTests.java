package com.tweet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.tweet.model.Posts;
import com.tweet.model.Tweets;
import com.tweet.model.User;
import com.tweet.service.PostsService;
import com.tweet.service.TweetService;
import com.tweet.service.UserService;

@SpringBootTest
class TweeterApplicationTests {

	Posts posts;
	Tweets tweet;
	User user;
	PostsService ps=Mockito.mock(PostsService.class);
	UserService us=Mockito.mock(UserService.class);
	TweetService ts=Mockito.mock(TweetService.class);
	List<Tweets> t1=new ArrayList<Tweets>();
	List<Posts> p1=new ArrayList<Posts>();
	List<User> u1=new ArrayList<User>();
	@Test
	void contextLoads() {
	}
	@BeforeEach
	void init() {
		posts=new Posts();
		tweet=new Tweets("subbu",1,6,6);
		user=new User();
		user.setUserName("subbu");
		user.setPassword("subbu");
		user.setRole("user");
		Posts p=new Posts(1,"hai",user);
		Posts p2=new Posts(2,"hello",user);
		p1.add(p2);p1.add(p);
	}
	@Test
	void test1() {
		Posts p1=posts;
		assertSame(posts, p1);
	}
	@Test
	void test2() {
	assertEquals(posts, posts);
	assertEquals(tweet, tweet);
	}
	@Test
	void test3() {
	assertEquals("subbu","subbu");
	}
	@Test void test4() {
		assertNotEquals(user.getUserName(),"kkkk"); 
	}
	@Test void test5() { 
		 assertEquals(tweet.getUsername(),"subbu"); 
	}
	@Test void test6() {
	 assertThrows(NullPointerException.class,()->posts.getPosts().length());
	 }
	 @Test void test7() { 
		 assertSame("user",user.getRole()); 
	}
	  
	 @Test void test8() { 
		 assertNull(posts.getUser());
	 }
	 @Test void test9() {
		 assertNotNull(tweet.getFollowers()); 
	 }
	 @Test void test10() {
	  when(ps.insertNewPost(posts)).thenReturn(posts);
	 }
 	 @Test void test11() { 
		 doThrow(new NullPointerException()).when(us).getUser("");
	 }
	 
	 @Test void test12() { 
		 doThrow(new NullPointerException()).when(ps).deletePost(0);
	 }
	 @Test void test13() {
		  when(ts.getTweets("subbu")).thenReturn(tweet);
	  }
	 @Test void test14() { 
		 ps.viewAllPosts();verify(ps,times(1)).viewAllPosts();
	  }
	 @Test void test15() { 
		 doReturn(p1).when(ps).viewAllPosts();
	  }
	 @Test void test16() {
		 verify(ps,never()).getAllPosts("subbu"); 
	 }
	 @Test void test17() { 
		 when(ps.getAllPosts("subbu")).thenReturn(p1);
		 assertEquals(p1,ps.getAllPosts("subbu"));
		 verify(ps,atLeast(1)).getAllPosts("subbu");
	 }
	  
	 @Test void test18() { 
		 when(ps.getAllPosts("subbu")).thenReturn(p1);
		 assertEquals(p1,ps.getAllPosts("subbu"));
		 assertEquals(p1,ps.getAllPosts("subbu")); 
		 assertEquals(p1,ps.getAllPosts("subbu"));
		 verify(ps,atMost(3)).getAllPosts("subbu"); }
	  
	  @Test void test19() { 
		  when(ps.viewAllPosts()).thenReturn(p1);
		  assertEquals(2,p1.size());
	  }
	  
}
