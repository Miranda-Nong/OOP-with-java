package first;
import java.awt.*;
import java.awt.event.*;

public class SumGUI {
    public static void main(String args[]){
        Frame f = new Frame("Addition");
        TextField t1 = new TextField();
        t1.setBounds(100, 50, 85, 20);
        TextField t2 = new TextField();
        t2.setBounds(100, 100, 85,20);
        Button b = new Button("Add");
        b.setBounds(110, 220, 60,40);
        Label l = new Label("");
        l.setBounds(100, 120, 85, 20);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                int c = a+b;
                l.setText("Sum is "+String.valueOf(c));
            }
        });
        f.add(t1);
        f.add(t2);
        f.add(b);
        f.add(l);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }//main
}//class SumGUI

