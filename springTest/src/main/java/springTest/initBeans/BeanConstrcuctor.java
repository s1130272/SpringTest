package springTest.initBeans;

public class BeanConstrcuctor {

	private int num = 10;

	public BeanConstrcuctor() {
		// TODO Auto-generated constructor stub
	}

	public BeanConstrcuctor(int num) {
		this.num = num;
	}
	
	public void show(){
		System.out.println("The num is "+num);
	}
	
	public int getNum(){
		return num;
	}

}
