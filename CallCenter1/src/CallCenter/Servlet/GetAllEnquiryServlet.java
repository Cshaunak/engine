package CallCenter.Servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CallCenter.bin.Enquiry;
import CallCenter.utils.CustomerAdminUtils;


/**
 * Servlet implementation class GetAllEnquiryServlet
 */
@WebServlet("/GetAllEnquiryServlet")
public class GetAllEnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int cid = Integer.parseInt(request.getParameter("cid"));
		CustomerAdminUtils u = new CustomerAdminUtils();
		List<Enquiry> elist = u.getallenquiry();
		request.setAttribute("elist", elist);
	
		request.setAttribute("elist", elist);
		RequestDispatcher dis = request.getRequestDispatcher("displayPendingEnquiry.jsp");
		dis.forward(request, response);
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
