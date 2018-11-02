package user;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import util.DatabaseUtil;



public class UserDAO
{
	
	
 public int login(String userID, String userPassword) 
 {
	String SQL = "SELECT userPassword FROM USER WHERE userID =?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try 
	{
		conn = DatabaseUtil.getConnection();
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, userID);
		rs = pstmt.executeQuery();
		if(rs.next()) 
		{
			 if(rs.getString(1).equals(userPassword)) 
			 {
				 return 1; // 로그인 성공
			 }
			 else 
			 {
				 return 0; //비밀번호 오류
			 }
		}
		return -1; // 아이디없음
	} 
		catch (Exception e) 
		{ 
		  e.printStackTrace();
		  System.out.println("login 오류");
		}
	finally 
	{
		try 
		{
		 if(conn != null) conn.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		try 
		{
		 if(pstmt != null) pstmt.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		try 
		{
		 if(rs != null) rs.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	}
	 return -2; //데이터 베이스 오류
	 
 } // end -  login.
 
 public int join(UserDTO user) 
 {
	String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, false) ";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try 
	{
		conn = DatabaseUtil.getConnection();
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, user.getUserID());
		pstmt.setString(2, user.getUserPassword());
		pstmt.setString(3, user.getUserEmail());
		pstmt.setString(4, user.getUserEmailHash());
		return pstmt.executeUpdate();
	}
		catch (Exception e) 
		{ 
		  e.printStackTrace();
		  System.out.println("login 오류");
		}
	finally 
	{
		try 
		{
		 if(conn != null) conn.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		try 
		{
		 if(pstmt != null) pstmt.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		try 
		{
		 if(rs != null) rs.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	}
	 return -1; //회원가입 실패
	 
 } // end -  join

 public boolean getUserEmailChecked(String userID) 
 {
	String SQL = "SELECT userEmailChecked FROM USER WHERE userID =?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try 
	{
		conn = DatabaseUtil.getConnection();
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, userID);
		rs = pstmt.executeQuery();
		if(rs.next()) 
		{
			return rs.getBoolean(1);
		}
	}
		catch (Exception e) 
		{ 
		  e.printStackTrace();
		  System.out.println("getuserEmailChecked 오류");
		}
	finally 
	{
		try 
		{
		 if(conn != null) conn.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		try 
		{
		 if(pstmt != null) pstmt.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		try 
		{
		 if(rs != null) rs.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	}
	 return false; // 데이터 베이스 오류
	 
 } // end -  getuserEmailChecked 
 
 public boolean setUserEmailChecked(String userID) 
 {
	String SQL = "UPDATE USER SET userEmailChecked = true WHERE userID=?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try 
	{
		conn = DatabaseUtil.getConnection();
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, userID);
		pstmt.executeUpdate();
		return true;
	}	
		catch (Exception e) 
		{ 
		  e.printStackTrace();
		  System.out.println("setuserEmailChecked 오류");
		}
	
	finally 
	{
		try 
		{
		 if(conn != null) conn.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		try 
		{
		 if(pstmt != null) pstmt.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		try 
		{
		 if(rs != null) rs.close();
		} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	}
	 return false; // 데이터 베이스 오류
	 
 } // end -  setuserEmailChecked 
 
 public String getUserEmail(String userID) 
 {
	 String SQL = "SELECT userEmail FROM USER WHERE userID =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try 
		{
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				return rs.getString(1);
			}
		}
			catch (Exception e) 
			{ 
			  e.printStackTrace();
			  System.out.println("getUserEmail 오류");
			}
		finally 
		{
			try 
			{
			 if(conn != null) conn.close();
			} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			try 
			{
			 if(pstmt != null) pstmt.close();
			} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			try 
			{
			 if(rs != null) rs.close();
			} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
		}
		return null; // 데이터 베이스 오류
		 
	 } // end -  getUserEmail 

 
	
} //end - public class UserDAO



