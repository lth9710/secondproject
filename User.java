package com.project2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.db.DBConn;
import com.db.YGConn;
import com.score8.ScoreDTO;





public class User implements Serializable {

	UserDAO udao = new UserDAO();
	Scanner sc = new Scanner(System.in);
	List<UserDTO> ulists = new ArrayList<UserDTO>();
	public User() {

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null; // pstmt 가 stmt보다 훨씬빠름
		ResultSet rs = null;
		String sql;

		try {
			sql = "select id,pw,name,gender,birth,tel,email ";
			sql += "from user1";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				UserDTO dto = new UserDTO();

				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getString("birth"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));

				ulists.add(dto);

			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());

		}	

	}



	/*public void userWriteFile(){//파일저장

		try {	

			if(ulists!=null){

				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(ulists);

				fos.close();
				oos.close();
				//System.out.println("회원가입성공!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	 */










	public void userPrint(){//출력
		try {

			System.out.println();
			System.out.println("    아이디          이름                 성별         번호                    이메일 ");
			System.out.println("======================================================================================");

			Iterator<UserDTO> it = udao.getLists().iterator();

			while(it.hasNext()){
				UserDTO vo = it.next();

				System.out.println(vo.toString());
			}
			System.out.println("======================================================================================");
			System.out.println();

		} catch (Exception e) {
			System.out.println("  데이터가 없습니다.");

		}
	}









	public void userInput(){//입력




		Scanner sc = new Scanner(System.in);

		UserDTO vo = new UserDTO();

		String pw1;


		try {
			System.out.print("  ID :");
			vo.setId(sc.next());

			if(vo.getId().length()<5||vo.getId().length()>15){
				System.out.println("  ID는 5~10자이내, 영문자와 숫자를 혼용하여 만드세요.  ");
			}

			int tot =0;

			for(int i =0; i<vo.getId().length();i++){

				char ch = vo.getId().charAt(i);

				if((ch<64||ch>90)&&(ch<97||ch>122)&&(ch<48||ch>57)){
				}

				if(ch>=48&&ch<=57){
					tot++;
				}
			}

			if(tot==0||tot==vo.getId().length()){
				System.out.println("  영문자 숫자 혼용입니다  ");

				return;
			}

			if(searchId(vo.getId())){
				System.out.println("  ID가 존재합니다..  ");
				return;
			}

			//vo.setUserId(vo.getId());
			while(true){
				System.out.print("  비밀번호 :   ");
				vo.setPw(sc.next());
				System.out.print("  비밀번호 재확인  ");
				pw1 = sc.next();
				if(vo.getPw().equals(pw1)){
					break;
				}
			}

			System.out.print("  이름 :  ");
			vo.setName(sc.next());
			System.out.print("  성별(m or f) :   ");
			vo.setGender(sc.next());
			System.out.print("  생년월일 :   ");
			vo.setBirth(sc.next());
			System.out.print("  Email(abc@naver.com) :   ");
			vo.setEmail(sc.next());
			System.out.print("  전화번호 :   ");
			vo.setTel(sc.next());

			//			if(lists==null)
			//				lists = new ArrayList<UserDTO>();
			//
			//
			//			


			if(udao.userInputData(vo)==1){
				ulists.add(vo);
				System.out.println("  회원가입이 완료되었습니다.  ");
			}else{
				System.out.println("회원가입 실패");
			}




		}catch (Exception e) {
			System.out.println("  잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}


	}



	public boolean searchId(String id) {



		Iterator<UserDTO> it = ulists.iterator();

		while(it.hasNext()){

			UserDTO vo = it.next();
			if(vo.getId().equals(id)){
				return true;
			}

		}
		return false;




	}










	public void searchUser() {

		boolean flag = false;
		System.out.println("  검색할 아이디?  ");
		String searchid = sc.next();

		Iterator<UserDTO> it =ulists.iterator();

		while(it.hasNext()){
			UserDTO vo = it.next();
			if(searchid.equals(vo.getId())){
				System.out.println(vo.toString());
				flag =true;
			}	
		}
		if(!flag){
			System.out.println("  찾는대상이 없습니다.  ");
		}
	}
	//
//회원정보수정
	public void userUpdate(){

		String pw2="";
		int index = 0;
		boolean flag = false;

		
		System.out.print("  수정할 아이디?  \n :");
		String searchid = sc.next();

		
		Iterator<UserDTO> it =ulists.iterator();

		while(it.hasNext()){
			UserDTO vo = it.next();
			if(searchid.equals(vo.getId())){
				flag =true;
			}	
		}
		if(!flag){
			System.out.println(" 없는 아이디입니다  ");
			return;
		}

		UserDTO vo2 = new UserDTO();
		vo2.setId(searchid);

				

		while(true){
			System.out.print(" 수정할 비밀번호 :   ");
			vo2.setPw(sc.next());
			System.out.print("수정할 비밀번호 재확인:   ");
			pw2 = sc.next();
			if(vo2.getPw().equals(pw2)){
				break;
			}
		}

		System.out.print("  생년월일 :   ");
		vo2.setBirth(sc.next());
		System.out.print("  Email :   ");
		vo2.setEmail(sc.next());
		System.out.print("  전화번호 :   ");
		vo2.setTel(sc.next());
		//vo2.setUserId(searchid);

		if(udao.updateData(vo2)==1){
		it =ulists.iterator();

		while(it.hasNext()){
			UserDTO vo = it.next();
			if(searchid.equals(vo.getId())){
				index = ulists.indexOf(vo);
				ulists.set(index, vo2);

				System.out.println("  수정되었습니다.  ");

				flag =true;
			}	
		}
		}
		if(!flag){
			System.out.println("  찾는 대상이 없습니다.  ");
		}


	}







	//회원탈퇴
	public void userDelete() {
try {
	
} catch (Exception e) {
	// TODO: handle exception
}
		System.out.print("  삭제할 아이디? \n : ");
		String deleteId = sc.next();

		Iterator<UserDTO> it = ulists.iterator();

		while(it.hasNext()){

			UserDTO vo = it.next();
			if(deleteId.equals(vo.getId())){

				ulists.remove(vo);
				udao.deleteData(vo.getId());
				System.out.println("  삭제되었습니다  ");
				break;
			}else{
				System.out.println("  잘못입력하셨습니다");
				break;
			}


		}
	}






	public void rentalUserList(String searchid){ // id값을 받아서 대여중이아닌지, 대여중이라면 누가빌렸는지



		if(searchid.equals("")){
			System.out.println("  대여중이 아닌 도서입니다  ");
			return;
		}

		Iterator<UserDTO> userit = ulists.iterator();
		while(userit.hasNext()){
			UserDTO uvo = userit.next();
			if(searchid.equals(uvo.getId())){
				System.out.println("  대여자정보: "+uvo.toString());

			}

		}

	}




	public void print(){//출력

		Iterator<UserDTO> it = ulists.iterator();
		while(it.hasNext()){
			UserDTO vo = it.next();
			System.out.println(vo.toString());
		}
	}


	public boolean setLogin(String userId) {


		/*for (int i = 0; i < lists.size(); i++) {//리스트를 다뒤짐

			if(w==(lists.get(i).getId())){
				borrow = true;
				break;
				//아이디값과 입력값이 같음 >> 다음으로 넘어감
			}
			}
		if(borrow){

		}else{
			System.out.println(" 도서번호 입력 오류");
			return;
		}*/
		boolean flag = false;
		for(int i=0; i<ulists.size();i++){

			if(userId.equals(ulists.get(i).getId()))
			{
				flag = true;
				break;
			}
		}
		if(flag==false){
			System.out.println("ID가 일치하지 않습니다.");
		}
		return flag;
	}


	public boolean setAdminLogin(String userId) {



		boolean flag = false;
		String pw = "*****";

		if(userId.equals("admin")){

			System.out.print("비밀번호를 입력하세요\n :");
			if(pw.equals(sc.next())){
				flag = true;
			}else{System.out.println("비밀번호가 다릅니다");}
		}else{
			System.out.println("로그인정보가 일치하지않습니다.");
		}

		return flag;




	}






	/*public int updateUser(UserDTO dto) {

		int result = 0;

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update user1 set pw=?,name=?,tel=?,email=? ";
			sql += "where id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getTel());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getId());

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}*/


}


























