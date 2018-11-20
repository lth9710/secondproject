package com.project2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.db.DBConn;
import com.db.YGConn;

public class BookDAO {

	
	
	
	// 1.�����Է�
	public int insertData(BookDTO dto) {



		int result = 0;

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into books (id,name,author,rental) ";
			sql += "values(?,?,?,?)"; // �����͵��ڸ��� ?�� ǥ���ϴ°� prepared statement

			pstmt = conn.prepareStatement(sql); // �׳� statement�� ���⼭
			// conn.startment()���ϴµ� ���⼭��
			// sql���������

			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getAuthor());
			pstmt.setInt(4, 0);
			result = pstmt.executeUpdate(); // ������ ��⶧���� ���⼭ sql ���ʿ䰡����

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	// 3.��������
	public int deleteData(int id) {

		int result = 0;
		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete books ";
			sql += "where id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}


	//�����뿩�κп� ���� DAO	
	public int borrowData(String  userid,int rentno,int w) {



		int result = 0;

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update books set userid=?,";
			sql += "rental=? where id=?"; // �����͵��ڸ��� ?�� ǥ���ϴ°� prepared statement

			pstmt = conn.prepareStatement(sql); // �׳� statement�� ���⼭
			// conn.startment()���ϴµ� ���⼭��
			// sql���������

			pstmt.setString(1, userid);
			pstmt.setInt(2,rentno);
			pstmt.setInt(3, w);
			result = pstmt.executeUpdate(); // ������ ��⶧���� ���⼭ sql ���ʿ䰡����

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	//��ü���

	public List<BookDTO> getBookLists() {

		List<BookDTO> lists = new ArrayList<BookDTO>();

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null; // pstmt �� stmt���� �ξ�����
		ResultSet rs = null;
		String sql;

		try {
			sql = "select userid,id,name,author,rental";
			sql += " from books order by id";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				BookDTO dto = new BookDTO();

				dto.setUserId(rs.getString("userid"));
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setAuthor(rs.getString("author"));
				dto.setRental(rs.getInt("rental"));

				lists.add(dto);

			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}




	public void loadingData(List<BookDTO> loadLists) {


		List<BookDTO> llists = new ArrayList<BookDTO>();
		int result = 0;

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {
			llists=loadLists;
			Iterator<BookDTO> it = llists.iterator();

			while(it.hasNext()){	
				BookDTO bkvo = it.next();

				sql = "insert into books (userid,id,name,author,rental) ";
				sql += "values(?,?,?,?,?)"; // �����͵��ڸ��� ?�� ǥ���ϴ°� prepared statement

				pstmt = conn.prepareStatement(sql); // �׳� statement�� ���⼭
				// conn.startment()���ϴµ� ���⼭��
				// sql���������
				pstmt.setString(1, bkvo.getUserId());
				pstmt.setInt(2, bkvo.getId());
				pstmt.setString(3, bkvo.getName());
				pstmt.setString(4, bkvo.getAuthor());
				pstmt.setInt(5,bkvo.getRental());
				result = pstmt.executeUpdate(); // ������ ��⶧���� ���⼭ sql ���ʿ䰡����

				pstmt.close();

			}
		} catch (Exception e) {
			System.out.println("�ε���...(�ߺ�)");
		}


	}


	public void getMoney(int money){

		
		
		int result = 0;

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into money (price,borrowDate) ";
			sql += "values(?,sysdate)"; // �����͵��ڸ��� ?�� ǥ���ϴ°� prepared statement

			pstmt = conn.prepareStatement(sql); // �׳� statement�� ���⼭
			// conn.startment()���ϴµ� ���⼭��
			// sql���������

			pstmt.setInt(1, money);
			result = pstmt.executeUpdate(); // ������ ��⶧���� ���⼭ sql ���ʿ䰡����

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}





	}

	public int getMoneyTot(){


		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null; // pstmt �� stmt���� �ξ�����
		ResultSet rs = null;
		String sql;
		int sum=0;
		
		try {
			sql = "select sum(price) sum";
			sql += " from money";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			rs.next();
			sum=rs.getInt(1);
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
		}

		return sum;

	}
}