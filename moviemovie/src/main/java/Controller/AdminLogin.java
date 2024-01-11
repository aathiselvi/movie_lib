package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Admin;
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mail = req.getParameter("a_mail");
		String password = req.getParameter("a_pass");
		
		Dao dao = new Dao();
		
		try {
			Admin admin = dao.findByMail(mail);
			
			if(admin!=null) {
				if(admin.getAdminpassword().equals(password)) {
					req.setAttribute("movies", dao.getAllMovie());				
					RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
					rd.include(req, resp);
				}
				else {
					req.setAttribute("message","password is invalid");
					RequestDispatcher rd = req.getRequestDispatcher("alogin.jsp");
					rd.include(req, resp);
				}
			}
			else {
				req.setAttribute("message", "email is invalid");
				RequestDispatcher rd = req.getRequestDispatcher("alogin.jsp");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		

}
