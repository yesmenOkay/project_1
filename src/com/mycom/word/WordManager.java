package com.mycom.word;

import java.util.Scanner;

public class WordManager {
	Scanner s = new Scanner(System.in);
	WordCRUD wordCRUD;

	/*
	 *** ���ܾ� ������ ***
	 ********************
	 * 1. ��� �ܾ� ���� 2. ���غ� �ܾ� ���� 3. �ܾ� �˻� 4. �ܾ� �߰� 5. �ܾ� ���� 6. �ܾ� ���� 7. ���� ���� 0. ������
	 ********************
	 * => ���ϴ� �޴���? 4
	 */
	WordManager() {
		wordCRUD = new WordCRUD(s);
	}

	public int selectMenu() {
		System.out.println("*** ���ܾ� ������ ***\r\n" + "********************\r\n" + "1. ��� �ܾ� ����\r\n" + "2. ���غ� �ܾ� ����\r\n"
				+ "3. �ܾ� �˻�\r\n" + "4. �ܾ� �߰�\r\n" + "5. �ܾ� ����\r\n" + "6. �ܾ� ����\r\n" + "7. ���� ����\r\n" + "0. ������\r\n"
				+ "********************\r\n" + "=> ���ϴ� �޴���? ");

		return s.nextInt();
	}

	public void start() {
		
		wordCRUD.loadFile();
		while (true) {
			int menu = selectMenu();
			if (menu == 0) {//0.������
				System.out.println("���α׷�����!!������ ������~");
				break;
			}
			if (menu == 4) {//4.�ܾ��߰�
				wordCRUD.addItem();
			} 
			else if (menu == 1) {//1.���ܾ��
				wordCRUD.listAll();
			}
			else if (menu == 2) {//2.���غ��ܾ�
				wordCRUD.searchLevel();
			}
			else if (menu == 3) {//3.�ܾ� �˻�
				wordCRUD.searchWord();
			}
			else if (menu == 5) {// update
				wordCRUD.updateItem();
			}
			else if (menu == 6) {// delete
				wordCRUD.deleteItem();
			}
			else if (menu == 7) {// save data
				wordCRUD.saveFile();
			}
		}
	}
}
