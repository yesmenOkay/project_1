package com.mycom.word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
	Scanner s;
	ArrayList<Word> list;
	final String fname = "Dictionary.txt";

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

	public void addItem() {
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
	public ArrayList<Integer> listAll(String keyword) {
		int j=0;
		ArrayList<Integer> idlist = new ArrayList();
		System.out.println("----------------------------");
		for (int i = 0; i < list.size(); i++) {
			String word = list.get(i).getWord();
			if(!word.contains(keyword)) continue;
			System.out.print((j + 1) + " ");
			System.out.println(list.get(i).toString());
			idlist.add(i);
			j++;
		}
		System.out.println("----------------------------");
		return idlist;
	}
	public void listAll(int level) {
		int j=0;
		System.out.println("----------------------------");
		for (int i = 0; i < list.size(); i++) {
			int ilevel = list.get(i).getLevel();
			if(ilevel != level) continue;
			System.out.print((j + 1) + " ");
			System.out.println(list.get(i).toString());
			j++;
		}
		System.out.println("----------------------------");
		
	};

	public void updateItem() {
		// TODO Auto-generated method stub
		System.out.println("=> ������ �ܾ� �˻� : ");
		String keyword = s.next();
		ArrayList<Integer> idlist = this.listAll(keyword);
		System.out.println("=> ������ ��ȣ ���� : ");
		int id = s.nextInt();
		s.nextLine();
		System.out.println("=> �� �Է� : ");
		String meaning = s.nextLine();
		Word word = list.get(id-1);
		word.setMeaning(meaning);
		System.out.println("�ܾ �����Ǿ����ϴ�.");
	}

	public void deleteItem() {
		// TODO Auto-generated method stub
		System.out.println("=> ������ �ܾ� �˻� : ");
		String keyword = s.next();
		ArrayList<Integer> idlist = this.listAll(keyword);
		System.out.println("=> ������ ��ȣ ���� : ");
		int id = s.nextInt();
		s.nextLine();
		
		System.out.println("=> ������ �����ϽǷ���?(Y/n) ");
		String ans = s.nextLine();
		if(ans.equalsIgnoreCase("y")) {
			list.remove((int)idlist.get(id-1)); 
			System.out.println("�ܾ �����Ǿ����ϴ�.");
		}
		else {
			System.out.println("��ҵǾ����ϴ�.");
		}
		
		
	}
	public void loadFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			String line;
			int count = 0;
			while(true) {
				line = br.readLine();
				if(line == null)break;
				String data[] = line.split("\\|");
				int level = Integer.parseInt(data[0]);
				String word = data[1];
				String meaning = data[2];
				list.add(new Word(0,level,word, meaning)); 
				count++;
			}
			br.close();
			System.out.println("==>" + count + "�� ������ �ε� �Ϸ�!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveFile() {
		// TODO Auto-generated method stub
		try {
			PrintWriter pr = new PrintWriter(new FileWriter(fname));
			for(Word one : list) {
				pr.write(one.toFileString() + "\n");
			}
			pr.close();
			System.out.println("==> ������ ���� �Ϸ�!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchLevel() {
		// TODO Auto-generated method stub
		System.out.println("=> ���ϴ� ������? (1~3)");
		int level = s.nextInt();
		listAll(level);
		
	}

	public void searchWord() {
		// TODO Auto-generated method stub
		System.out.println("=> ���ϴ� �ܾ��? ");
		String keyword = s.next();
		listAll(keyword);
	}
}
