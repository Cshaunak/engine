package CallCenter.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CallCenter.bin.Enquiry;
import CallCenter.utils.CommonUtils;

@WebServlet("/EnquiryDetailServlet")
public class EnquiryDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		int eid = Integer.parseInt(request.getParameter("eid"));
		CommonUtils u = new CommonUtils();
		Enquiry er = u.getenquiry(eid);
		HttpSession session = request.getSession(false);
		if(session != null){
			session.setAttribute("er", er);
		}
		request.setAttribute("er", er);
		RequestDispatcher dis = request.getRequestDispatcher("displayEnquiryDetails.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
