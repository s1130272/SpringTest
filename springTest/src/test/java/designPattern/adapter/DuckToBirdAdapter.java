package designPattern.adapter;

public class DuckToBirdAdapter implements Bird{
	
	Duck duck;
	
	public DuckToBirdAdapter(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void says() {
		duck.says();
		
	}

	@Override
	public void fly() {
		System.out.println("****** I am pretenting I can fly...****** ");
		
	}

	@Override
	public void show() {
		says();
		fly();
		
	}

}
