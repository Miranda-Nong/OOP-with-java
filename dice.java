import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class dice extends Panel{
    int die2;
    int die1;
    public dice(){
        setPreferredSize(new Dimension(100, 100));
        roll();
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                roll();
                repaint();
            }
        });
    }
    void roll(){
        Random choose=new Random();
        die1=choose.nextInt(6) + 1;
        die2=choose.nextInt(6) + 1;
    }
    public void paint(Graphics g){
        super.paint(g);
        die(g,60,40,die1);
        die(g,120,90,die2);
    }
    void die(Graphics g,int x,int y,int val){
        g.setColor(Color.GREEN);
        g.fillRect(x,y,40,40);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,40,40);
        switch(val){
            case 1:
                dot(g,x+20,y+20);
                break;
            case 2:
                dot(g,x+10,y+10);
                dot(g,x+30,y+30);
                break;
            case 3:
                dot(g,x+10,y+10);
                dot(g,x+20,y+20);
                dot(g,x+30,y+30);
                break;
            case 4:
                dot(g,x+10,y+10);
                dot(g,x+10,y+30);
                dot(g,x+30,y+10);
                dot(g,x+30,y+30);
                break;
            case 5:
                dot(g,x+10,y+10);
                dot(g,x+10,y+30);
                dot(g,x+20,y+20);
                dot(g,x+30,y+10);
                dot(g,x+30,y+30);
                break;
            case 6:
                dot(g,x+10,y+10);
                dot(g,x+10,y+20);
                dot(g,x+10,y+30);
                dot(g,x+30,y+10);
                dot(g,x+30,y+20);
                dot(g,x+30,y+30);
                break;
        }
    }
    void dot(Graphics g,int x,int y){
        int dotSize=10;
        int dotOffset=dotSize/2;
        g.fillOval(x-dotOffset,y-dotOffset,dotSize,dotSize);
    }
    public static void main(String[] args){
        Frame frame =new Frame("Dice Panel");
        dice dicePanel=new dice();
        frame.add(dicePanel);
        frame.setBackground(Color.yellow);
        frame.setSize(240,240);
        frame.setVisible(true);
    }
}