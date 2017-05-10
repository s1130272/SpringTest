package designPattern.factory.simple;

public class MainTest {
	
	public static void main(String[] args) throws Exception {
		
		CarsFactory carFactory = new CarsFactory();
		ICar car = carFactory.GetCar(CarType.JeepCar);
		car.showCar();
	}
	
}
