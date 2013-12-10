package lj.test;

public class A {
	int i = 10;
	static{
		System.out.println("a");
	}
	public A(){
		System.out.println("x");
		print();
		i=20;
	}
	void print(){
		System.out.println(i);
	}
}
