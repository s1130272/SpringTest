package innerClass;

public class Circle {
	
	private Draw draw = null;
	private double radius = 0;
	public static int count = 1;

	public Circle() {

	}

	public Draw getInnerInstance() {
		if (draw == null)
			draw = new Draw();
		return draw;
	}
	
	// 内部类   内部类的修饰符的作用类似于局部变量修饰符左右，另外还能觉得其他类对此内部类的可见性
	private class Draw { 
		public void drawSahpe() {
			System.out.println(radius); // 外部类的private成员
			System.out.println(count); // 外部类的静态成员
		}
	}
}
