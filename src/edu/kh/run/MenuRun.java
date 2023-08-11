package edu.kh.run;

import edu.kh.model.service.MenuService;

public class MenuRun {
	
	public static void main(String[] args) {
		
		MenuService service = new MenuService();
		
		service.displayMenu();
	}

}
