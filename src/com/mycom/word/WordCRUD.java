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
	 * => 난이도(1,2,3) & 새 단어 입력 :1 driveway 뜻 입력 : 차고 진입로 새 단어가 단어장에 추가되었습니다.
	 */
	WordCRUD(Scanner s) {
		list = new ArrayList<>();
		this.s = s;
	}

	@Override
	public Object add() {//단어 추가
		// TODO Auto-generated method stub
		System.out.println("=> 난이도(1,2,3) & 새 단어 입력 : ");
		int level = s.nextInt();
		String word = s.nextLine();

		System.out.println("뜻 입력 : ");
		String meaning = s.nextLine();

		return new Word(0, level, word, meaning);
	}

	public void addItem() {//단어 추가2
		Word one = (Word) add();
		list.add(one);
		System.out.println("새 단어에 단어장이 추가되었습니다.");
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
	 * => 원하는 메뉴는? 1 ----------------------------
	 */
	public void listAll() {//전체 리스트 출력
		System.out.println("----------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.print((i + 1) + " ");
			System.out.println(list.get(i).toString());
		}
		System.out.println("----------------------------");
	}
	public ArrayList<Integer> listAll(String keyword) {//keyword 단어 출력
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
	public void listAll(int level) {//레벨 리스트 출력
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

	public void updateItem() {//단어 수정
		// TODO Auto-generated method stub
		System.out.println("=> 수정할 단어 검색 : ");
		String keyword = s.next();
		ArrayList<Integer> idlist = this.listAll(keyword);
		System.out.println("=> 수정할 번호 선택 : ");
		int id = s.nextInt();
		s.nextLine();
		System.out.println("=> 뜻 입력 : ");
		String meaning = s.nextLine();
		Word word = list.get(idlist.get(id-1));
		word.setMeaning(meaning);
		System.out.println("단어가 수정되었습니다.");
	}

	public void deleteItem() {//데이터 삭제
		// TODO Auto-generated method stub
		System.out.println("=> 삭제할 단어 검색 : ");
		String keyword = s.next();
		ArrayList<Integer> idlist = this.listAll(keyword);
		System.out.println("=> 삭제할 번호 선택 : ");
		int id = s.nextInt();
		s.nextLine();
		
		System.out.println("=> 정말로 삭제하실래요?(Y/n) ");
		String ans = s.nextLine();
		if(ans.equalsIgnoreCase("y")) {
			list.remove((int)idlist.get(id-1)); 
			System.out.println("단어가 삭제되었습니다.");
		}
		else {
			System.out.println("취소되었습니다.");
		}
		
		
	}
	public void loadFile() {//파일 로딩
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
			System.out.println("==>" + count + "개 데이터 로딩 완료!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveFile() {//파일 저장
		// TODO Auto-generated method stub
		try {
			PrintWriter pr = new PrintWriter(new FileWriter(fname));
			for(Word one : list) {
				pr.write(one.toFileString() + "\n");
			}
			pr.close();
			System.out.println("==> 데이터 저장 완료!!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchLevel() {//레벨 검색
		// TODO Auto-generated method stub
		System.out.println("=> 원하는 레벨은? (1~3)");
		int level = s.nextInt();
		listAll(level);
		
	}

	public void searchWord() {//단어검색
		// TODO Auto-generated method stub
		System.out.println("=> 원하는 단어는? ");
		String keyword = s.next();
		listAll(keyword);
	}
}
