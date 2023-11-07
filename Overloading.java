
public class Overloading{

	public void add(int a,int b) {
		int c=a+b;
		System.out.println("result1="+c);// TODO Auto-generated constructor stub
	}
	public Overloading(int a,int b,int c) {
		int p=a*b*c;
		System.out.println("result2="+p);
	}
	public void add(double a,double b) {
		double s=a+b;
		System.out.println("result3="+s);
	}
	public Overloading(int i){
		System.out.println("hello");
	}
	
	public static void main(String[] args) {
	Overloading O=new Overloading(2,3,5);
	O.add(2,3);;
	O.add(2.3,3.2);
	
	}	// TODO Auto-generated method stub}

}
