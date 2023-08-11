package edu.kh.model.vo;

public class Menu {
	
	private String kind;
	private String name;
	private int price;
	
	public Menu(String kind, String name, int price) {
		this.kind = kind;
		this.name = name;
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Menu [kind=" + kind + ", name=" + name + ", price=" + price + "]";
	}
	

}
