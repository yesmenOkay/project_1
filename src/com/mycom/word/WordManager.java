package com.mycom.word;

import java.util.Scanner;

public class WordManager {
	Scanner s = new Scanner(System.in);
	WordCRUD wordCRUD;
	/*
	 *** 영단어 마스터 ***
	 ********************
	 1. 모든 단어 보기
	 2. 수준별 단어 보기
	 3. 단어 검색
	 4. 단어 추가
	 5. 단어 수정
	 6. 단어 삭제
	 7. 파일 저장
	 0. 나가기
	 ********************
	 => 원하는 메뉴는? 4
	 */
	WordManager(){
		wordCRUD = new WordCRUD(s);
	}

	public int selectMenu() {
		System.out.println("*** 영단어 마스터 ***\r\n"
				+ "********************\r\n"
				+ "1. 모든 단어 보기\r\n"
				+ "2. 수준별 단어 보기\r\n"
				+ "3. 단어 검색\r\n"
				+ "4. 단어 추가\r\n"
				+ "5. 단어 수정\r\n"
				+ "6. 단어 삭제\r\n"
				+ "7. 파일 저장\r\n"
				+ "0. 나가기\r\n"
				+ "********************\r\n"
				+ "=> 원하는 메뉴는? ");
		
		return s.nextInt();
	}

	public void start() {
		while(true) {
			int menu = selectMenu();
			if(menu == 0) break;
			if(menu == 4) {
				wordCRUD.addWord();
			}
			else if(menu == 1) {
				wordCRUD.listAll();
			}
		}
	}
}
