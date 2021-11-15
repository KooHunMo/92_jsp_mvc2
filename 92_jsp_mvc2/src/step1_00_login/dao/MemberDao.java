package step1_00_login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import step1_00_login.dto.MemberDto;

public class MemberDao {

		private MemberDao() {}
		private static MemberDao instance = new MemberDao();
		public static  MemberDao getIstance() {
			return instance;
		}
		
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		public Connection getConnection() {
			
			try {
				Context initCtx = new InitialContext();
	    		Context envCtx = (Context)initCtx.lookup("java:comp/env");
	    		DataSource ds = (DataSource)envCtx.lookup("jdbc/pool");
	    		conn = ds.getConnection();
	    		
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return conn;
		}
		
		public boolean joinMember(MemberDto memberDto) {
			
			boolean isJoin = false;
			
			try {
				
				conn=getConnection();
				pstmt = conn.prepareStatement("SELECT * fROM MEMBER WHERE ID=?");
				pstmt.setString(1, memberDto.getId()); 
				rs = pstmt.executeQuery();
				
				if(!rs.next()) { // 아이디 중복이 아니면 돌아감
					pstmt = conn.prepareStatement("INSERT INTO MEMBER(ID, PW, NAME, TEL, EMAIL) VALUES(?,?,?,?,?)");
					pstmt.setString(1, memberDto.getId());
					pstmt.setString(2, memberDto.getPw());
					pstmt.setString(3, memberDto.getName());
					pstmt.setString(4, memberDto.getTel());
					pstmt.setString(5, memberDto.getEmail());
					pstmt.executeUpdate();
					isJoin = true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (rs != null)    try {rs.close();} catch (SQLException e) {e.printStackTrace();}
				if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
				if (conn != null)  try {conn.close();} catch (SQLException e) {e.printStackTrace();}
			}
			
			return isJoin;
		}
		
		
		public boolean loginMember(String id, String pw) {  //왜 memberDto가 아닌지?
			boolean isLogin = false;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE ID=? AND PW=?");
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					isLogin = true;
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (rs != null)    try {rs.close();} catch (SQLException e) {e.printStackTrace();}
				if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
				if (conn != null)  try {conn.close();} catch (SQLException e) {e.printStackTrace();}
			}
			
			return isLogin;
		}
		
		public void updateMember(String id, MemberDto memberDto) {
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("UPDATE MEMBER SET PW=?, NAME=?, TEL=?, EMAIL=?, FILED=?, SKILL=?, MAJOR=? WHERE ID=?");
				pstmt.setString(1, memberDto.getPw());
				pstmt.setString(2, memberDto.getName());
				pstmt.setString(3, memberDto.getTel());
				pstmt.setString(4, memberDto.getEmail());
				pstmt.setString(5, memberDto.getField());
				pstmt.setString(6, memberDto.getField());
				pstmt.setString(7, memberDto.getMajor());
				pstmt.setString(8, id);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
	            if(conn != null)  {try {conn.close();} catch (SQLException e) {}}
			}
			
		}
		
		
		public MemberDto getOneMemberInfo(String id) {
			
			MemberDto memberDto = null;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("SELECT * FROM MEMBER ID=?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					memberDto = new MemberDto();
					memberDto.setId(rs.getString("id"));
					memberDto.setPw(rs.getString("pw"));
					memberDto.setName(rs.getString("name"));
					memberDto.setTel(rs.getString("tel"));
					memberDto.setEmail(rs.getString("email"));
					memberDto.setField(rs.getString("field"));
					memberDto.setSkill(rs.getString("skill"));
					memberDto.setMajor(rs.getString("major"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (rs != null)    try {rs.close();} catch (SQLException e) {e.printStackTrace();}
				if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
				if (conn != null)  try {conn.close();} catch (SQLException e) {e.printStackTrace();}
			}
			
		return memberDto;
		}
		
		
		public void deleteMember(String id) {
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("DELETE FROM MEMBER WHERE ID=? ");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
	    		if (conn != null) {try {conn.close();} catch (SQLException e) {}}
			}
			
		}
		
		
		public void apply(String id, String field, String skill, String major) {
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("UPDATE MEMBER SET FIELD=?, SKILL=?, MAJOR=? WHERE ID=?");
				pstmt.setString(1, field);
				pstmt.setString(2, skill);
				pstmt.setString(3, major);
				pstmt.setString(4, id);
				pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
	    		if (conn != null) {try {conn.close();} catch (SQLException e) {}}
			}
			
		}
		
}

