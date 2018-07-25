package CallCenter.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CallCenter.bin.Keyword;
import CallCenter.utils.CustomerAdminUtils;


@WebServlet("/AddKeywordServlet")
public class AddKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("kname");
		System.out.println("kname"+key);
		String description = request.getParameter(" kdescripstion");
		System.out.println("description"+description);
		
		Keyword keys = new Keyword(0,key,description);
		System.out.println("Creating keyword Object");
	CustomerAdminUtils u = new CustomerAdminUtils();
		if(u.addKeyword(keys)){
			System.out.println("Inside if registerkeyword");
			request.setAttribute("action", "keywordRegistration");
			request.setAttribute("result", "success");
			RequestDispatcher dis = request.getRequestDispatcher("confirm2.jsp");
			dis.forward(request, response);
		}else{
			System.out.println("Inside else registerkeyword");
			request.setAttribute("action", "keywordRegistration");
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
