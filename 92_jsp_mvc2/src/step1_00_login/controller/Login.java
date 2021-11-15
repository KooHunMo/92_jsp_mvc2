package step1_00_login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import step1_00_login.dao.MemberDao;

@WebServlet("/login92.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher dis = request.getRequestDispatcher("step1_01_loginEx/04_login.jsp");
	dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String id = request.getParameter("id");
		String pw = request.getParameter("pw"); // 화면에서 id와 pw를 가져온다
		
		boolean isLogin = MemberDao.getIstance().loginMember(id, pw); // isLogin 메서드를 사용해 id,pw로 로그인을 한다
		
		if(isLogin) { // 로그인이 true일때 세션에 id을 연결한다.
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}
		
		request.setAttribute("isLogin", isLogin);
		RequestDispatcher dis = request.getRequestDispatcher("step1_01_loginEx/05_loginAction.jsp");
		dis.forward(request, response);
	}

}
