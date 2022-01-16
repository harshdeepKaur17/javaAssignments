package ques1;

public class Invoice implements Payable {
	private String partNum;
	private int quantity;
	private String partDesc;
	private double pricePerItem;
	
	public Invoice(String partNum,String partDesc,int quantity,double pricePerItem) {
		this.partNum=partNum;
		this.partDesc=partDesc;
		this.quantity=quantity;
		this.pricePerItem=pricePerItem;
	}
	
	public String getPartNum() {
		return partNum;
	}
	
	public String getPartDesc() {
		return partDesc;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPricePerItem() {
		return pricePerItem;
	}
	
	public void setPartNum(String partnum) {
		this.partNum=partnum;
	}
	
	public void setPartDesc(String partDesc) {
		this.partDesc=partDesc;
	}
	
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem=pricePerItem;
	}
	
	public String toString() {
		StringBuilder builder=new StringBuilder();
		
		builder.append("Invoice \n partNum:").append(partNum).append("\n part desc: ").append(partDesc).append("\n quantity: ").append(quantity).append("\n price per item: ").append(pricePerItem);
		return builder.toString();
	}
	
	public double getPayment() {
		return pricePerItem*quantity;
	}
}
