class c1{
	int num=10;
}
 class subclass1 extends c1{
		int num1=1;
	}
 class subclass2 extends c1{
		int num2=2;
		
	}
 class subclass3 extends c1{
	 int num3=3;
 }
  public class Heirarchical{
	 public static void main(String[] args) {
	 subclass1 ob1=new subclass1();
	 subclass2 ob2=new subclass2();
	 subclass3 ob3=new subclass3();
	 System.out.println("Heirarchical Inheritance");
	 System.out.println("product is "+ob1.num*ob1.num1);
	 System.out.println("product is "+ob2.num*ob2.num2);
	 System.out.println("product is "+ob3.num*ob3.num3);
	 }
 }
