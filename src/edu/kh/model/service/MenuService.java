package edu.kh.model.service;

import java.util.Scanner;

import edu.kh.model.vo.Menu;

public class MenuService {
	
	private Scanner sc = new Scanner(System.in);
	
	private Menu[] menuArr = new Menu[5];
	
	private Menu menu = null;
	
	public MenuService() {
		menuArr[0] = new Menu("COFFEE", "아메리카노", 5000);
		menuArr[1] = new Menu("LATTE", "녹차 라떼", 6500);
		menuArr[2] = new Menu("JUICE", "오렌지 주스", 7000);
	}
	
	public void displayMenu(){
			
		int menuNum = 0;
		
		do {
			
			System.out.println("========== 카페 메뉴판 ==========");
			
			System.out.println("1. 카페 메뉴 조회하기");
			System.out.println("2. 카페 메뉴 추가하기");
			System.out.println("3. 카페 메뉴 수정하기");
			System.out.println("4. 카페 메뉴 삭제하기");
			System.out.println("0. 프로그램 종료하기");
			
			System.out.print("원하시는 번호를 입력해주세요. >> ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1 : System.out.println( selectMenu() ); break;
			case 2 : System.out.println( addMenu() ); break;
			case 3 : System.out.println(); break;
			case 4 : System.out.println(); break;
			case 0 : System.out.println("프로그램을 종료합니다."); break;
			default : System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
			}
			
		} while(menuNum != 0);
	}
	
	public String selectMenu() {
		
		System.out.println("1. 카페 메뉴 조회하기");
		
		if(menuArr == null) {
				return "현재 등록된 카페 메뉴가 없습니다.";
		}
		
		String str = "종류 : " + menu.getKind();
		str += "이름 : " + menu.getName();
		str += "가격 : " + menu.getPrice();
		
		return str;
	}
	
	public String addMenu() {
		
		System.out.println("2. 카페 메뉴 추가하기");
		
		System.out.print("종류 입력 : ");
		String kind = sc.nextLine();
		
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		
		System.out.print("가격 입력 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		String str = null;
		
		if(menu.getName().equals(name)) {
			str = name + " 메뉴가 현재 메뉴판에 있습니다.";
		} else {
			str = "";
		}
		
		str = "";
	}

}
