package com.project2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.YGConn;

public class UserDAO {

	public int userInputData(UserDTO dto){//ȸ������

		int result = 0;

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into user1 (id,pw,name,gender,birth,tel,email) ";
			sql+= "values (?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getTel());
			pstmt.setString(7, dto.getEmail());


			result = pstmt.executeUpdate();

			pstmt.close();



		} catch (Exception e) {
			System.out.println(" �Է¿���");
		}
		return result;

	}

	//Ż��
	public int deleteData(String id){
		int result = 0;

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete user1 where id=? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(" �Է¿���");
		}
		return result;

	}

	//5.ID�˻�
	public UserDTO getList(String id){

		Connection conn = YGConn.getConnection();
		UserDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {
			sql = "select id ";
			sql+= "from user1 where id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if(rs.next()){

				dto = new UserDTO();

				dto.setId(rs.getString("id"));

			}
			rs.close();
			pstmt.close();


		} catch (Exception e) {
			System.out.println(" �Է¿���");
		}
		return dto;


	}

	//1.��üȸ��
	public List<UserDTO> getLists(){//

		List<UserDTO> lists = new ArrayList<UserDTO>();
		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select id, name, gender, tel, email ";
			sql+= "from users order by id";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while(rs.next()){

				UserDTO dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));		

				lists.add(dto);

			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(" �Է¿���");
		}
		return lists;

	}

	//����
	public int updateData(UserDTO dto){

		int result = 0;
		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update user1 set pw=?,birth=?,tel=?,email=? ";
			sql+= "where id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getBirth());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getEmail());	
			pstmt.setString(5, dto.getId());	


			result = pstmt.executeUpdate();

			pstmt.close();



		} catch (Exception e) {
			System.out.println(" �Է¿���");
		}
		return result;
	}

/*	public boolean setAdminLogin(String userId) {


		boolean flag = false;
		String pw = "*****";

		if(userId.equals("admin")){

			System.out.print("��й�ȣ�� �Է��ϼ���\n :");
			if(pw.equals(sc.next())){
				flag = true;
			}else{System.out.println("��й�ȣ�� �ٸ��ϴ�");}
		}else{
			System.out.println("�α��������� ��ġ�����ʽ��ϴ�.");
		}
		return flag;

	}*/









}
