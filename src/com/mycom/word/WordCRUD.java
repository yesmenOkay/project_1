package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
	Scanner s;
	ArrayList<Word> list;

	/*
	 * => ���̵�(1,2,3) & �� �ܾ� �Է� :1 driveway �� �Է� : ���� ���Է� �� �ܾ �ܾ��忡 �߰��Ǿ����ϴ�.
	 */
	WordCRUD(Scanner s) {
		list = new ArrayList<>();
		this.s = s;
	}

	@Override
	public Object add() {
		// TODO Auto-generated method stub
		System.out.println("=> ���̵�(1,2,3) & �� �ܾ� �Է� : ");
		int level = s.nextInt();
		String word = s.nextLine();

		System.out.println("�� �Է� : ");
		String meaning = s.nextLine();

		return new Word(0, level, word, meaning);
	}

	public void addWord() {
		Word one = (Word) add();
		list.add(one);
		System.out.println("�� �ܾ �ܾ����� �߰��Ǿ����ϴ�.");
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectOne(int id) {
		// TODO Auto-generated method stub

	}

	/*
	 * => ���ϴ� �޴���? 1 ----------------------------
	 */
	public void listAll() {
		System.out.println("----------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.print((i + 1) + " ");
			System.out.println(list.get(i).toString());
		}
		System.out.println("----------------------------");
	}
}
