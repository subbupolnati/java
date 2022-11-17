package com.interthreadedcomm;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class QuizGame{
	Scanner sc = new Scanner(System.in);
	int count1=0;
	int count=0;
	public void questions() 
	{
		ArrayList<String> que= new ArrayList<>();
		que.add("1) What is java");
	    que.add("2) Which of the following is not a Java features?");
	    que.add("3) What does the expression float a = 35 / 0 return?");
	    que.add("4) Which of the following is true about the anonymous inner class?");
	    que.add("5) Which package contains the Random class?");
	    que.add("6) Which option is false about the final keyword?");
	    que.add("7) In which memory a String is stored, when we create a string using new operator?");
	    que.add("8) Which of the following is a marker interface?");
	    que.add("9) Which keyword is used for accessing the features of a package?");
	    que.add("10) Which of the following is a mutable class in java?");
	    ArrayList<String> opt = new ArrayList<>();
	    opt.add("a) PL,b) SL,c) Both,d) None");
	    opt.add("a) Dynamic,b) Architecture Neutral,c) Use of pointers,d) Object-oriented");
	    opt.add("a) 0,b) Not a Number,c) Infinity,d) Run time exception");
	    opt.add("a) It has only methods,b) Objects can't be created,c) It has a fixed class name,d)It has no class name");
	    opt.add("a) java.util package,b) java.lang package,c) java.awt package,d)java.io package");
	    opt.add("a) A final method cannot be overridden in its subclasses.,b) A final class cannot be extended.,c) A final class cannot extend other classes,d) A final method can be inherited.");
	    opt.add("a) Stack,b) String memory,c) Heap memory,d) Random storage space");
	    opt.add("a) Runnable interface,b) Remote interface,c) Readable interface,d) Result interface");
	    opt.add("a) package,b)import,c)extends,d)export");
	    opt.add("a) java.lang.String,b) java.lang.Byte,c) java.lang.Short,d) java.lang.StringBuilder");
	    ArrayList<String> correct = new ArrayList<>();
	    correct.add("a");
	    correct.add("c");
	    correct.add("c");
	    correct.add("d");
	    correct.add("a");
	    correct.add("c");
	    correct.add("c");
	    correct.add("b");
	    correct.add("b");
	    correct.add("d");
	   	String c1="";
	    int count=0;
	   	for(int i=0;i<(que.size()/2);i++)
	   	{
	   		String q=que.get(i);
	    	System.out.println(q);
	    	String o=opt.get(i);
	    	String[] s1 = o.split(",");
	    	for(String s:s1)
	    	{
	    	  System.out.println(s);
	    	} 
	         String c=correct.get(i);
	         c1 = c;
	         System.out.println("Your option: ");
	         String ans = sc.nextLine();
	         if(ans.equalsIgnoreCase(c1))
	          {
	              count++;
	          }
	         
	    }
	    System.out.println("Marks:"+count);
	    this.count=count;
	    notify();
	  
	}
	/*public void result()
	{
		if(count>count1) {
			System.out.println("Winner is player1");
		}
		if(count<count1) {
			System.out.println("Winner is player2");
		}
		else {
			System.out.println("Winner is player1");
		}
	}*/
}
class Person implements Runnable{
	QuizGame qg;
	String name;
	Person(QuizGame qg,String name)
	{	this.name=name;
		this.qg=qg;
	}
	@Override
	public void run()
	{
		System.out.println(name+"person");
		qg.questions();
		
	}
}
public class TestQuizGame {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		ExecutorService ser=Executors.newSingleThreadExecutor();
		QuizGame q=new QuizGame();
		ser.execute(new Person(q,"first"));
		ser.execute(new Person(q,"Second"));
		//q.questions();
		//Person1 p1=new Person1(q);
		//p1.start();
		//Person2 p2=new Person2(q);
		//p2.start();
		//p1.join();
		//p2.join();
		//q.result();
        
	}

}
