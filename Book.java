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

import com.db.YGConn;

public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	BookDAO dao = new BookDAO();
	Scanner sc = new Scanner(System.in);
	private String path = System.getProperty("user.dir");
	private File f = new File(path, "\\data\\180621book.txt");
	List<BookDTO> lists = new ArrayList<BookDTO>();
	boolean borrow = false;


	String[] printName = new String[20];
	int getsu=0;
	int tot1 =0;
	private int tot =0;
	//private List<UserVO> uLists = new ArrayList<UserVO>();

	@SuppressWarnings("unchecked")
	public Book() { // 북파일 생성하는 생성자

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null; // pstmt 가 stmt보다 훨씬빠름
		ResultSet rs = null;
		String sql;

		try {
			sql = "select userid,id,name,author,rental ";
			sql += "from books";

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

	}

	/*	try {

			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();

			}
			if (f.exists()) {

				FileInputStream fis = new FileInputStream(f);

				ObjectInputStream ois = new ObjectInputStream(fis);

				lists = (List<BookDTO>) ois.readObject();

				dao.loadingData(lists);



				fis.close();
				ois.close();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	 */


	/*public void writeBookFile() { // 파일저장하는메소드

		try {

			if (lists != null) {

				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(lists);// 리스트로 파일을저장

				fos.close();
				oos.close();
				//System.out.println("파일 저장 성공!");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/

	public void bookPrint() {

		try {
			System.out.println();
			System.out.println("  도서번호          책이름              저자        대여여부      대여자ID  ");
			System.out.println("==============================================================================");

			Iterator<BookDTO> it = dao.getBookLists().iterator();

			while (it.hasNext()) {
				BookDTO booksvo = it.next();
				System.out.println(booksvo.toString());
			}
			System.out.println("==============================================================================");
			System.out.println();
		} catch (Exception e) {
			System.out.println("  데이터가없습니다");
		}
	}

	public void bookInput() {// 도서추가

		Scanner sc = new Scanner(System.in);

		BookDTO vo = new BookDTO();


		try {
			System.out.print("  도서번호? \n : ");
			vo.setId(sc.nextInt());

			Iterator<BookDTO> it = lists.iterator();

			while(it.hasNext()){

				BookDTO vo1 = it.next();
				if(vo.getId()==vo1.getId()){
					System.out.println("  이미 존재하는 도서번호입니다.  ");
					return;
				}

			} 

			System.out.print("  책이름? \n : ");
			vo.setName(sc.next());

			System.out.print("  저자? \n : ");
			vo.setAuthor(sc.next());

			vo.setRental(0);;


			lists.add(vo);
			dao.insertData(vo);

			System.out.println("  추가되었습니다");
		} catch (Exception e) {
			System.out.println("  잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}

	}// end of input

	public void bookDelete() {// 삭제메소드

		try {

			System.out.print("  삭제할 책의 번호를 입력하세요 \n : ");
			int n = sc.nextInt();


			Iterator<BookDTO> it = lists.iterator();

			while(it.hasNext()){

				BookDTO vo = it.next();
				if(n==vo.getId()){
					lists.remove(vo);
					dao.deleteData(vo.getId());
					System.out.println("  삭제되었습니다  ");
					break;
				}

			} 
		}catch (Exception e) {
			System.out.println(" 잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}






		/*for (int i = 0; i < lists.size(); i++) {

			if (n == lists.get(i).getId())
				lists.remove(i);
			System.out.println("삭제되었습니다");
			break;

		}// end of for
		 */


	}// end of delete



	public void bookBorrow() {

		User user = new User();



		try {


			System.out.print(" 대여할 도서 번호를 입력하세요 \n :");
			int w = sc.nextInt();
			//리스트를 만들어서 db에서 리스트에 넣고
			//리스트로 비교
			for(int i = 0; i < lists.size(); i++) {//리스트를 다뒤짐

				if(w == lists.get(i).getId()){
					borrow=true;
					break;
				}
			}

			if(!borrow){
				System.out.println(" 도서번호 입력 오류");
				return;
			}



			int novel = 1000;
			int carton = 400;
			String w1 = Integer.toString(w);
			String userId="";
			String getName="";

			System.out.print(" 대여하는사람의 ID를 입력하세요 \n : ");
			userId=sc.next();



			if(user.setLogin(userId)){//아이디가있으면 true

				for (int j=0; j< lists.size();j++) {//리스트를 다뒤짐


					if (w == lists.get(j).getId()&&lists.get(j).getRental()==1) {
						System.out.println(lists.get(j));
						return;
					}
					else if(w == lists.get(j).getId()&&lists.get(j).getRental()==0){
						lists.get(j).setRental(1);
						lists.get(j).setUserId(userId);
						dao.borrowData(lists.get(j).getUserId(), lists.get(j).getRental(),w);

						getName = lists.get(j).getName();
					}
				}





			}else{
				return;
			}


			/*ur.setLogin(userId);


	if(ur.login.equals("missMatch")) {
		ur.login = "";
		return;
	}*/









			if(w1.charAt(0)<='4'){
				tot1 += novel;
				dao.getMoney(novel);
			}else if(w1.charAt(0)>'4'){
				tot1 += carton;
				dao.getMoney(carton);
			}



			System.out.println("┏──────────┓");
			System.out.println("┃1.추가   2.완료     ┃");
			System.out.print("┗──────────┛\n : ");

			Thread printtot = new PrintTot();
			Thread mainTh = Thread.currentThread(); 
			Thread printtot2 = new PrintTot2();

			for(int i=0; i<printName.length;i++) {
				if(getsu==i) 
					printName[i]=getName;

			}
			getsu++;

			if(sc.nextInt()==1)
				bookBorrow(userId);
			else{
				setTot(tot1);

				printtot.start();
				printtot.join();
				if(tot1>=1000) { 
					for(int i=0;i<getsu;i++) {
						if(printName[i].length()==3)	
							System.out.println(" ▦                    "+printName[i]+"                      ▦");
						if(printName[i].length()==4)
							System.out.println(" ▦                    "+printName[i]+"                    ▦");
						if(printName[i].length()==5)
							System.out.println(" ▦                   "+printName[i]+"                   ▦");mainTh.sleep(300);
					}
				}
				else if(tot1<=800) { 
					for(int i=0;i<getsu;i++) {
						if(printName[i].length()==3)	
							System.out.println(" ▦                    "+printName[i]+"                      ▦");
						if(printName[i].length()==4)
							System.out.println(" ▦                    "+printName[i]+"                    ▦");
						if(printName[i].length()==5)
							System.out.println(" ▦                   "+printName[i]+"                   ▦");mainTh.sleep(300);
					}
				}
				System.out.println(" ▦                                                ▦");mainTh.sleep(300);
				System.out.println(" ▦                                                ▦");mainTh.sleep(300);
				if(tot1>=1000){
					System.out.println(" ▦                 금액:  "+tot1+"원                  ▦");
				}
				else if(tot1<=800){ 
					System.out.println(" ▦                 금액:  "+tot1+"원                   ▦");mainTh.sleep(300);
				}
				printtot2.start();
				printtot2.join();

				tot1=0;
				getsu=0;


			}


		}catch (Exception e) {
			System.out.println(" 잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}




	}






	public void bookReturn() {



		try {

			System.out.println("  반납할 도서 번호를 입력하세요  ");
			int w = sc.nextInt();

			for (int i = 0; i < lists.size(); i++) {

				if (w == lists.get(i).getId())
					if (!(lists.get(i).getRental()==1)) {
						System.out.println("  대여중이 아닙니다  ");
					} else if (lists.get(i).getRental()==1) {
						System.out.println("  정상적으로 반납되었습니다.  ");
						lists.get(i).setRental(0);
						lists.get(i).setUserId(null);
						dao.borrowData(null,0,w);

					}

			}

		} catch (Exception e) {
			System.out.println(" 잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}

	}





	public void searchBook() {


		int id = 0;
		UserDTO ob = new UserDTO();
		boolean flag = false;

		try {

			System.out.println("  검색할 도서번호?  ");
			String searchid = sc.next();

			Iterator<BookDTO> it = lists.iterator();

			while (it.hasNext()) {
				BookDTO vo = it.next();
				if (searchid.equals(vo.getId())) {
					System.out.println(vo.toString());
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("  찾는대상이 없습니다.  ");
			}

		} catch (Exception e) {
			System.out.println(" 잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}
	}

	public boolean searchFlagBook() {

		boolean flag = false;

		try {

			System.out.println("  검색할 도서번호?  ");
			String searchid = sc.next();

			Iterator<BookDTO> it = lists.iterator();

			while (it.hasNext()) {
				BookDTO vo = it.next();
				if (searchid.equals(vo.getId())) {
					System.out.println(vo.toString());
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("  찾는대상이 없습니다.  ");
			}


		} catch (Exception e) {
			System.out.println(" 잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}

		return flag;
	}




	public List<Integer> rentalBookList() { // 도서번호를받아서 책정보출력한후 도서번호반환



		int id = 0;




		System.out.println("  검색할 도서번호?  ");
		int searchid = sc.nextInt();


		List<Integer> booklist = new ArrayList<Integer>();



		Iterator<BookDTO> it = lists.iterator();
		while (it.hasNext()) {
			BookDTO vo = it.next();


			if (searchid==(vo.getId())) { // 도서번호와 검색할 도서번호 가 같으면
				if(vo.getRental()==1){ // 대출된도서인지 대출안된도서인지 구분
					System.out.println(vo.toString()); // 대출된도서라면 책정보를 출력
					booklist.add(id, vo.getId()); 	//  인트속성 리스트에 책의 번호를 더함
					id++;
				}



			}else{

			}
		}




		return booklist;// 리스트에 번호들을 반환함

	}


	/*public int rentalBookList() { // 도서번호를받아서 책정보출력한후 도서번호반환



		int id = 0;
		System.out.println("검색할 도서번호?");
		int searchid = sc.nextInt();





		Iterator<BookVO> it = lists.iterator();
		while (it.hasNext()) {
			BookVO vo = it.next();


			if (searchid==(vo.getId())) { // 도서번호와 검색할 도서번호 가 같으면
				if(vo.isRental()){ // 대출된도서인지 대출안된도서인지 구분
					System.out.println(vo.toString()); // 대출된도서라면 책정보를 출력
					id =vo.getId();

					//  인트속성 리스트에 책의 번호를 더함

				}



			}else{

			}
		}
		return id;// 리스트에 번호들을 반환함





	}*/



	public String getUserId(int id){//도서번호를통해서 USerid를 가져와야함

		String getid="";


		Iterator<BookDTO> it = lists.iterator();

		while (it.hasNext()) {
			BookDTO vo = it.next();
			if (id==(vo.getId())) {//도서번호와 책의 번호가 같으면

				getid=vo.getUserId(); // 해당도서의 사용자id를 가져옴

			}else{
				break;
			}
		}


		return getid;

	}




	public int getTot() {
		return tot;

	}




	public void setTot(int tot1) {
		this.tot += tot1;
	}








	public void bookBorrow(String usersid) {

		User user = new User();



		try {


			System.out.print(" 대여할 도서 번호를 입력하세요 \n :");
			int w = sc.nextInt();
			//리스트를 만들어서 db에서 리스트에 넣고
			//리스트로 비교
			for(int i = 0; i < lists.size(); i++) {//리스트를 다뒤짐

				if(w == lists.get(i).getId()){
					borrow=true;
					break;
				}
			}

			if(!borrow){
				System.out.println(" 도서번호 입력 오류");
				return;
			}



			int novel = 1000;
			int carton = 400;
			String w1 = Integer.toString(w);
			String userId="";
			String getName="";

			userId=usersid;



			if(user.setLogin(userId)){//아이디가있으면 true

				for (int j=0; j< lists.size();j++) {//리스트를 다뒤짐


					if (w == lists.get(j).getId()&&lists.get(j).getRental()==1) {
						System.out.println(lists.get(j));
						return;
					}
					else if(w == lists.get(j).getId()&&lists.get(j).getRental()==0){
						lists.get(j).setRental(1);
						lists.get(j).setUserId(userId);
						dao.borrowData(lists.get(j).getUserId(), lists.get(j).getRental(),w);

						getName = lists.get(j).getName();
					}
				}





			}else{
				return;
			}


			if(w1.charAt(0)<='4'){
				tot1 += novel;
				dao.getMoney(novel);
			}else if(w1.charAt(0)>'4'){
				tot1 += carton;
				dao.getMoney(carton);
			}



			System.out.println("┏──────────┓");
			System.out.println("┃1.추가   2.완료     ┃");
			System.out.print("┗──────────┛\n : ");

			Thread printtot = new PrintTot();
			Thread mainTh = Thread.currentThread(); 
			Thread printtot2 = new PrintTot2();

			for(int i=0; i<printName.length;i++) {
				if(getsu==i) 
					printName[i]=getName;

			}
			getsu++;

			if(sc.nextInt()==1)
				bookBorrow(userId);
			else{
				setTot(tot1);

				printtot.start();
				printtot.join();
				if(tot1>=1000) { 
					for(int i=0;i<getsu;i++) {
						if(printName[i].length()==3)	
							System.out.println(" ▦                    "+printName[i]+"                      ▦");
						if(printName[i].length()==4)
							System.out.println(" ▦                    "+printName[i]+"                    ▦");
						if(printName[i].length()==5)
							System.out.println(" ▦                   "+printName[i]+"                   ▦");mainTh.sleep(300);
					}
				}
				else if(tot1<=800) { 
					for(int i=0;i<getsu;i++) {
						if(printName[i].length()==3)	
							System.out.println(" ▦                    "+printName[i]+"                      ▦");
						if(printName[i].length()==4)
							System.out.println(" ▦                    "+printName[i]+"                    ▦");
						if(printName[i].length()==5)
							System.out.println(" ▦                   "+printName[i]+"                   ▦");mainTh.sleep(300);
					}
				}
				System.out.println(" ▦                                                ▦");mainTh.sleep(300);
				System.out.println(" ▦                                                ▦");mainTh.sleep(300);
				if(tot1>=1000){
					System.out.println(" ▦                 금액:  "+tot1+"원                  ▦");
				}
				else if(tot1<=800){ 
					System.out.println(" ▦                 금액:  "+tot1+"원                   ▦");mainTh.sleep(300);
				}
				printtot2.start();
				printtot2.join();

				tot1=0;
				getsu=0;


			}


		}catch (Exception e) {
			System.out.println(" 잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}






	}

}


