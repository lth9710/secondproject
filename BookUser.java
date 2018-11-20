package com.project2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookUser {

	Scanner sc = new Scanner(System.in);


	public void searchBookUser(){//책번호를 입력해서 해당 책번호의 책정보를 출력하고
									//책정보안의 유저id를 유저클래스와 비교해서 똑같은 유저 정보를 출력

		Book books = new Book();
		User ob = new User();
		String searchid = "";



		List<Integer> bookuserlist = new ArrayList<Integer>();





		bookuserlist.addAll(books.rentalBookList());// 도서번호를받아서 책정보출력한후 도서번호반환

		Iterator<Integer> it = bookuserlist.iterator();

		/*while(it.hasNext()){
			

			searchid=books.getUserId(it.next());//도서번호를통해서 USerid를 가져와서 searchid에 넣음 >> searchid는 책을빌린사람의 id를담음

			ob.rentalUserList(searchid);// id값을 받아서 대여중이아닌지, 대여중이라면 누가빌렸는지 출력(유저정보출력) ob(User클래스)의 대여자정보출력메소드실행 

			if (bookid==0) {

			}else{

				//ob.rentalUserList(searchid);

			}

		}
*/

	}
}