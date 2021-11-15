package step1_00_login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step1_00_login.dao.MemberDao;
import step1_00_login.dto.MemberDto;

@WebServlet("/join92.do")
public class Join extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("step1_01_loginEx/02_join.jsp");  // 02_join의 요청을 doGet으로 받아온다.
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// model에서의 결과값을 request.getParameter를 사용하여 memberDto에 넣고 그것을 isJoin에 넣는다
		
		request.setCharacterEncoding("utf-8");  //DB에서 받아온 것을 utf-8로 인코딩한다.
		
		String id    = request.getParameter("id");	// DB에서 받아온 값을 각각의 변수에 넣는다.
		String pw    = request.getParameter("pw");
		String name  = request.getParameter("name");
		String tel   = request.getParameter("tel");
		String email = request.getParameter("email");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(id);						// 각각의 변수를 memberDto에 넣는다.
		memberDto.setPw(pw);
		memberDto.setName(name);
		memberDto.setTel(tel);
		memberDto.setEmail(email);
		
		boolean isJoin = MemberDao.getIstance().joinMember(memberDto);	//memberDto의 값을 joinMember에 넣는다.
		
		request.setAttribute("isJoin", isJoin);		// joinMember의 값을 가지고 있는 isJoin의 값을 가져온다.
		
		RequestDispatcher dis = request.getRequestDispatcher("step1_01_loginEx/03_joinAction.jsp.jsp"); // isJoin의 값을 03_joinAction으로 포워딩한다.
		
		dis.forward(request, response);
	}
}
