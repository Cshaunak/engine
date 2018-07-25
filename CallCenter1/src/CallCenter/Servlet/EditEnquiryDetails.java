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
import CallCenter.bin.Enquiry;
import CallCenter.bin.Keyword;
import CallCenter.utils.CustomerExUtils1;


@WebServlet("/EditEnquiryDetails")
public class EditEnquiryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside EDIT ENQUIRY details");
int eid = Integer.parseInt(request.getParameter("eid"));
		//int eid=4;
		System.out.println("eid"+eid);
		String estate = request.getParameter("estatus");
		System.out.println("estate"+estate);
		String esolution = request.getParameter("esolution");
		System.out.println("esolution"+esolution);
		String edesc = request.getParameter("edesc");
		System.out.println("edesc"+edesc);
		Customer customer=new Customer();
		int cid = Integer.parseInt(request.getParameter("cid"));
		System.out.println("cid"+cid);
		customer.setCid(cid);
		Keyword keyword=new Keyword();
		int kid=Integer.parseInt(request.getParameter("kid"));
		System.out.println("kid"+kid);
		keyword.setKid(kid);
		
		
	
		Enquiry er = new Enquiry(eid,edesc,esolution,estate,customer,keyword);
		
		
		CustomerExUtils1 u = new CustomerExUtils1();
		try {
			if(u.updateEnquiry(er)){
				HttpSession session = request.getSession(false);
				if(session != null)
					session.removeAttribute("st");
				request.setAttribute("action", "Enquiryupdation");
				request.setAttribute("result", "success");
				RequestDispatcher dis = request.getRequestDispatcher("confirm1.jsp");
				dis.forward(request, response);
			}else{
				request.setAttribute("action", "Enquiryupdation");
				request.setAttribute("result", "failed");
				RequestDispatcher dis = request.getRequestDispatcher("confirm1.jsp");
				dis.forward(request, response);
			}
		}
catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
		
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
