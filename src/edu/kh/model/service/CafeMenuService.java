package edu.kh.model.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.model.vo.CafeMenu;
import edu.kh.model.vo.CafeMenuOrder;

public class CafeMenuService {
	
	private Scanner sc = new Scanner(System.in);

	private List<CafeMenu> cafeMenuList = new ArrayList<CafeMenu>();
	private List<CafeMenuOrder> cafeMenuOrderList = new ArrayList<CafeMenuOrder>();
	
	public CafeMenuService() {
		cafeMenuList.add( new CafeMenu("A01", "아메리카노", 3000) );
		cafeMenuList.add( new CafeMenu("A02", "카페라떼", 4000) );
		cafeMenuList.add( new CafeMenu("A03", "오렌지주스", 4500) );
	}
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			
			System.out.println("\n========== 카페 메뉴판 프로그램 ==========\n");
			System.out.println("1. 카페 메뉴 추가");
			System.out.println("2. 카페 메뉴 조회");
			System.out.println("3. 카페 메뉴 수정");
			System.out.println("4. 카페 메뉴 삭제");
			System.out.println("5. 카페 메뉴 주문 등록");
			System.out.println("6. 카페 메뉴 주문 조회");			
			System.out.println("7. 카페 메뉴 주문 취소");
			
			System.out.println("0. 프로그램 종료");
			
			try {
				System.out.print("\n메뉴 번호 선택 >> ");
				menuNum = sc.nextInt();
				sc.nextLine();
				
				switch(menuNum) {
				case 1 : System.out.println( addMenu() ); break;
				case 2 : System.out.println( selectMenu() ); break;
				case 3 : System.out.println( updateMenu() ); break;
				case 4 : System.out.println( deleteMenu() ); break;
				case 5 : System.out.println( orderMenu() ); break;
				case 6 : System.out.println( selectOrderMenu() ); break;
				case 7 : System.out.println( deleteOrderMenu() ); break;
				case 0 : System.out.println("프로그램을 종료합니다."); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				}
			} catch(InputMismatchException e) {
				System.out.println("\nerror : 입력형식이 유효하지 않습니다. 메뉴에 작성된 번호만 입력해주세요.");
				
				sc.nextLine();
				
				menuNum = -1;
			}

			
		}while(menuNum != 0);
		
	}
	
	public String addMenu() {
		
		System.out.println("\n========== 카페 메뉴 추가 ==========\n");
		
		System.out.print("메뉴 ID : ");
		String menuId = sc.nextLine();
		
		System.out.print("메뉴 이름 : ");
		String menuName = sc.nextLine();
		
		System.out.print("메뉴 가격 : ");
		int menuPrice = sc.nextInt();
		
		if(cafeMenuList.add( new CafeMenu(menuId, menuName, menuPrice) )) {
			System.out.println(cafeMenuList);
			return "메뉴 추가 성공";
		} else {
			return "메뉴 추가 실패";
		}
	}
	
	public String selectMenu() {
		
		System.out.println("\n========== 카페 메뉴 조회 ==========\n");
		
		if(cafeMenuList.isEmpty()) {
			return "등록된 카페 메뉴 정보가 없습니다.";
		}
		
		for(CafeMenu cm : cafeMenuList) {
			System.out.println(cm);
		}
		
		return "\n성공적으로 조회되었습니다.";
	}
	
	public String updateMenu() {
		
		System.out.println("\n========== 카페 메뉴 수정 ==========\n");
		
		for(CafeMenu cm : cafeMenuList) {
			System.out.println(cm);
		}
		
		System.out.println();
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(cafeMenuList.isEmpty()) {
			return "등록된 카페 메뉴 정보가 없습니다.";
			
		} else if(index < 0) {
			return "음수는 입력할 수 없습니다.";
			
		} else if(index >= cafeMenuList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
			
		} else {
			System.out.println(index + "번째 인덱스에 저장된 카페 메뉴 정보");
			System.out.println(cafeMenuList.get(index));
			
			System.out.print("메뉴 이름 : ");
			String menuName = sc.next();
			
			System.out.print("메뉴 가격 : ");
			int menuPrice = sc.nextInt();
			sc.nextLine();
			
			CafeMenu cm = cafeMenuList.set(index, new CafeMenu(cafeMenuList.get(index).getMenuId(), menuName, menuPrice));
			
			return cm.getMenuName() + "의 정보가 변경되었습니다.";
		}
	}
	
	public String deleteMenu() {
		
		System.out.println("\n========== 카페 메뉴 삭제 ==========\n");
		
		for(CafeMenu cm : cafeMenuList) {
			System.out.println(cm);
		}
		
		System.out.println();
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(cafeMenuList.isEmpty()) {
			return "등록된 카페 메뉴 정보가 없습니다.";
			
		} else if(index < 0) {
			return "음수는 입력할 수 없습니다.";
			
		} else if(index >= cafeMenuList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
			
		} else {
			System.out.print("정말 삭제 하시겠습니까?(Y/N) : ");
			String answer = sc.next();
			
			if(answer.equals("Y")) {
				CafeMenu cm = cafeMenuList.remove(index);
				return cm.getMenuName() + "의 정보가 삭제되었습니다.";
				
			} else {
				return "삭제 취소";
				
			}
			
		}
	}
	
	public String orderMenu() {
		
		System.out.println("\n========== 카페 메뉴 주문 등록 ==========\n");
		
		if(cafeMenuList.size() < 1) {
			return "등록된 카페 메뉴 정보가 없습니다.";
		}
		
		for(CafeMenu cm : cafeMenuList) {
			System.out.println(cm);
		}
		
		System.out.println();
		
		System.out.print("카페 메뉴 ID : ");
		String orderMenuId = sc.next();
		
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		
		if(cafeMenuOrderList.add(new CafeMenuOrder(String.valueOf(cafeMenuOrderList.size() + 1), orderMenuId, dateTime.format(formatter)))) {
			return "주문이 성공했습니다.";
			
		} else {
			return "주문이 실패했습니다.";
			
		}
	}
	
	public String selectOrderMenu() {
		
		System.out.println("\n========== 카페 메뉴 주문 조회 ==========\n");
		
		if(cafeMenuOrderList.isEmpty()) {
			return "등록된 카페 메뉴 주문 정보가 없습니다.";
		}
		
		for(CafeMenuOrder cmo : cafeMenuOrderList) {
			System.out.println(cmo);
		}
		
		return "\n성공적으로 조회되었습니다.";
	}
	
	public String deleteOrderMenu() {
		
		System.out.println("\n========== 카페 메뉴 주문 취소 ==========\n");
		
		for(CafeMenuOrder cmo : cafeMenuOrderList) {
			System.out.println(cmo);
		}
		
		System.out.println();
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(cafeMenuOrderList.isEmpty()) {
			return "등록된 카페 메뉴 주문 정보가 없습니다.";
			
		} else if(index < 0) {
			return "음수는 입력할 수 없습니다.";
			
		} else if(index >= cafeMenuOrderList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
			
		} else {
			System.out.print("정말 주문 삭제 하시겠습니까?(Y/N) : ");
			String answer = sc.next();
			
			if(answer.equals("Y")) {
				CafeMenuOrder cmo = cafeMenuOrderList.remove(index);
				return cmo.getOrderNo() + "번째 주문 정보가 삭제되었습니다.";
				
			} else {
				return "주문 삭제 취소";
				
			}
			
		}
	}

}
