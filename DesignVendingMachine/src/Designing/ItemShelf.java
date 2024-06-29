package Designing;

public class ItemShelf {
	
	Item item;
	int code;
	boolean soldOut;  // we need to add item and updating item. we will only add if item is sold and can only get if it is available(not sold)
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isSoldOut() {
		return soldOut;
	}
	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}

}
