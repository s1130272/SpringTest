package designPattern.factory.simple;

public class CarsFactory {
	
	 public ICar GetCar(CarType carType) throws Exception
     {
        switch (carType) {
		case SportCar:
			 return new SportCar();
		case JeepCar:
			 return new JeepCar();
		default:
			throw new Exception("no car");
		}
     }


}
