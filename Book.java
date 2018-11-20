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
	public Book() { // ������ �����ϴ� ������

		Connection conn = YGConn.getConnection();
		PreparedStatement pstmt = null; // pstmt �� stmt���� �ξ�����
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


	/*public void writeBookFile() { // ���������ϴ¸޼ҵ�

		try {

			if (lists != null) {

				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(lists);// ����Ʈ�� ����������

				fos.close();
				oos.close();
				//System.out.println("���� ���� ����!");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/

	public void bookPrint() {

		try {
			System.out.println();
			System.out.println("  ������ȣ          å�̸�              ����        �뿩����      �뿩��ID  ");
			System.out.println("==============================================================================");

			Iterator<BookDTO> it = dao.getBookLists().iterator();

			while (it.hasNext()) {
				BookDTO booksvo = it.next();
				System.out.println(booksvo.toString());
			}
			System.out.println("==============================================================================");
			System.out.println();
		} catch (Exception e) {
			System.out.println("  �����Ͱ������ϴ�");
		}
	}

	public void bookInput() {// �����߰�

		Scanner sc = new Scanner(System.in);

		BookDTO vo = new BookDTO();


		try {
			System.out.print("  ������ȣ? \n : ");
			vo.setId(sc.nextInt());

			Iterator<BookDTO> it = lists.iterator();

			while(it.hasNext()){

				BookDTO vo1 = it.next();
				if(vo.getId()==vo1.getId()){
					System.out.println("  �̹� �����ϴ� ������ȣ�Դϴ�.  ");
					return;
				}

			} 

			System.out.print("  å�̸�? \n : ");
			vo.setName(sc.next());

			System.out.print("  ����? \n : ");
			vo.setAuthor(sc.next());

			vo.setRental(0);;


			lists.add(vo);
			dao.insertData(vo);

			System.out.println("  �߰��Ǿ����ϴ�");
		} catch (Exception e) {
			System.out.println("  �߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		}

	}// end of input

	public void bookDelete() {// �����޼ҵ�

		try {

			System.out.print("  ������ å�� ��ȣ�� �Է��ϼ��� \n : ");
			int n = sc.nextInt();


			Iterator<BookDTO> it = lists.iterator();

			while(it.hasNext()){

				BookDTO vo = it.next();
				if(n==vo.getId()){
					lists.remove(vo);
					dao.deleteData(vo.getId());
					System.out.println("  �����Ǿ����ϴ�  ");
					break;
				}

			} 
		}catch (Exception e) {
			System.out.println(" �߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		}






		/*for (int i = 0; i < lists.size(); i++) {

			if (n == lists.get(i).getId())
				lists.remove(i);
			System.out.println("�����Ǿ����ϴ�");
			break;

		}// end of for
		 */


	}// end of delete



	public void bookBorrow() {

		User user = new User();



		try {


			System.out.print(" �뿩�� ���� ��ȣ�� �Է��ϼ��� \n :");
			int w = sc.nextInt();
			//����Ʈ�� ���� db���� ����Ʈ�� �ְ�
			//����Ʈ�� ��
			for(int i = 0; i < lists.size(); i++) {//����Ʈ�� �ٵ���

				if(w == lists.get(i).getId()){
					borrow=true;
					break;
				}
			}

			if(!borrow){
				System.out.println(" ������ȣ �Է� ����");
				return;
			}



			int novel = 1000;
			int carton = 400;
			String w1 = Integer.toString(w);
			String userId="";
			String getName="";

			System.out.print(" �뿩�ϴ»���� ID�� �Է��ϼ��� \n : ");
			userId=sc.next();



			if(user.setLogin(userId)){//���̵������� true

				for (int j=0; j< lists.size();j++) {//����Ʈ�� �ٵ���


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



			System.out.println("������������������������");
			System.out.println("��1.�߰�   2.�Ϸ�     ��");
			System.out.print("������������������������\n : ");

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
							System.out.println(" ��                    "+printName[i]+"                      ��");
						if(printName[i].length()==4)
							System.out.println(" ��                    "+printName[i]+"                    ��");
						if(printName[i].length()==5)
							System.out.println(" ��                   "+printName[i]+"                   ��");mainTh.sleep(300);
					}
				}
				else if(tot1<=800) { 
					for(int i=0;i<getsu;i++) {
						if(printName[i].length()==3)	
							System.out.println(" ��                    "+printName[i]+"                      ��");
						if(printName[i].length()==4)
							System.out.println(" ��                    "+printName[i]+"                    ��");
						if(printName[i].length()==5)
							System.out.println(" ��                   "+printName[i]+"                   ��");mainTh.sleep(300);
					}
				}
				System.out.println(" ��                                                ��");mainTh.sleep(300);
				System.out.println(" ��                                                ��");mainTh.sleep(300);
				if(tot1>=1000){
					System.out.println(" ��                 �ݾ�:  "+tot1+"��                  ��");
				}
				else if(tot1<=800){ 
					System.out.println(" ��                 �ݾ�:  "+tot1+"��                   ��");mainTh.sleep(300);
				}
				printtot2.start();
				printtot2.join();

				tot1=0;
				getsu=0;


			}


		}catch (Exception e) {
			System.out.println(" �߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		}




	}






	public void bookReturn() {



		try {

			System.out.println("  �ݳ��� ���� ��ȣ�� �Է��ϼ���  ");
			int w = sc.nextInt();

			for (int i = 0; i < lists.size(); i++) {

				if (w == lists.get(i).getId())
					if (!(lists.get(i).getRental()==1)) {
						System.out.println("  �뿩���� �ƴմϴ�  ");
					} else if (lists.get(i).getRental()==1) {
						System.out.println("  ���������� �ݳ��Ǿ����ϴ�.  ");
						lists.get(i).setRental(0);
						lists.get(i).setUserId(null);
						dao.borrowData(null,0,w);

					}

			}

		} catch (Exception e) {
			System.out.println(" �߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		}

	}





	public void searchBook() {


		int id = 0;
		UserDTO ob = new UserDTO();
		boolean flag = false;

		try {

			System.out.println("  �˻��� ������ȣ?  ");
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
				System.out.println("  ã�´���� �����ϴ�.  ");
			}

		} catch (Exception e) {
			System.out.println(" �߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		}
	}

	public boolean searchFlagBook() {

		boolean flag = false;

		try {

			System.out.println("  �˻��� ������ȣ?  ");
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
				System.out.println("  ã�´���� �����ϴ�.  ");
			}


		} catch (Exception e) {
			System.out.println(" �߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		}

		return flag;
	}




	public List<Integer> rentalBookList() { // ������ȣ���޾Ƽ� å����������� ������ȣ��ȯ



		int id = 0;




		System.out.println("  �˻��� ������ȣ?  ");
		int searchid = sc.nextInt();


		List<Integer> booklist = new ArrayList<Integer>();



		Iterator<BookDTO> it = lists.iterator();
		while (it.hasNext()) {
			BookDTO vo = it.next();


			if (searchid==(vo.getId())) { // ������ȣ�� �˻��� ������ȣ �� ������
				if(vo.getRental()==1){ // ����ȵ������� ����ȵȵ������� ����
					System.out.println(vo.toString()); // ����ȵ������ å������ ���
					booklist.add(id, vo.getId()); 	//  ��Ʈ�Ӽ� ����Ʈ�� å�� ��ȣ�� ����
					id++;
				}



			}else{

			}
		}




		return booklist;// ����Ʈ�� ��ȣ���� ��ȯ��

	}


	/*public int rentalBookList() { // ������ȣ���޾Ƽ� å����������� ������ȣ��ȯ



		int id = 0;
		System.out.println("�˻��� ������ȣ?");
		int searchid = sc.nextInt();





		Iterator<BookVO> it = lists.iterator();
		while (it.hasNext()) {
			BookVO vo = it.next();


			if (searchid==(vo.getId())) { // ������ȣ�� �˻��� ������ȣ �� ������
				if(vo.isRental()){ // ����ȵ������� ����ȵȵ������� ����
					System.out.println(vo.toString()); // ����ȵ������ å������ ���
					id =vo.getId();

					//  ��Ʈ�Ӽ� ����Ʈ�� å�� ��ȣ�� ����

				}



			}else{

			}
		}
		return id;// ����Ʈ�� ��ȣ���� ��ȯ��





	}*/



	public String getUserId(int id){//������ȣ�����ؼ� USerid�� �����;���

		String getid="";


		Iterator<BookDTO> it = lists.iterator();

		while (it.hasNext()) {
			BookDTO vo = it.next();
			if (id==(vo.getId())) {//������ȣ�� å�� ��ȣ�� ������

				getid=vo.getUserId(); // �ش絵���� �����id�� ������

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


			System.out.print(" �뿩�� ���� ��ȣ�� �Է��ϼ��� \n :");
			int w = sc.nextInt();
			//����Ʈ�� ���� db���� ����Ʈ�� �ְ�
			//����Ʈ�� ��
			for(int i = 0; i < lists.size(); i++) {//����Ʈ�� �ٵ���

				if(w == lists.get(i).getId()){
					borrow=true;
					break;
				}
			}

			if(!borrow){
				System.out.println(" ������ȣ �Է� ����");
				return;
			}



			int novel = 1000;
			int carton = 400;
			String w1 = Integer.toString(w);
			String userId="";
			String getName="";

			userId=usersid;



			if(user.setLogin(userId)){//���̵������� true

				for (int j=0; j< lists.size();j++) {//����Ʈ�� �ٵ���


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



			System.out.println("������������������������");
			System.out.println("��1.�߰�   2.�Ϸ�     ��");
			System.out.print("������������������������\n : ");

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
							System.out.println(" ��                    "+printName[i]+"                      ��");
						if(printName[i].length()==4)
							System.out.println(" ��                    "+printName[i]+"                    ��");
						if(printName[i].length()==5)
							System.out.println(" ��                   "+printName[i]+"                   ��");mainTh.sleep(300);
					}
				}
				else if(tot1<=800) { 
					for(int i=0;i<getsu;i++) {
						if(printName[i].length()==3)	
							System.out.println(" ��                    "+printName[i]+"                      ��");
						if(printName[i].length()==4)
							System.out.println(" ��                    "+printName[i]+"                    ��");
						if(printName[i].length()==5)
							System.out.println(" ��                   "+printName[i]+"                   ��");mainTh.sleep(300);
					}
				}
				System.out.println(" ��                                                ��");mainTh.sleep(300);
				System.out.println(" ��                                                ��");mainTh.sleep(300);
				if(tot1>=1000){
					System.out.println(" ��                 �ݾ�:  "+tot1+"��                  ��");
				}
				else if(tot1<=800){ 
					System.out.println(" ��                 �ݾ�:  "+tot1+"��                   ��");mainTh.sleep(300);
				}
				printtot2.start();
				printtot2.join();

				tot1=0;
				getsu=0;


			}


		}catch (Exception e) {
			System.out.println(" �߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		}






	}

}


