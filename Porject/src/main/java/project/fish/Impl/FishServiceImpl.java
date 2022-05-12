package project.fish.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project.fish.dao.DatsSource;
import project.fish.service.FishService;
import project.fish.service.FishVO;

public class FishServiceImpl implements FishService {
	private DatsSource dataSource = DatsSource.getInstance();
	private Connection conn = dataSource.getConnection();
	private PreparedStatement psmt; // sql 명령실행
	private ResultSet rs; // select 결과를 담음
    Scanner sc = new Scanner(System.in);
	@Override
	public List<FishVO> selectListFish() {
		List<FishVO> Fishs = new ArrayList<FishVO>();
		FishVO Fish;
		String sql = "SELECT * FROM FISHUSER";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // sql을 실행하고 결과를 담음
			while (rs.next()) { // 초기화
				Fish = new FishVO();
				Fish.setUserId(rs.getString("userld"));
				Fish.setName(rs.getString("name"));
				Fish.setPassword(rs.getString("password"));
				Fishs.add(Fish); // 리스트 추가

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Fishs;
	}

	@Override
	public FishVO selectFish(FishVO Fish) {
		// 한명 조회

		FishVO vo = new FishVO();
		String sql = "select * from FISHUSER where USERid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Fish.getUserId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setUserId(rs.getString("user"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int insertFish(FishVO Fish) {
		// 한명추가
		int n = 0;
		String sql = "INSERT INTO FISHUSER VALUES(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Fish.getUserId());
			psmt.setString(2, Fish.getName());
			psmt.setString(3, Fish.getPassword());

			n = (int) psmt.executeLargeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateFish(String oId) {
		// 한명 정보 변경
		int n = 0;
		String sql = "UPDATE FISHUSER SET PASSWORD = ? WHERE USERID = ?";
	      try {
	          conn = dataSource.getConnection();
	          psmt = conn.prepareStatement(sql);
	          System.out.println("비밀번호를 변경합니다.");
	          String upPassword = sc.next();
	          psmt.setString(1, upPassword);
	          psmt.setString(2, oId);
	          n = psmt.executeUpdate();
	       } catch (SQLException e) {
	          e.printStackTrace();
	       } finally {
	          close();
	       }

	       return n;
	    }
	@Override
	public int deleteFish(String oId) {
		// 한명 삭제
		int n = 0;
		String sql = "delete from FISHUSER where USERID = ?";
	     try {
	         conn = dataSource.getConnection();
	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, oId);
	         n = psmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }

	      return n;
	   }

	public int login(String userID, String password) {
		ResultSet rs;
		String sql = "SELECT PASSWORD FROM FISHUSER WHERE USERID = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println();
				if (rs.getString(1).equals(password))
					return 1;
				else
					return 0;
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return -2;
	}
	
	   public int savingMoney(int money, String sId) {
		      String sql = "UPDATE GUGBABUSER SET MONEY = MONEY + ? WHERE ID = ?";
		      try {
		         psmt = conn.prepareStatement(sql);
		         psmt.setInt(1, money);
		         psmt.setString(2, sId);
		         psmt.executeQuery();
		         return 1;
		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         close();
		      }
		      return -2;

		   }
	
	
	

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
