package com.project2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookUser {

	Scanner sc = new Scanner(System.in);


	public void searchBookUser(){//å��ȣ�� �Է��ؼ� �ش� å��ȣ�� å������ ����ϰ�
									//å�������� ����id�� ����Ŭ������ ���ؼ� �Ȱ��� ���� ������ ���

		Book books = new Book();
		User ob = new User();
		String searchid = "";



		List<Integer> bookuserlist = new ArrayList<Integer>();





		bookuserlist.addAll(books.rentalBookList());// ������ȣ���޾Ƽ� å����������� ������ȣ��ȯ

		Iterator<Integer> it = bookuserlist.iterator();

		/*while(it.hasNext()){
			

			searchid=books.getUserId(it.next());//������ȣ�����ؼ� USerid�� �����ͼ� searchid�� ���� >> searchid�� å����������� id������

			ob.rentalUserList(searchid);// id���� �޾Ƽ� �뿩���̾ƴ���, �뿩���̶�� �������ȴ��� ���(�����������) ob(UserŬ����)�� �뿩��������¸޼ҵ���� 

			if (bookid==0) {

			}else{

				//ob.rentalUserList(searchid);

			}

		}
*/

	}
}