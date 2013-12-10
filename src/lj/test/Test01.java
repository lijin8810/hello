package lj.test;

public class Test01  {
	private static int a ;
	public int b;
	static String s;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 5;
		do{
			System.out.print(i);
		}while(--i>5);
		System.out.print("finished");
		a =2;
		int c = new Test01().b;
		System.out.println(c);
		System.out.println(4>>1);
		System.out.println(5>>1);
		System.out.println(-5>>1);
		System.out.println((-5)/2);
		System.out.println(5>>>1);
		int sizeof;
		System.out.println("s=" + s);
		
		int j;
		outer:for(i=1;i<3;i++){
			inner:for(j=1;j<3;j++){
				if(j==2)continue outer;
				System.out.println(i + "," + j);
			}
		}
	}


}
