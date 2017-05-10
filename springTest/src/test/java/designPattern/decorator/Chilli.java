package designPattern.decorator;

public class Chilli  extends Condiment{
	
	Hamburger humburger;    
	
	public Chilli(Hamburger humburger){    
        this.humburger = humburger;    
    }
	
	@Override
	public String getDesc() {
		return humburger.getDesc()+" +辣椒";
	}
	
	@Override
	public Double getPrice() {
		return humburger.getPrice()+0.5;
	}
	
}
