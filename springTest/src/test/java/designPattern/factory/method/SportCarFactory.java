package designPattern.factory.method;

import designPattern.factory.simple.ICar;
import designPattern.factory.simple.SportCar;

public class SportCarFactory implements ICarFactory{
	
	@Override
	public ICar getCar() {
		return new SportCar();
	}

}
