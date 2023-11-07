import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class colors extends Frame implements ActionListener{
    BufferedImage image1;
    BufferedImage image2;
    ImagePanel View;
    Button loadButton;
    Button grayscaleButton;
    Button contrastButton;
    Button brightnessButton;
    Button sharpnessButton;
    Button resetButton;
    Label contrastLabel;
    Label brightnessLabel;
    Label sharpnessLabel;
    Scrollbar contrastSB;
    Scrollbar brightnessSB;
    Scrollbar sharpnessSB;
    public colors(){
        setTitle("Image Enhancer");
        setSize(900,600);
        setBackground(Color.YELLOW);
        setLayout(new BorderLayout());
        View=new ImagePanel();
        add(View,BorderLayout.CENTER);
        Panel buttonPanel=new Panel(new FlowLayout());
        loadButton=new Button("Load Image");
        loadButton.setBackground(Color.GREEN);
        loadButton.addActionListener(this);
        buttonPanel.add(loadButton);
        grayscaleButton=new Button("Grayscale");
        grayscaleButton.setBackground(Color.BLUE);
        grayscaleButton.addActionListener(this);
        buttonPanel.add(grayscaleButton);
        contrastButton=new Button("Enhance Contrast");
        contrastButton.setBackground(Color.RED);
        contrastButton.addActionListener(this);
        buttonPanel.add(contrastButton);
        brightnessButton=new Button("Enhance Brightness");
        brightnessButton.setBackground(Color.CYAN);
        brightnessButton.addActionListener(this);
        buttonPanel.add(brightnessButton);
        sharpnessButton=new Button("Enhance Sharpness");
        sharpnessButton.setBackground(Color.MAGENTA);
        sharpnessButton.addActionListener(this);
        buttonPanel.add(sharpnessButton);
        resetButton=new Button("Reset");
        resetButton.setBackground(Color.LIGHT_GRAY);
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);
        Panel scrollbarPanel=new Panel(new GridLayout(3,2,10,10));
        contrastLabel=new Label("Contrast:");
        scrollbarPanel.add(contrastLabel);
        contrastSB=new Scrollbar(Scrollbar.HORIZONTAL,10,1,1,200);
        contrastSB.setBackground(Color.RED);
        scrollbarPanel.add(contrastSB);
        brightnessLabel=new Label("Brightness:");
        scrollbarPanel.add(brightnessLabel);
        brightnessSB=new Scrollbar(Scrollbar.HORIZONTAL,10,1,1,200);
        brightnessSB.setBackground(Color.GREEN);
        scrollbarPanel.add(brightnessSB);
        sharpnessLabel=new Label("Sharpness:");
        scrollbarPanel.add(sharpnessLabel);
        sharpnessSB=new Scrollbar(Scrollbar.HORIZONTAL,10,1,1,200);
        sharpnessSB.setBackground(Color.BLUE);
        scrollbarPanel.add(sharpnessSB);
        add(buttonPanel,BorderLayout.NORTH);
        add(scrollbarPanel,BorderLayout.SOUTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==loadButton){
            FileDialog fileDialog=new FileDialog(this,"Select Image",FileDialog.LOAD);
            fileDialog.setVisible(true);
            String directory=fileDialog.getDirectory();
            String filename=fileDialog.getFile();
            if(filename!=null){
                try{
                    image1=ImageIO.read(new File(directory,filename));
                    image2=new BufferedImage(image1.getWidth(),image1.getHeight(),BufferedImage.TYPE_INT_RGB);
                    View.setImage(image1);
                    View.repaint();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }else if(e.getSource()==grayscaleButton){
            toGrayscale();
            View.setImage(image2);
            View.repaint();
        }else if (e.getSource()==contrastButton){
            forContrast(contrastSB.getValue());
            View.setImage(image2);
            View.repaint();
        }else if (e.getSource()==brightnessButton){
            forBrightness(brightnessSB.getValue());
            View.setImage(image2);
            View.repaint();
        }else if(e.getSource()==sharpnessButton){
            forSharpness(sharpnessSB.getValue());
            View.setImage(image2);
            View.repaint();
        }else if(e.getSource()==resetButton){
            resetImage();
        }
    }
    void toGrayscale(){
        for (int i=0;i<image1.getHeight();i++){
            for (int j=0;j<image1.getWidth();j++){
                int rgb=image1.getRGB(j,i);
                int r=(rgb>>16)&0xFF;
                int g=(rgb>>8)&0xFF;
                int b=rgb&0xFF;
                int gray=(r+g+b)/3;
                int grayRGB=(gray<<16)|(gray<<8)|gray;
                image2.setRGB(j,i,grayRGB);
            }
        }
    }
    void forContrast(int contrast){
        double contrastKey=contrast/10.0;
        for(int i= 0;i<image1.getHeight();i++){
            for(int j=0;j<image1.getWidth();j++){
                int rgb=image1.getRGB(j,i);
                int r=(rgb>>16)&0xFF;
                int g=(rgb>>8)&0xFF;
                int b=rgb&0xFF;
                int newR=(int)((r-128)*contrastKey+128);
                int newG=(int)((g-128)*contrastKey+128);
                int newB=(int)((b-128)*contrastKey+128);
                newR=Math.max(0, Math.min(255,newR));
                newG=Math.max(0, Math.min(255,newG));
                newB=Math.max(0, Math.min(255,newB));
                int newRGB=(newR<<16)|(newG<<8)|newB;
                image2.setRGB(j,i,newRGB);
            }
        }
    }
    void forBrightness(int brightness){
        for(int i=0;i<image1.getHeight();i++){
            for(int j=0;j<image1.getWidth();j++){
                int rgb=image1.getRGB(j,i);
                int r=(rgb>>16)&0xFF;
                int g=(rgb>>8)&0xFF;
                int b=rgb&0xFF;
                int newR=r+brightness;
                int newG=g+brightness;
                int newB=b+brightness;
                newR=Math.max(0,Math.min(255,newR));
                newG=Math.max(0,Math.min(255,newG));
                newB=Math.max(0,Math.min(255,newB));
                int adjustedRGB=(newR<<16)|(newG<<8)|newB;
                image2.setRGB(j,i,adjustedRGB);
            }
        }
    }
    void forSharpness(int sharpness){
        double sharpnessKey=sharpness/10.0;
        double[][] kernel={
                {-sharpnessKey,-sharpnessKey,-sharpnessKey},
                {-sharpnessKey,1+8*sharpnessKey,-sharpnessKey},
                {-sharpnessKey,-sharpnessKey,-sharpnessKey}
        };
        for(int i=1;i<image1.getHeight()-1;i++){
            for(int j=1;j<image1.getWidth()-1;j++){
                int r=0,g=0,b=0;
                for(int k=-1;k<=1;k++){
                    for(int l=-1;l<=1;l++){
                        int rgb=image1.getRGB(j+l,i+k);
                        int weight=(int)(kernel[k+1][l+1]*255);
                        r+=((rgb>>16)&0xFF)*weight;
                        g+=((rgb>>8)&0xFF)*weight;
                        b+=(rgb&0xFF)*weight;
                    }
                }
                r=Math.min(Math.max(r,0),255);
                g=Math.min(Math.max(g,0),255);
                b=Math.min(Math.max(b,0),255);
                image2.setRGB(j,i,(r<<16)|(g<<8)|b);
            }
        }
    }
    void resetImage(){
        View.setImage(image1);
        View.repaint();
    }
    public static void main(String[] args){
        colors imageEnhancer=new colors();
        imageEnhancer.setVisible(true);
    }
    static class ImagePanel extends Panel{
        Image image;
        public void setImage(Image image){
            this.image=image;
        }
        public void paint(Graphics g){
            super.paint(g);
            if(image!=null){
                g.drawImage(image,0,0,this);
            }
        }
    }
}