package lj.test;

public class B extends A{
	int j = 30;
	static{
		System.out.println("b");
	}
	public B(){
		System.out.println("y");
		print();
		j = 40;
	}
	void print(){
		System.out.println(j);
	}
	public static void main(String args[]){
		A aa = new B();
		aa = new B();
		System.out.println(new B().j);
	}
}
