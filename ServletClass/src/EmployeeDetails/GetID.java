package EmployeeDetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/mav")
public class GetID extends GenericServlet{
	
	

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("i"));
		System.out.println(id);
		
		User u = new User();
		u.setId(id);
		Dao d = new Dao();
		User u1 = d.Gid(id);
		
		 res.setContentType("text/html");
		    PrintWriter out = res.getWriter();

		    out.println("<!DOCTYPE html>");
		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Employee Information</title>");
		    out.println("<meta charset='UTF-8'>");
		    out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		    out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css' />");
		    out.println("</head>");
		    out.println("<body class='h-100'>");
		    out.println("<div class='container-fluid h-100'>");
		    out.println("<div class='row justify-content-center align-items-center h-100'>");
		    out.println("<table class='table table-bordered table-striped'>");
		    out.println("<thead>");
		    out.println("<tr>");
		    out.println("<th>ID</th>");
		    out.println("<th>Name</th>");
		    out.println("<th>Salary</th>");
		    out.println("<th>Email</th>");
		    out.println("</tr>");
		    out.println("</thead>");
		    out.println("<tbody>");
		    out.println("<tr>");
		    out.println("<td>"+u1.getId()+"</td>");
		    out.println("<td>"+u1.getName()+"</td>");
		    out.println("<td>"+u1.getSalary()+"</td>");
		    out.println("<td>"+u1.getEmail()+"</td>");
		    out.println("</tr>");
		    out.println("</tbody>");
		    out.println("</table>");
		    out.println("</div>");
		    out.println("</div>");
		    out.println("</body>");
		    out.println("</html>");
		

		
}

}
