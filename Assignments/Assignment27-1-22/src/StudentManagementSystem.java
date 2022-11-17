
public class StudentManagementSystem {
	public int sid;
	public String sname;
	public String address;
	public int marks;
	int subject=10;
	public String branch;
	public double total;
	public StudentManagementSystem(int sid, String sname, String address, int marks, String branch) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.address = address;
		this.marks = marks;
		this.branch = branch;
	}
	public double percentage (int marks){
		total=marks/10;
		return total;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
}
