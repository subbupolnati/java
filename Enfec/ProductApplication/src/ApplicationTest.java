import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class ApplicationTest {
	public static String uid;
	public static String uname;
	public static String pass;
	public static String utype;
	public static int pid;
	public static String name;
	public static int cid;
	public static int aqul;
	public static int squl;
	public static float price;
	public static int bid;
	public static float amt;
	public static String sql;
	public static void userRegister() throws SQLException {
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		System.out.println("new user registration");
		System.out.println("enter user id");
		uid=sc.next();
		System.out.println("enter username");
		uname=sc.next();
		System.out.println("enter password");
		pass=sc.next();
		System.out.println("enter user type example admin/customer");
		utype=sc.next();
		sql="call insert_users(?,?,?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setString(1,uid);
		stmt.setString(2, uname);
		stmt.setString(3,pass);
		stmt.setString(4,utype);
		stmt.execute();
		stmt.close();
	}
	public static void login() throws SQLException {
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		System.out.println(" login ");
		System.out.println("enter user id");
		uid=sc.next();
		System.out.println("enter password");
		pass=sc.next();
		sql="select * from users where user_id=? and password=?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, uid);
		psmt.setString(2, pass);
		ResultSet rs=psmt.executeQuery();
		while(rs.next())
		{
			if(uid.equals(rs.getString("user_id"))&& pass.equals(rs.getString("password")))
			{
				System.out.println("login succesfully");
				if(rs.getString("user_type").equals("admin")){
					Product_admin();
				}
				else {
					product_purchase(uid);
				}
				
			}
		else
				System.out.println("invalid login details");
		}
		rs.close();		
	}
	public static void Product_admin() throws SQLException {
		Scanner sc=new Scanner(System.in);
		char ch='y';
		
		do {
			System.out.println("enter admin option\n 1.add product \n 2.edit product");
			int opt=sc.nextInt();
			switch(opt) {
			case 1:
				add_product();
				break;
			case 2:
				edit_product();
				break;
			}
			System.out.println("do you want contionue y/n");
			ch=sc.next().charAt(0);
			if(ch=='n'||ch=='N')
				break;
		}while(ch=='y'|| ch=='Y');
	}
	public static void add_product() throws SQLException {
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		System.out.println("new product adding");
		System.out.println("enter product id");
		pid=sc.nextInt();
		System.out.println("enter product name");
		name=sc.next();
		System.out.println("enter category id");
		cid=sc.nextInt();
		System.out.println("enter avalible quaninty");
		aqul=sc.nextInt();
		System.out.println("enter product price");
		price=sc.nextFloat();
		sql="call insert_product(?,?,?,?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setInt(1,pid);
		stmt.setString(2, name);
		stmt.setInt(3,cid);
		stmt.setInt(4,aqul);
		stmt.setFloat(5, price);
		stmt.execute();
		stmt.close();
		System.out.println("add successfully");
	}
	public static void edit_product() throws SQLException {
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		System.out.println("new product adding");
		System.out.println("enter product id");
		pid=sc.nextInt();
		System.out.println("enter product price");
		price=sc.nextFloat();
		sql="update product set price=? where product_id=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(2,pid);
		stmt.setFloat(1, price);
		stmt.executeUpdate();
		stmt.close();
		System.out.println("updated successfully");
	}
	public static void product_purchase(String uid) throws SQLException {
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
		String sql2="select * from product";
		Statement stmt2=con.createStatement();
		ResultSet rs=stmt2.executeQuery(sql2);
		System.out.println("product_id"+" "+"product_name"+" "+"category_id"+" "+"quantity"+" "+"price");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" " +rs.getFloat(5));
		}
		System.out.println("bill payment");
		System.out.println("enter bill id");
		int bid=sc.nextInt();
		System.out.println("enter product id");
		int pid=sc.nextInt();
		System.out.println("enter selected items");
		int squl=sc.nextInt();
		String user_id=uid;
		float amount=0.0f;
		sql="call insert_bill(?,?,?,?,?)";
		CallableStatement stmt=con.prepareCall(sql);
		stmt.setInt(1,bid);
		stmt.setString(2,user_id);
		stmt.setInt(3,pid);
		stmt.setInt(4,squl);
		stmt.setFloat(5,amount);
		stmt.execute();
		String sql1="call update_amt(?,?,?,?,?)";
		CallableStatement stmt1=con.prepareCall(sql1);
		stmt1.setInt(1,squl);
		stmt1.setInt(2,pid);
		stmt1.setInt(3,bid);
		stmt1.setString(4,user_id);
		stmt1.registerOutParameter(5,Types.FLOAT);
		stmt1.execute();
		System.out.println("updated amount"+stmt1.getFloat(5));
		String sql3="select * from bill where bill_no=?";
		PreparedStatement stmt3=con.prepareStatement(sql3);
		stmt3.setInt(1,bid);
		ResultSet rs1=stmt3.executeQuery();
		while(rs1.next())
		{
			System.out.println("bill NO: "+rs1.getInt(1));
			System.out.println("user_id: "+rs1.getString(2));
			System.out.println("product_id: "+rs1.getInt(3));
			System.out.println("selected_qunatity: "+rs1.getInt(4));
			System.out.println("amount: "+rs1.getFloat(5));
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		char ch='y';
		Class.forName("oracle.jdbc.driver.OracleDriver");
		do {
			System.out.println("enter options \n 1.Register \n 2.login");
			int opt=sc.nextInt();
			switch(opt) {
			case 1:
				userRegister();
				break;
			case 2:
				login();
				break;
			}
			System.out.println("do you want contionue y/n");
			ch=sc.next().charAt(0);
			if(ch=='n'||ch=='N')
				break;
		}while(ch=='y'|| ch=='Y');

	}

}
