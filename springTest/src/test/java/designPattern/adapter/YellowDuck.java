package designPattern.adapter;

public class YellowDuck implements Duck{

	@Override
	public void says() {
		System.out.println("****** I am a Yellow Duck*******");
		
	}

	@Override
	public void run() {
		System.out.println("****** I am running.....*******");
		
	}

	@Override
	public void show() {
		says();
		run();
		
	}

}
