package CallCenter.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CallCenter.bin.Users;
import CallCenter.utils.CustomerAdminUtils;

@WebServlet("/AddExecutiveProcess")
public class AddExecutiveProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("Name"+name);
		String email = request.getParameter("email");
		System.out.println("email"+email);
		String password = request.getParameter("password");
		System.out.println("password"+password);
		
		String dob = request.getParameter("dob");
		System.out.println("dob"+dob);
		String role = request.getParameter("role");
		System.out.println("role"+role);
		
		
		Users st = new Users(0,name,email,password,role,dob);
		System.out.println("Creating usrers Object");
	CustomerAdminUtils u = new CustomerAdminUtils();
		if(u.addExecutive(st)){
			System.out.println("Inside if registerexecutiver");
			request.setAttribute("action", "CusttomerExecutiveRegistration");
			request.setAttribute("result", "success");
			RequestDispatcher dis = request.getRequestDispatcher("confirm2.jsp");
			dis.forward(request, response);
		}else{
			System.out.println("Inside else registerCustomer");
			request.setAttribute("action", "CustomerExecutiveRegistration");
			request.setAttribute("result", "failed");
			RequestDispatcher dis = request.getRequestDispatcher("confirm2.jsp");
			dis.forward(request, response);
			System.out.println("Failed..!");
		}	

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
