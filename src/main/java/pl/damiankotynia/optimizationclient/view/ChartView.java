package pl.damiankotynia.optimizationclient.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ChartView {

    private JPanel jPanel;
    private JLabel jLabel;
    private JFrame jFrame;

    public ChartView(){
        jLabel= new JLabel();
        jPanel = new JPanel();
        jPanel.add(jLabel);
        jFrame = new JFrame();
        jFrame.add(jPanel);
        jFrame.setVisible(false);
    }

    public void showImage(BufferedImage image){
        jLabel.setIcon(new ImageIcon(image));
        jFrame.setSize(new Dimension(image.getWidth(), image.getHeight()));
        jFrame.setVisible(true);
    }

    public void hideWindow(){
        this.jFrame.setVisible(false);
    }
}
