package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignUpServlet  extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();	// session 추가
		session.setAttribute("ID",id);			//session 추가 부분
		UserAccount ua = new UserAccount(id,password,name);
		
		MyPersistenceManager.getManager().makePersistent(ua);
		
		resp.sendRedirect("login.html");
		
	}

}