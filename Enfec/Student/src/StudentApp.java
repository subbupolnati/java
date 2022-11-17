class Student
{
	int sid;
	String name;
	String address;
	int marks;
	public Student(int sid,String name,String address,int marks)
	{
		super();
		this.sid=sid;
		this.name=name;
		this.address=address;
		this.marks=marks;
	}
	
	void showStudentDetails()
	{
		System.out.println("______________________________");
		System.out.println("student id: "+sid);
		System.out.println("student name: "+name);
		System.out.println("student address "+address);
		System.out.println("student marks "+marks);
	}
}
class Engineering_Student extends Student
{
	String branch;
	public Engineering_Student(int sid,String name,String address,int marks,String branch) {
		super(sid,name,address,marks);
		this.branch=branch;
	}
	void showStudentDetails()
	{
		super.showStudentDetails();
		System.out.println("branch "+branch);
	}
}
class Medical_Student extends Student
	{
		String spec;
		public Medical_Student(int sid,String name,String address,int marks,String spec) {
			super(sid,name,address,marks);
			this.spec=spec;
		}
		void showStudentDetails()
		{
			super.showStudentDetails();
			System.out.println("Speclization"+spec);
		}
	}
public class StudentApp {
	public static void main(String[] args){
		Student s1=new Student(100,"subbu","hyd",700);
		s1.showStudentDetails();
		Engineering_Student e=new Engineering_Student(101,"ram","hyd",8,"mca");
		e.showStudentDetails();
		Medical_Student m=new Medical_Student(102,"harsha","hyd",8,"physician");
		m.showStudentDetails();
	}
	
}
