package designPattern.factory.method;

import java.util.Calendar;

import designPattern.factory.simple.JeepCar;

public class MainTest {
	
	public static void main(String[] args) {
		
		JeepCarFactory factory = new JeepCarFactory();
		JeepCar car = (JeepCar) factory.getCar();
		car.showCar();
		
		
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);// 获取24小时
		System.out.println(hour);
		
	}
	

}
