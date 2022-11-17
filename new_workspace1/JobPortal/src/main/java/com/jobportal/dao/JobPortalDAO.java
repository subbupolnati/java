package com.jobportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.jobseeker.bean.JobSeekers;
import com.jobseeker.bean.Recuriter;

public class JobPortalDAO {
	public static String url="jdbc:oracle:thin:@localhost:1521:admin";
	public static String dbname="c##scott2";
	public static String dbpass="tiger";
	public static Connection dbconnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,dbname,dbpass);
		return con;
	}
	public int recuriterInsert(Recuriter r) throws ClassNotFoundException, SQLException {
		Connection con=dbconnection();
		String sql="insert into recuriter values(?,?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,r.getFullname());
		stmt.setString(2,r.getEmail());
		stmt.setString(3,r.getCompanyname());
		stmt.setLong(4,r.getMobile());
		stmt.setString(5,r.getGender());
		int n=stmt.executeUpdate();
		return n;
	}
	public List<JobSeekers> search(JobSeekers jbs) throws ClassNotFoundException, SQLException{
		Connection con=dbconnection();
		List<JobSeekers> jlist=new ArrayList<JobSeekers>();
		String sql="select * from jobseeker where qualification like '%"+jbs.getQul()+"%' or yop like '%"+jbs.getYop()+"%'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			JobSeekers j=new JobSeekers();
			j.setFullname(rs.getString("fullname"));
			j.setEmail(rs.getString("email"));
			j.setGender(rs.getString("gender"));
			j.setMobile(rs.getLong("mobile"));
			j.setQul(rs.getString("qualification"));
			j.setYop(rs.getInt("yop"));
			byte img[]=rs.getBytes("resume");
			String resume=Base64.getEncoder().encodeToString(img);
			j.setResume(resume);
			jlist.add(j);
		}
		return jlist;
		
	}
	public List<JobSeekers> all_jobseekers() throws ClassNotFoundException, SQLException{
		Connection con=dbconnection();
		List<JobSeekers> jlist=new ArrayList<JobSeekers>();
		String sql="select * from jobseeker";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			JobSeekers j=new JobSeekers();
			j.setFullname(rs.getString("fullname"));
			j.setEmail(rs.getString("email"));
			j.setGender(rs.getString("gender"));
			j.setMobile(rs.getLong("mobile"));
			j.setQul(rs.getString("qualification"));
			j.setYop(rs.getInt("yop"));
			byte img[]=rs.getBytes("resume");
			String resume=Base64.getEncoder().encodeToString(img);
			j.setResume(resume);
			jlist.add(j);
		}
		return jlist;
		
	}

}
