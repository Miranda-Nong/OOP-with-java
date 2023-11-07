class A{
int n1, n2;
A(int a, int b){
n1 = a;
n2 = b;
}
void sum(){
int s;
s = n1 + n2;
System.out.println("Sum = " + s);
}}
class F extends A{
F(int a, int b){
super(a, b);
}
void prod(){
int p;
p = n1*n2;
System.out.println("Product = " + p);;
}}
class G extends F{
G(int a, int b){
super(a,b);
}
void div(){
float d;
d = (float)n1/n2;
System.out.println("Division = " + d);
}}
public class multilevel1 {
public static void main(String args[]){
G g1 = new G(8, 5);
g1.sum();
g1.prod();
g1.div();
}}
