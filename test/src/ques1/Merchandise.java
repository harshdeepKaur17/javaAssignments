package ques1;

public class Merchandise {
	private String iteamCode;
	private Integer quantity;
	private Double unitPrice;
	public Merchandise(String iteamCode, Integer quantity, Double unitPrice) {
		super();
		this.iteamCode = iteamCode;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public String getIteamCode() {
		return iteamCode;
	}
	public void setIteamCode(String iteamCode) {
		this.iteamCode = iteamCode;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void print() {
		System.out.println("iteamCode=" + iteamCode + " | quantity=" + quantity + " | unitPrice=" + unitPrice );
	}
	
	
}
