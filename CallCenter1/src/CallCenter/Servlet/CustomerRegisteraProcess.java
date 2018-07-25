package CallCenter.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CallCenter.bin.Customer;

import CallCenter.utils.CustomerExUtils1;


@WebServlet("/CustomerRegisterProcess")
public class CustomerRegisteraProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		System.out.println("Name"+name);
		String email = request.getParameter("email");
		System.out.println("email"+email);
		String dob = request.getParameter("dob");
		System.out.println("dob"+dob);
		long phone = Long.parseLong(request.getParameter("phone"));
		System.out.println("phone"+phone);
		//int cid = Integer.parseInt(request.getParameter("cid"));
		
		Customer st = new Customer(0,name,email,dob,phone);
		System.out.println("Creating Customer Object");
	CustomerExUtils1 u = new CustomerExUtils1();
		if(u.registercustomer(st)){
			System.out.println("Inside if registerCustomer");
			request.setAttribute("action", "CustomerRegistration");
			request.setAttribute("result", "success");
			RequestDispatcher dis = request.getRequestDispatcher("confirm1.jsp");
			dis.forward(request, response);
		}else{
			System.out.println("Inside else registerCustomer");
			request.setAttribute("action", "CustomerRegistration");
			request.setAttribute("result", "failed");
			RequestDispatcher dis = request.getRequestDispatcher("confirm1.jsp");
			dis.forward(request, response);
			System.out.println("Failed..!");
		}	

  		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
