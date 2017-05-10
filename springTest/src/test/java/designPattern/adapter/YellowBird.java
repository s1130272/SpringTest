package designPattern.adapter;

public class YellowBird implements Bird{

	@Override
	public void says() {
		System.out.println("****** I am a Yellow Bird*******");
		
	}

	@Override
	public void fly() {
		System.out.println("****** I am flying.....*******");
		
	}

	@Override
	public void show() {
		says();
		 fly();
		
	}

}
