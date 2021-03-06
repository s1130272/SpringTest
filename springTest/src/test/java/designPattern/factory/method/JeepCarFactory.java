package designPattern.factory.method;

import designPattern.factory.simple.ICar;
import designPattern.factory.simple.JeepCar;

public class JeepCarFactory implements ICarFactory{
	
	@Override
	public ICar getCar() {
		return new JeepCar();
	}

}
