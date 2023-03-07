package EmployeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	public void  save(User u)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String s = "jdbc:mysql://localhost:3306/Zomato?user=root&password=Root";
			Connection con =DriverManager.getConnection(s);
			String sql ="insert into user values(?,?,?,?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1,u.getId());
			p.setString(2, u.getName());
			p.setString(3, u.getSalary());
			p.setString(4, u.getEmail());
			p.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User Gid(int id)
	{
		try {
			User u = new User();
			Class.forName("com.mysql.cj.jdbc.Driver");
			String s = "jdbc:mysql://localhost:3306/Zomato?user=root&password=Root";
			Connection con =DriverManager.getConnection(s);
			String sql = "select * from user  where "
					+ ""
					+ "id=?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			if(r.next())
			{
			u.setId(r.getInt(1));
			u.setName(r.getString(2));
			u.setSalary(r.getString(3));
			u.setEmail(r.getString(4));
				
			}
		
			con.close();
			return u;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
