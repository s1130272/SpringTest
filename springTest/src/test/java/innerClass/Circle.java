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
	
	// �ڲ���   �ڲ�������η������������ھֲ��������η����ң����⻹�ܾ���������Դ��ڲ���Ŀɼ���
	private class Draw { 
		public void drawSahpe() {
			System.out.println(radius); // �ⲿ���private��Ա
			System.out.println(count); // �ⲿ��ľ�̬��Ա
		}
	}
}
