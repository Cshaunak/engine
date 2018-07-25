package CallCenter.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CallCenter.bin.Customer;
import CallCenter.bin.Enquiry;
import CallCenter.bin.Keyword;
import CallCenter.utils.CustomerExUtils1;


@WebServlet("/EnquiryRegister")
public class EnquiryRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer=new Customer();
		int cid = Integer.parseInt(request.getParameter("cid"));
		System.out.println("cid"+cid);
		customer.setCid(cid);
		System.out.println("After Cid");
		Keyword keyword=new Keyword();
		System.out.println("keyword created");
		int kid = Integer.parseInt(request.getParameter("kid"));
		
		System.out.println("kid"+kid);
		keyword.setKid(kid);
		String edesc = request.getParameter("edesc");
		System.out.println("edesc"+edesc);
		String esolution = request.getParameter("esolution");
		System.out.println("esolution"+esolution);
		String estatus = request.getParameter("estatus");
		System.out.println("estatus"+estatus);
		//int cid = Integer.parseInt(request.getParameter("cid"));
		
		Enquiry st = new Enquiry(0,edesc,esolution,estatus,customer,keyword);
		System.out.println("Creating Enquiry Object");
	CustomerExUtils1 u = new CustomerExUtils1();
		if(u.addenquiry(st)){
			System.out.println("Inside if enquiryRegister");
			request.setAttribute("action", "EnquiryRegistration");
			request.setAttribute("result", "success");
			RequestDispatcher dis = request.getRequestDispatcher("confirm1.jsp");
			dis.forward(request, response);
		}else{
			System.out.println("Inside else enquiryCustomer");
			request.setAttribute("action", "EnquiryRegistration");
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
