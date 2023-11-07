import java.util.Scanner;
public class Quadratic {

	
	public static void main(String[] args) {
		double root1=0,root2=0,determinant,real,imaginary=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the values of a,b,c");
		double a=sc.nextDouble();
		double b=sc.nextDouble();
		double c=sc.nextDouble();
		determinant=b*b-4*a*c;
		
		if(determinant>0)
		{
			root1=(-b+Math.sqrt(determinant))/(2*a);
			root2=(-b-Math.sqrt(determinant))/(2*a);
		}
		else if(determinant==0)
		{
			root1=root2;
		}
		else {
			real=-b/(2*a);
			imaginary=Math.sqrt(determinant)/(2*a);
		}
	
		
		System.out.println("the real solutions are:  "+root1  +root2);
		System.out.println("the imaginary part is "+imaginary);
	}
}
