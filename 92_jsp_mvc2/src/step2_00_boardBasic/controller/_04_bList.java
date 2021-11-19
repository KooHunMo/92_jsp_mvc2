package step2_00_boardBasic.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step2_00_boardBasic.dao.BoardBasicDao;
import step2_00_boardBasic.dto.BoardBasicDto;

@WebServlet("/bList92.do")
public class _04_bList extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<BoardBasicDto> boardList = BoardBasicDao.getInstance().getAllBoard(); // 여기엔 왜 boardDto 안 넣어도 되지? // boardDto를 메서드에서 변수로 안 받아오기 때문이다.
		
		request.setAttribute("boardList", boardList); // 서버에 이미있는 boardList를 연결시켜준다 맞나?
		
		RequestDispatcher dis = request.getRequestDispatcher("step2_01_boardBasicEx/04_bList.jsp");
		dis.forward(request, response);
	}
}
