package com.project2;

import java.util.Calendar;

public class PrintTot3 extends Thread{

	Calendar now = Calendar.getInstance();

		@Override
		public void run() {
			try {
				
				
				System.out.println();
				System.out.println(" �ˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢˢ�");
				sleep(300);
				System.out.println(" ��                                                ��");
				sleep(300);
				System.out.println(" ��                                                ��");
				sleep(300);
				System.out.println(" ��                    ��������                    ��");
				sleep(300);
				System.out.println(" ��     ______________________________________     ��");
				sleep(300);
				System.out.println(" ��                                                ��");
				sleep(300);
				System.out.println(" ��                                                ��");
				sleep(300);
				System.out.printf(" ��                   %1$tF                   ��\n",now);
				sleep(300);
				System.out.println(" ��                                                ��");
				sleep(300);
				System.out.println(" ��                   �Ѹ������                   ��");
				sleep(300);
				System.out.println(" ��                                                ��");
				sleep(300);
				System.out.println(" ��                                                ��");
				sleep(300);
				System.out.println(" ��                                                ��");

			} catch (Exception e) {
				// TODO: handle exception
			}




		}

	}

