public class multilevel {
	int x,y;
	public multilevel(int a,int b) {
		x=a;
		y=b;
	}
	void sum() {
		int s;
		s=x+y;
		System.out.println("sum= "+s);
	}
}
	class B extends multilevel{
		int z;
		B(int a,int b,int c){
			super(a,b);
			z=c;
		}
		void prod() {
			int p;
			p=x*y*z;
			System.out.println("product= "+p);
		}
	}
	class C extends B{
		int w;
		C(int a,int b,int c,int d){
			super(a,b,c);
			w=d;
		}
		void solution() {
			int s;
			s=x*y*z*w;
			System.out.println("solutin= "+s);
		}
	}
	class D{
	public void main(String[] args) {
		C C1=new C(2,3,5,1);
		C1.sum();
		C1.prod();
		C1.solution();
	}
    }
