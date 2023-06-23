package dxclogin;

import java.io.IOException;
import java.sql.*;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pw = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		
		if(id == null || id.equals("")) {
			request.setAttribute("status", "invalidUserid");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		if(pw == null || pw.equals("")) {
			request.setAttribute("status", "invalidPassword");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
		               "jdbc:mysql://localhost:3306/useraccount?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
		               "root", "LQSym*r00tpw");
			
			PreparedStatement ps = conn.prepareStatement("select userid, name, role from accountinfo where userid=? and password=?");
			ps.setString(1, id);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				session.setAttribute("userid", rs.getString("userid"));
				session.setAttribute("name", rs.getString("name"));
				session.setAttribute("role", rs.getString("role"));
				rd = request.getRequestDispatcher("welcome.jsp");
				
				checkRole(request, response);
				
			} else {
				request.setAttribute("status", "failed");
				rd = request.getRequestDispatcher("login.jsp");
			}
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void checkRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        
        if (role.equals("manager")) {
        	session.setAttribute("isManager", true);
        } else {
        	session.setAttribute("isManager", false);
        }
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        
        response.sendRedirect("login.jsp");
	}

}
