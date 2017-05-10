package designPattern.decorator;

public class Test {
	
	public static void main(String[] args) {
		
		Hamburger burg = new ChickenHamburger();
		Lettuce lettuceBurg = new Lettuce(burg);
		System.out.println(lettuceBurg.getDesc()+"  价格："+lettuceBurg.getPrice());
		
		Chilli chilliLettuceBurg = new Chilli(lettuceBurg);
		System.out.println(chilliLettuceBurg.getDesc()+"  价格："+chilliLettuceBurg.getPrice());
		
	}

}
