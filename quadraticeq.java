import java.util.Scanner;
class EquationCheck{
	double a,b,c,x1,x2;
	void check(double a,double b,double c) {
		this.a=a;this.b=b;this.c=c;
		double z=Math.pow(b*b-4*a*c,0.5);
		x1=(-b-z)/(2*a);
		x2=(-b+z)/(2*a);
	}
	void display() {
		System.out.println(x1);
		System.out.println(x2);
	}
}

public class quadraticeq {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
			System.out.println("Enter the coefficients a,b & c in ax^2+bx+c=0:");
	      double a=sc.nextInt();
	      if(a==0)
	      {
	    	  System.out.println("a cant be zero");
	    	  
	      }
	      else {double b=sc.nextInt();
	      double c=sc.nextInt();
	      double z=b*b-4*a*c;
	      EquationCheck ob=new EquationCheck();
	      if(z<0) {
	    	  System.out.println("There are no real solution");
	    	  
	      }else if(z==0) {
	    	  System.out.println("The solutions are real and equal");
	    	  ob.check(a,b,c);
	    	  ob.display();
	    	  
	      }else {
	    	  System.out.println("the soulutions are real and distinct");
	    	  ob.check(a,b,c);
	    	  ob.display();
	      }
	    	  
	      }
}
}

