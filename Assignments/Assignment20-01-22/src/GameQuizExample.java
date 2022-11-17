import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class QuizGame{
	Scanner sc = new Scanner(System.in);
	int count=0;
	ArrayList<String> que= new ArrayList<>();
	ArrayList<String> correct = new ArrayList<>();
	static ArrayList score=new ArrayList();
	static HashMap score1 =new HashMap();
	public void questions() 
	{
		que.add("What is java?\na) PL,\nb) SL,\nc) Both,\nd) None");
	    que.add(" Which of the following is not a Java features?\na) Dynamic,\nb) Architecture Neutral,\nc) Use of pointers,\nd) Object-oriented");
	    que.add(" What does the expression float a = 35 / 0 return?\na) 0,\nb) Not a Number,\nc) Infinity,\nd) Run time exception");
	    que.add(" Which of the following is true about the anonymous inner class?\na) It has only methods,\nb) Objects can't be created,\nc) It has a fixed class name,\nd)It has no class name");
	    que.add(" Which package contains the Random class?\na) java.util package,\nb) java.lang package,\nc) java.awt package,\nd)java.io package");
	    que.add(" Which option is false about the final keyword?\na) A final method cannot be overridden in its subclasses,\nb) A final class cannot be extended,\nc) A final class cannot extend other classes,\nd) A final method can be inherited.");
	    que.add(" In which memory a String is stored, when we create a string using new operator?\na) Stack,\nb) String memory,\nc) Heap memory,\nd) Random storage space");
	    que.add(" Which of the following is a marker interface?\na) Runnable interface,\nb) Remote interface,\nc) Readable interface,\nd) Result interface");
	    que.add(" Which keyword is used for accessing the features of a package?\na) package,\nb)import,\nc)extends,\nd)export");
	    que.add(" Which of the following is a mutable class in java?\na) java.lang.String,\nb) java.lang.Byte,\nc) java.lang.Short,\nd) java.lang.StringBuilder");
	}
	public void answer() {
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
	}
	public void runquiz(String name) 
	{
		questions();
		answer();
		Random r=new Random();
		for(int i=1;i<=5;i++)
		{
			int num=r.nextInt(que.size());
			System.out.println(que.get(num));
			System.out.println("Your option: ");
	        String ans = sc.nextLine();
	        if(ans.equalsIgnoreCase(correct.get(num)))
	        {
	        	count++;
	        }
		}
	System.out.println(name+"score is "+count);
	score.add(count);
	//score1.put(name,count);
	count=0;
	//System.out.println("total score"+score);
	}
	public void result()
	{
		for(int i=0;i<score.size();i++) 
		{
			for(int j=i+1;j<score.size();++j)
			{
				int k=(int) score.get(i);
				int l=(int) score.get(j);
				if(k>l)
					System.out.println("first person Winner");
				else if(k<l)
					System.out.println("second person winner");
				else
					System.out.println("quiz tie");
			}		
		}
	
	}
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
		qg.runquiz(name);
		
	}
}
class Admin implements Runnable{
	QuizGame qg;
	Admin(QuizGame qg){
		this.qg=qg;
	}
	@Override
	public void run() {
		qg.result();
		
	}
	
}
public class GameQuizExample{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ExecutorService ser=Executors.newSingleThreadExecutor();
		QuizGame q=new QuizGame();
		ser.execute(new Person(q,"first"));
		ser.execute(new Person(q,"Second"));
		ser.execute(new Admin(q));
		ser.shutdown();
		//q.result();

	}

}
