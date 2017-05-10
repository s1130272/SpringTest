package designPattern.decorator;

public class ChickenHamburger extends Hamburger {

	private String desc = "鸡肉堡";

	private Double price = 2.0;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
