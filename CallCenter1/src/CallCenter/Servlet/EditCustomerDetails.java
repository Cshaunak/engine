package CallCenter.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CallCenter.bin.Customer;

import CallCenter.utils.CustomerExUtils1;


@WebServlet("/EditCustomerDetails")
public class EditCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		String dob = request.getParameter("dob");
		long phone = Long.parseLong(request.getParameter("phone"));
		
		//int eid = Integer.parseInt(request.getParameter("eid"));
		
	
		Customer st = new Customer(cid,name,email,dob,phone);
		
		
		CustomerExUtils1 u = new CustomerExUtils1();
		try {
			if(u.updatecustomer(st)){
				HttpSession session = request.getSession(false);
				if(session != null)
					session.removeAttribute("st");
				request.setAttribute("action", "Customerupdation");
				request.setAttribute("result", "success");
				RequestDispatcher dis = request.getRequestDispatcher("confirm1.jsp");
				dis.forward(request, response);
			}else{
				request.setAttribute("action", "Customerupdation");
				request.setAttribute("result", "failed");
				RequestDispatcher dis = request.getRequestDispatcher("confirm1.jsp");
				dis.forward(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
