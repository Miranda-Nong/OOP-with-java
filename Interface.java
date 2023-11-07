interface A
{
    public abstract void execute1();
}
interface B
{
    public abstract void execute2();
}
class C implements A,B
{
    public void execute1()
    {
        System.out.println("Hello I am from interface A");
    }
    public void execute2()
    {
        System.out.println("Hello I am from interface B");
    }
}
public class Interface
{
    public static void main(String[] args)
    {
        System.out.println("MULTIPLE INHERITANCE USING INTERFACE");
        C obj = new C();
        obj.execute1();
        obj.execute2();
    }
}
