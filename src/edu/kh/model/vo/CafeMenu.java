package edu.kh.model.vo;

public class CafeMenu {
	
	private String menuId;
	private String menuName;
	private int menuPrice;
	
	public CafeMenu(String menuId, String menuName, int menuPrice) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	@Override
	public String toString() {
		return "CafeMenu [menuId=" + menuId + ", menuName=" + menuName + ", menuPrice=" + menuPrice + "]";
	}
	
	

}
