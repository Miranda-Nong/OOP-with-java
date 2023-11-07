import java.util.*;
class A {
float x, y;
A(float a, float b)
{
x = a;
y = b;
}
void area_rect()
{
float s = x*y;
System.out.println("Area of rectangle: " + s);
}
}
class B extends A{
float z;
B(float a, float b, float c)
{
super(a, b);
z = c;
}
void vol_cuboid()
{
float p = x*y*z;
System.out.println("Volume of cuboid: " + p);
}
}
public class SingleInheritance {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
System.out.println("Enter the height width and breadth of cuboid: ");
float x = s.nextFloat();
float y = s.nextFloat();
float z = s.nextFloat();
B b1 = new B(x, y, z);
b1.area_rect();
b1.vol_cuboid();
s.close();
}
}