package edu.kh.model.vo;

public class CafeMenuOrder {

	private String orderNo;
	private String orderMenuId;
	private String orderTime;
	
	public CafeMenuOrder(String orderNo, String orderMenuId, String orderTime) {
		this.orderNo = orderNo;
		this.orderMenuId = orderMenuId;
		this.orderTime = orderTime;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderMenuId() {
		return orderMenuId;
	}

	public void setOrderMenuId(String orderMenuId) {
		this.orderMenuId = orderMenuId;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "CafeMenuOrder [orderNo=" + orderNo + ", orderMenuId=" + orderMenuId + ", orderTime=" + orderTime + "]";
	}
	
	
}
