package first;
import java.awt.*;
public class Message {

	public static void main(String[] args) {
	Frame f=new Frame("message");
	Component text= new TextArea("hello");
	f.add(text,BorderLayout.NORTH);
	f.setSize(400,200);
	f.setVisible(true);// TODO Auto-generated method stub

	}

}
