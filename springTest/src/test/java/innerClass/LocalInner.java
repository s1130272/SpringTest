package innerClass;

public class LocalInner {

	public static void main(String[] args) {

		Person person = new Person();
		System.out.println(person.getWoman().getStr());
	}
}

class Person {
	
	private String str;
	
	public Person() {

	}
	public String getStr() {
		return str;
	}

	public Person getWoman() {
		// 局部内部类
		class Woman extends Person {
			public Woman() {
				str = "women";
			}
		}
		return new Woman();
	}

}
