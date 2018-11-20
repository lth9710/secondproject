package com.project2;

import java.io.Serializable;
import java.util.Scanner;

import com.db.YGConn;


public class Test implements Serializable{

	private static final long serialVersionUID = 1L;


	Book books = new Book();
	User ob = new User();
	Scanner sc = new Scanner(System.in);
	BookUser bu = new BookUser();
	Thread t3 = new EndScreen();



	public static void main(String[] args) {
		
		
		Book book = new Book();

		
		/*try {*/


		/*Thread t1 = new StartScreen();
			t1.start();

			//Thread t2 = Thread.currentThread(); 메인을 쓰레드로 지정

			t1.join();*/
		Test test = new Test();
		test.firstInterface();



	}

	public void firstInterface(){



		while(true){



			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□■■■□■□□□□□□■■□□■■□□□□□□□□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□■□□□□□□■■■□■□□□■□□■□□□□□□□□");
			System.out.println("□□□■■□□□□■■□□□□□□□□□□□★★□□□□□□□□□□■■□□■□■□■□■□□□■■■■□□□□□□□□");
			System.out.println("□□□■■□□□□■■□□□□□□□□□□□□□★★□□□□□□□□□□■□■□■□■□■□□□■□□□□□□□□□□□");
			System.out.println("□□□■■□□□□■■□□□□□□□□□□□□□□□★★□□□□□■■■□□■□■□■□□■■□□■■■□□□□□□□□");
			System.out.println("□□□■■■■■■■■□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□■■■■■■■■□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□■□□■■■□□□■■■□□□□");
			System.out.println("□□□■■□□□□■■□□□□□□□□□■■□□□□□□□□□□★★□□□□□□□□□■■□□■□■□□□■□□□□□□");
			System.out.println("□□□■■■■■■■■□□□□□□□□■■■■□□□□□□□□□□□★★□□□□□□□□■□□■■■□□□■■■□□□□");
			System.out.println("□□□■■■■■■■■□□□□□□□□■■■■□□□□□□□□□□□□□★★□□□□□□■□□■□■□□□■□■□□□□");
			System.out.println("□□□□□□■■□□□□□□□□□□■■□□■■□□□□□□□□□□□□□□★★□□□■■■□■■■□■□■■■□□□□");
			System.out.println("□■■■■■■■■■■■■□□□□□■■□□■■□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□□□");
			System.out.println("□■■■■■■■■■■■■□□□□■■□□□□■■□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□□□□□□□□□□□□■■□□□□■■□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□");
			System.out.println("□□□■■■■■■■■□□□□□■■□□□□□□■■□□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□");
			System.out.println("□□□■■■■■■■■□□□□□■■□□□□□□■■□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□");
			System.out.println("□□□□□□□□□■■□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□□");
			System.out.println("□□□□□□□□□■■□□□■■■■■■■■■■■■■■□□□■■■■■■■■■■■□□□□□□□□□□□□★★□□□□");
			System.out.println("□□□□□□□□□■■□□□■■■■■■■■■■■■■■□□□■■■■■■■■■■■□□□□□□□□□□□□□□★★□□");
			System.out.println("★★□□□□□□□■■□□□□□□□□□■■□□□□□□□□□□□□□□□□□□■■□□□□□□□□□□□□□□□□□□");
			System.out.println("□□★★□□□□□■■□□□□□□□□□■■□□□□□□□□□□□□□□□□□□■■□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□□★★□□□□□□□□□□□□□□■■□□□□□□□□□□□□□□□□□□■■□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□★★□□□□□□□□□□□□■■□□□□□□□□□□□□□■■□□□■■□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□□□★★□□□□□□□□□□■■□□□□□□□□□□□□□■■□□□□□□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□□□□□★★□□□□□□□□■■□□□□□□□■■■■■■■■■■■■■■■□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□□□□□□□★★□□□□□□□□□□□□□□□■■■■■■■■■■■■■■■□□□□□□□□□□□□■■□□");
			System.out.println("□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□■■□□□□■■□□■■□□");
			System.out.println("□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□■■■■■■■■■□□□□□■■□□□□■■□□■■□□");
			System.out.println("□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□■■□□□□□□□■■□□□□■■□□□□■■□□■■□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□■■□□□□□□□■■□□□□■■■■■■■■□□■■■□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□□■■□□□□□□□■■□□□□■■■■■■■■□□■■■□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□■■■■■■■■■□□□□□■■        ■■□□■■□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□□□■■■■■■■■□□■■□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□■■■■■■■■□□■■□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□□□□□□□□□■■□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□□□□□□□■■□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□□□□□■■■■■■■■■□□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□□□■■□□□□□□□■■□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□★★□□□□□■■□□□□□□□■■□□");
			System.out.println("□□■■□□□□■■□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□★★□□□■■□□□□□□□■■□□");
			System.out.println("□□■■□□□□■■□□■■□□□■□□□□□□□□■□□□□□■□□□□□■□□□□□★★□□■■■■■■■■■□□□");
			System.out.println("□□□■■□□■■□□■□□■□□■□■■□□□□■■□□□□■□■□□□■■□□□□□□□★★□□□□□□□□□□□□");
			System.out.println("□□□■■□□■■□□■■■■□□■■□□□□□□□■□□□□■□■□□□□■□□□□□□□□□★★□□□□□□□□□□");
			System.out.println("□□□□■■■■□□□■□□□□□■□□□□■■□□■□□□□■□■□□□□■□□□□□□□□□□□★★□□□□□□□□");
			System.out.println("□□□□□■■□□□□□■■■□□■□□□□■■□■■■□■□□■□□■□■■■□□□□□□□□□□□□★★□□□□□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
			System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");




			System.out.println("┏──────────┓");
			System.out.print("┃1.로그인    2.종료  ┃\n");
			System.out.print("┗──────────┛\n : ");


			try {


				int ch= sc.nextInt();
				switch(ch){

				case 1:
					//로그인확인
					System.out.print("ID를 입력하세요\n :");
					if(ob.setAdminLogin(sc.next())){
						secondInterface();
					}else{
						break;
					}

				case 2:
					System.out.println("┏───────────┓");
					System.out.println("┃  ** 종료합니다  **   ┃");
					System.out.print("┗───────────┛\n  ");

					try {
						t3.start();
						t3.join();
					} catch (Exception e) {
					}
					YGConn.close();
					System.exit(0);


				}


			} catch (Exception e) {
				System.out.println(" 입력오류");
				sc=new Scanner(System.in);
				
			}

		}
	}

	public void secondInterface(){


		while(true){
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■■■■☆■■■☆■■☆■■■■■☆■■■☆■☆■■■■■☆☆☆☆☆☆☆■■■■■☆☆☆☆☆☆☆■■■■■■■■■");
			System.out.println("■■■■■■■☆■■■☆■☆☆■■■■■☆■■■☆■☆■■■■■☆■■■■■☆■■■■■■■■■■■☆■■■■■■■■■");
			System.out.println("■■■■■■■☆☆☆☆☆■■☆■■■■■☆☆☆☆☆■☆■■■■■☆■■■■■☆■■■■■■■■■■■☆■■■■■■■■■");
			System.out.println("■■■■■■■☆■■■☆■☆☆■■■■■☆■■■☆■☆■■■■■☆■■■■■☆■■■■■■■■■■■☆■■■■■■■■■");
			System.out.println("■■■■■■■☆☆☆☆☆■■☆■■■■■☆☆☆☆☆■☆■■■■■☆☆☆☆☆☆☆■■■■■■■■■■■☆■■■■■■■■■");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■☆■■■■■■■■■");
			System.out.println("■■■■■■■■■☆☆☆☆☆☆■■■■■■■■☆■■■■■■■☆☆☆☆☆☆☆☆☆■■■■■■■☆■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■■■■■■☆■■■■■☆☆☆☆☆☆☆■■■■■■■■☆■■■■■■■■■■■☆■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■☆☆☆☆☆☆■■■■■■■■☆■■■■■■■■☆■■☆■■■■■■■■■■■☆■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■☆■■■■■■■■■■■■☆■☆■■■■■■■☆■■■■■■■■■■■■■■☆■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■☆☆☆☆☆☆■■■■■☆☆■■■☆☆■■■■■☆☆☆☆☆☆☆■■■■☆☆☆☆☆☆☆☆☆■■■■■■■■");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println();
			System.out.println("ﾞ､＼ 　 i  iﾟ　   ／.／`:;,,___ノ　　◯　　. 　　　　 　　 ﾟ　　　　　　　 （　　　ノ ");
			System.out.println("　＼`ｰ' 　 i　 ／ ／´ｏ　　 。 ｏ 　　　　　　ｏ　　　. 　　　　　　　   ＿＿_　　ｏ ");
			System.out.println(" 　　 `\\　 ◯\",ノ　 　　 　　　. 　  ........____......ｏ___...._____..  |______|　 　　　　 ○　｡ﾟ");
			System.out.println("　　　 i 　 ｡ ／　　　ｏ　 　 　 ｏ            ,'\"　　 　 ￣　　￣　　￣ｏ 　 　`､     iｴｴｴi　　　　ｏ　　　. ﾟ");
			System.out.println("ｏ　　 | 　 /ﾟ 　,i'⌒ヽ、 　ﾟ　　　   ,', ﾍ、。　◯ 　 o  , へ、ｏ 　　` く `ﾕｭ/　　　　　　　 .  ");
			System.out.println(" ﾞ､＼_ﾉ　　i ｏ（　　） 　 　 　     ,'ﾒ  ﾍ 　 　 ｡　　　      /  oへ、　 　　  `､_メ　　.  ");
			System.out.println("　` 、ﾞ 　 ﾉ　`／;;;_ノ 　 　 　   ,' ﾒ  /::`、 ｏ 　 　  ／／____ ＼　　　 　`､　　　　　◯　　ｏ ");
			System.out.println(" 　　 \\　i, ／／´　　ｏ 　   　,' ﾒ  / 二:`、 　　　  i | |ロ|ロ||　｡　   　  `､　 　 　　 　 　　ｏ ");
			System.out.println(" 　　 i　◯／／　　　｡　　　  ,' ﾒ  /|iﾛiﾛ|`､　 。    　  i_|_|ロ|ロ||　 　　　 　○　　　｡ ");
			System.out.println("　　 / 　  /　。 　 　 　 　 　,'ﾒ  /.|iﾛiﾛ|.`、 　 Ｏ 　 ￣￣￣　ｏ　　　　  `､　　　　　｡　　＊ ");
			System.out.println(" 　./ 　  /　　　　○ ｏ 　　 i_/__/::::ニニ::`､___＿＿＿＿＿＿＿＿＿＿＿＿ ＿`。ｏ ");
			System.out.println(":::/ο　 i　　　　　　iニi   .  ||| \\\"￣￣ﾞ\\ | |ﾟ　ﾟ　ﾟ　ﾟ　ﾟ　°°ﾟ　ﾟ　ﾟ  ﾟ   ﾟ     ﾟ ﾟ|° ");
			System.out.println(" ..i　　　| 　 　Ｏ　（ ･･)     ０|  |o＠::| ｡０ ﾆﾆ二ニ|ミ田田彡|ﾆﾆ二ニニニ |　　　｡　　　○ ");
			System.out.println("ﾉ､.......,iｰ. ＿＿ . （　_.)... |.|  |$::::|　| |二ニニ二ニニニ二ニニニニニニ |`ｰ-､.,_.................................");
			System.out.println("　　　　　,.＿,,,.,.,._.｡--ｰ―'''''^\"´,｡=ｰ'^\"´￣￣￣ｏ￣￣￣￣￣￣￣￣￣￣￣￣ ");
			System.out.println("_,.｡-ｰ'''^　　　　　　　　　,.｡-ｰ'^\"´　　　　　　　 　　 ,i'⌒\"'\"':､　　　ｏ ");
			System.out.println(" 　　　　　　　　　　 　 _,.-'\"　　　　　　　 ..　  .. （ :::ﾟﾟ;;　　　.. 　　　○ ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			System.out.println("┏──────────────────────────────────┓");
			System.out.print("┃1.도서관리\t2.회원관리\t3.정산관리\t4.이전 \t   5.종료"+"     ┃\n");
			System.out.print("┗──────────────────────────────────┛\n : ");
			int ch = sc.nextInt();

			switch(ch){
			case 1:
				bookAdmin(); 
				break;
			case 2:
				userAdmin(); 
				break;
			case 3:
				monney(); 
				break;
			case 4:
				firstInterface(); 
				break;
			case 5:
				System.out.println("┏───────────┓");
				System.out.println("┃  ** 종료합니다  **   ┃");
				System.out.print("┗───────────┛\n  ");
				try {
					t3.start();
					t3.join();
				} catch (Exception e) {
				}
				YGConn.close();
				System.exit(0);
				break;
				
			default:
				System.out.println(" 입력오류");
				
			}
		}

	}


	public void bookAdmin(){

		while(true){

			System.out.println("┏───────────────────────────────────────────────────┓");
			System.out.print("┃1.도서대여       2.도서반납      3.대여목록      4.도서추가      5.도서삭제      6.이전       7.종료  ┃\n");
			System.out.print("┗───────────────────────────────────────────────────┛\n : ");

			int ch = sc.nextInt();

			switch(ch){

			case 1:
				books.bookBorrow();
				break;

			case 2:
				books.bookReturn();
				break;

			case 3:
				books.bookPrint();
				break;
			case 4:
				books.bookInput();
				break;

			case 5:
				books.bookDelete();
				break;
			case 6:	
				secondInterface();
				break;

			case 7:
				System.out.println("┏───────────┓");
				System.out.println("┃  ** 종료합니다  **   ┃");
				System.out.print("┗───────────┛\n  ");
				try {
					t3.start();
					t3.join();
					YGConn.close();
					System.exit(0);
				} catch (Exception e) {
				}
				break;
			default:
				System.out.println(" 입력오류");
			}
		}
	}








	public void userAdmin(){

		while(true){


			System.out.println("┏─────────────────────────────────────────────────┓");
			System.out.print("┃1.회원목록       2.회원등록        3.회원탈퇴        4.회원정보수정        5.이전        6.종료   ┃\n");
			System.out.print("┗─────────────────────────────────────────────────┛\n : ");

			int ch = sc.nextInt();

			switch(ch){
			case 1:
				ob.userPrint();
				break;
			case 2:
				ob.userInput();
				break;
			case 3:
				ob.userDelete();
				break;
			case 4:
				ob.userUpdate();
				break;
			case 5:
				secondInterface();
				break;
			case 6:
				System.out.println("┏───────────┓");
				System.out.println("┃  ** 종료합니다  **   ┃");
				System.out.print("┗───────────┛\n  ");
				try {
					t3.start();
					t3.join();
				} catch (Exception e) {
				}
				System.exit(0);
				break;
				
			default:
				System.out.println(" 입력 오류");
				
			}
		}
	}





	public void monney(){

		while(true){

			System.out.println("┏─────────────┓");
			System.out.print("┃1.총매출  2.이전  3.종료  ┃\n");
			System.out.print("┗─────────────┛\n : ");


			int ch = sc.nextInt();

			switch(ch){
			case 1:

				try {
					Thread printtot = new PrintTot3();
					Thread printtot2 = new PrintTot4();
					printtot.start();
					printtot.join();
					if(books.dao.getMoneyTot()==0)
					System.out.println(" ▦                   "+books.dao.getMoneyTot()+"원 입니다                   ▦");	
					
					else if(books.dao.getMoneyTot()>=1000)
					System.out.println(" ▦                   "+books.dao.getMoneyTot()+"원 입니다                ▦");
					else if(books.dao.getMoneyTot()<=800)
					System.out.println(" ▦                   "+books.dao.getMoneyTot()+"원 입니다                 ▦");
					
					printtot2.start();
					printtot2.join();
					
					
					
				} catch (Exception e) {
				}
				break;
			case 2:
				secondInterface();
				break;

			case 3:
				System.out.println("┏───────────┓");
				System.out.println("┃  ** 종료합니다  **   ┃");
				System.out.print("┗───────────┛\n  ");
				try {
					t3.start();
					t3.join();
				} catch (Exception e) {
				}
				YGConn.close();
				System.exit(0);
				break;
				
			default :
				System.out.println(" 입력 오류");
				
				
			}
		}


	}


}












