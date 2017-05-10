package springTry.beans;

public class FactoryInitBean {
	
	
	private String str;
	
	private FactoryInitBean() {
		this.str="helloworld";
	}
	
	public static class FactoryInitBeanInnerClass{
		public static FactoryInitBean instance = new FactoryInitBean();
	}
	
	public static FactoryInitBean getInstance(){
		return FactoryInitBeanInnerClass.instance;
	}

	public String getStr() {
		return str;
	}

}
