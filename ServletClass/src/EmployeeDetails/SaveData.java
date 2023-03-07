package EmployeeDetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/save")
public class SaveData extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name =req.getParameter("name");
		String sal =req.getParameter("name1");
		String email =req.getParameter("name2");
	//System.out.println(sal+" "+name+" "+email);
		User u = new User();
		u.setName(name);
		u.setSalary(sal);
		u.setEmail(email);
		Dao d = new Dao();
		d.save(u);
		PrintWriter p =res.getWriter();
		p.print("<h1>SucessFull Updated ur data base</h1>");
	}

}
