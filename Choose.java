import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Choose{
    public static void main(String[] args) {

        Frame f1 =new Frame("operations List");
        Frame f2 =new Frame("Operation");
        Choice c = new Choice();
        c.setBounds(110,110, 90, 100);
        c.addItem("Addition");
        c.addItem("Subtraction");
        c.addItem("Multiplication");
        c.addItem("Division");
        Label l= new Label("select an Operation");
        l.setBounds(48, 50, 220, 20);
        Label l0= new Label("Enter the numbers & Compute ");
        l0.setBounds(48, 50, 230, 20);
        Label l1 = new Label("First Number: ");
        l1.setBounds(20, 90, 80, 20);
        TextField t1 = new TextField();
        t1.setBounds(110, 90, 100, 20);
        Label l2 = new Label("Second Number: ");
        l2.setBounds(10, 120, 95, 20);
        TextField t2 = new TextField();
        t2.setBounds(110,120, 100, 20);
        Button b2 = new Button("Compute");
        b2.setBounds(100, 220, 60, 30);
        Button b1=new Button("select");
        b1.setBounds(50, 220, 200, 30);
        Label l3 =new Label("Result: ");
        l3.setBounds(20, 150, 70, 20);
        l3.setVisible(true);
        TextField t3 = new TextField(null, 0);
        t3.setBounds(110, 150, 100, 20);
        t3.setFocusable(true);
        t3.setVisible(true);
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);
                f2.setVisible(true);

            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(t1.getText());
                double b = Double.parseDouble(t2.getText());
                double result =0;
                switch (c.getItem(c.getSelectedIndex()))
                {
                    case "Addition":
                        l3.setVisible(true);
                        t3.setVisible(true);
                        t3.setText(String.valueOf(a+b));
                        break;

                    case "Subtraction":
                        l3.setVisible(true);
                        t3.setVisible(true);
                        t3.setText(String.valueOf(a-b));
                        break;

                    case "Multiplication":
                        l3.setVisible(true);
                        t3.setVisible(true);
                        t3.setText(String.valueOf(a*b));
                        break;

                    case "Division":
                        l3.setVisible(true);
                        t3.setVisible(true);
                        t3.setText(String.valueOf(a/b));
                        break;


                }  }  });


        f1.add(l);
        f1.add(c);
        f1.add(b1);
        f1.setSize(300,300);
        f1.setLayout(null);
        f1.setVisible(true);
        f2.add(l0);
        f2.add(l1);
        f2.add(l2);
        f2.add(l3);
        f2.add(t1);
        f2.add(t2);
        f2.add(t3);
        f2.add(b2);
        f2.setSize(300, 300);
        f2.setLayout(null);
    }
}
