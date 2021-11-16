package step1_00_login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import step1_00_login.dao.MemberDao;
import step1_00_login.dto.MemberDto;

@WebServlet("/update92.do")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	String id = (String)session.getAttribute("id");
	
	MemberDto memberDto = MemberDao.getIstance().getOneMemberInfo(id);
	
	if(memberDto.getField() != null) { // 지원분야가 없으면 > 최초지원
		String[] skills = memberDto.getSkill().split(",");
		
		for (String skill : skills) {
			if(skill.equals("html")) request.setAttribute("html", true);
			if(skill.equals("css")) request.setAttribute("css", true);
			if(skill.equals("javascript")) request.setAttribute("javascript", true);
			if(skill.equals("java")) request.setAttribute("java", true);
			if(skill.equals("jsp")) request.setAttribute("jsp", true);
			if(skill.equals("spring")) request.setAttribute("spring", true);
		}
	}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
