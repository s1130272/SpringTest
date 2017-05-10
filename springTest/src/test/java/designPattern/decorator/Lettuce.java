package designPattern.decorator;

public class Lettuce  extends Condiment{
	
	Hamburger humburger;    
	
	public Lettuce(Hamburger humburger){    
        this.humburger = humburger;    
    }
	
	@Override
	public String getDesc() {
		return humburger.getDesc()+" +生菜";
	}
	
	@Override
	public Double getPrice() {
		return humburger.getPrice()+0.5;
	}
	
}
