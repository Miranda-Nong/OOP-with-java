import java.awt.*;
import java.awt.event.*;

public class choose1 {
    private static String selectedShape;
    public static void main(String[] args) {
        Frame f1 = new Frame("Shape Generator");
        Frame f2 = new Frame("Input Shape Coordinates");
        List shapeList = new List(4);
        Button drawButton = new Button("Draw");

        f1.setLayout(null);
        f1.setSize(300, 300);

        shapeList.setBounds(110, 110, 90, 100);
        shapeList.add("Line");
        shapeList.add("Triangle");
        shapeList.add("Rectangle");
        shapeList.add("Oval");
        f1.add(shapeList);

        drawButton.setBounds(100, 220, 80, 30);
        f1.add(drawButton);

        Label l = new Label("Select a shape and press Draw");
        l.setBounds(48, 50, 220, 20);
        f1.add(l);

        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedShape = shapeList.getSelectedItem();
                if (selectedShape != null) {
                    showInputWindow(selectedShape);
                    f1.setVisible(false);
                }
            }
        });

        f1.setVisible(true);

        f2.setLayout(null);
        f2.setSize(300, 300);

        Label l0 = new Label("Enter the coordinates and press Generate");
        l0.setBounds(48, 50, 230, 20);
        f2.add(l0);

        Label l1 = new Label("X:");
        l1.setBounds(20, 90, 80, 20);
        f2.add(l1);
        TextField xTextField = new TextField();
        xTextField.setBounds(110, 90, 100, 20);
        f2.add(xTextField);

        Label l2 = new Label("Y:");
        l2.setBounds(10, 120, 95, 20);
        f2.add(l2);
        TextField yTextField = new TextField();
        yTextField.setBounds(110, 120, 100, 20);
        f2.add(yTextField);

        Button generateButton = new Button("Generate");
        generateButton.setBounds(100, 220, 80, 30);
        f2.add(generateButton);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(xTextField.getText());
                int y = Integer.parseInt(yTextField.getText());

                generateShape(selectedShape, x, y);

                f2.setVisible(false);
                f1.setVisible(true);
            }
        });

        f2.setVisible(false);
    }

    private static void generateShape(String shape, int x, int y) {
        Frame shapeFrame = new Frame("Generated Shape");
        shapeFrame.setLayout(new BorderLayout());

        Canvas canvas = new Canvas() {
            public void paint(Graphics g) {
                super.paint(g);

                if (shape.equals("Line")) {
                    g.drawLine(x, y, x + 50, y + 50);
                } else if (shape.equals("Triangle")) {
                    int[] xPoints = {x, x + 50, x + 25};
                    int[] yPoints = {y + 50, y + 50, y};
                    g.drawPolygon(xPoints, yPoints, 3);
                } else if (shape.equals("Rectangle")) {
                    g.drawRect(x, y, 100, 50);
                } else if (shape.equals("Oval")) {
                    g.drawOval(x, y, 100, 50);
                }
            }
        };

        shapeFrame.add(canvas, BorderLayout.CENTER);

        shapeFrame.setSize(400, 300);
        shapeFrame.setVisible(true);
    }

    private static void showInputWindow(String shape) {
        Frame inputFrame = new Frame("Input Shape Coordinates");
        inputFrame.setLayout(null);
        inputFrame.setSize(300, 300);

        Label l1 = new Label("X:");
        l1.setBounds(20, 90, 80, 20);
        inputFrame.add(l1);
        TextField xTextField = new TextField();
        xTextField.setBounds(110, 90, 100, 20);
        inputFrame.add(xTextField);

        Label l2 = new Label("Y:");
        l2.setBounds(10, 120, 95, 20);
        inputFrame.add(l2);
        TextField yTextField = new TextField();
        yTextField.setBounds(110, 120, 100, 20);
        inputFrame.add(yTextField);

        Button generateButton = new Button("Generate");
        generateButton.setBounds(100, 220, 80, 30);
        inputFrame.add(generateButton);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(xTextField.getText());
                int y = Integer.parseInt(yTextField.getText());

                generateShape(shape, x, y);

                inputFrame.setVisible(false);
            }
        });

        inputFrame.setVisible(true);
    }
}

