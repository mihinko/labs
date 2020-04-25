package com.company;


import java.awt.geom.*;
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;


public class laba4 extends javax.swing.JPanel {

    private class MyTimerTask extends TimerTask {
        int i = 0;
        @Override
        public void run() {
            double theta1 = 0.05;
            if (theta1 == 0.0)
            {
                try
                {
                    throw new ArithmeticException("Введён ноль");
                }catch (ArithmeticException ex)
                {
                    System.out.println(ex);
                    System.exit(-1);
                }
            }
            transformers = AffineTransform.getRotateInstance(i++ * theta1, 150, 150);

            intColor += 0x070B11;
            if (intColor < 0) {
                intColor = -intColor;
            }
            repaint();
        }
    }

    private int intColor = 0;
    private AffineTransform transformers;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.transform(transformers);
        Color newColor = new Color(intColor);
        g.setColor(newColor);
        BasicStroke pen = new BasicStroke(3);
        g2.setStroke(pen);
        g2.draw(new Line2D.Float(150, 150, 0, 0));
    }

    public laba4() {
        Timer t = new Timer();
        t.schedule(new MyTimerTask(), 100, 100);
    }

    public static void main(String[] args) {
        javax.swing.JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 300);
        frame.setContentPane(new laba4());
        frame.setVisible(true);
    }
}