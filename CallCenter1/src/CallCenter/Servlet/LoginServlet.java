 package CallCenter.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CallCenter.bin.Users;
import CallCenter.utils.CommonUtils;


@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside LoginServlet");
		String email = request.getParameter("email");
		System.out.println("email"+email);
		String password = request.getParameter("password");
		System.out.println("password"+password);
		String role = request.getParameter("role");
		System.out.println("role"+role);
		CommonUtils u= new CommonUtils();
		System.out.println("Creatng CommonUtils object");
		Users users = u.validateUsers(email, password, role);
		 
		if(users != null && users.getUrole().equals("executive")){
			HttpSession session = request.getSession();
			session.setAttribute("users", users);
			response.sendRedirect("CallCenterExecutiveHome.jsp");
		}else if(users != null && users.getUrole().equals("admin")){
			HttpSession session = request.getSession();
			session.setAttribute("users", users);
			response.sendRedirect("AdminHome.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
