package lj.test;

public class Static {
	static{
		int x = 5;
	}
	static int x,y;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		x--;
		myMethod();
		System.out.println(x + y + ++x);
	}
	public static void myMethod(){
		y = x++ + ++x;
	}

}
