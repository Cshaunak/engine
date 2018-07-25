package CallCenter.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CallCenter.bin.Customer;
import CallCenter.utils.CommonUtils;


@WebServlet("/CustomerDetailServlet")
public class CustomerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int cid = Integer.parseInt(request.getParameter("cid"));
		CommonUtils u = new CommonUtils();
		Customer st = u.getCustomer(cid);
		HttpSession session = request.getSession(false);
		if(session != null){
			session.setAttribute("st", st);
		}
		request.setAttribute("st", st);
		RequestDispatcher dis = request.getRequestDispatcher("displayCustomerDetails.jsp");
		dis.forward(request, response);
	}

		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
