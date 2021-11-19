package step2_00_boardBasic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step2_00_boardBasic.dao.BoardBasicDao;
import step2_00_boardBasic.dto.BoardBasicDto;

@WebServlet("/bInfo92.do")
public class _05_bInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*
		 * JSP - getParameter()와 getAttribute()의 차이점
		 * 
		 * 가장 큰 차이점은 둘의 리턴 타입이다. getParameter()메서드의 경우 String타입을 리턴하는반면,
		 * getAttribute()는 Object 타입을 리턴하기 때문에 주로 빈 객체나 다른 클래스를 받아올때 사용된다.
		 * 
		 * 또한, getParameter()는 웹브라우저에서 전송받은 request영역의 값을 읽어오고 getAttribute()의 경우
		 * setAttribute()속성을 통한 설정이 없으면 무조건 null값을 리턴한다.
		 * 
		 * 간단한 예를 들자면, request.getParameter("num")은 웹브라우저에서 전송받은 request영역에서 name값이
		 * "num"인것을 찾아 그 값을 읽어오는데 request.getAttribute("num")은
		 * request.setAttribute("num", "123") 과 같이 setAttribute()를 통해 값을 설정해주지 않으면
		 * null값을 리턴받게 된다.
		 */
		BoardBasicDto boardDto = BoardBasicDao.getInstance().getOneBoard(Integer.parseInt(request.getParameter("num"))); // getParamete안의 변수는 ""안에 넣는다
		request.setAttribute("boardDto", boardDto); // 세션에 boardDto 데이터 생성
		
		RequestDispatcher dis = request.getRequestDispatcher("step2_01_boardBasicEx/05_bInfo.jsp");
		dis.forward(request, response);
	}
}
