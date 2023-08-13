package edu.kh.run;

import edu.kh.model.service.CafeMenuService;

public class CafeMenuRun {
	
	public static void main(String[] args) {
		
		CafeMenuService service = new CafeMenuService();
		
		service.displayMenu();
		
	}

}
