package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class collage extends JFrame implements MouseListener {

    JLabel l1 = new JLabel("Project Goals");
    JLabel l2 = new JLabel("The main objective of this project is to establish an integrated University Management system");
    JLabel l3 = new JLabel("which enables us to automate the dynamic administrative processes in the university.");
    JLabel l4 = new JLabel("achieved through:");
    JLabel l5 = new JLabel(" (1) Supporting the decision making process.");
    JLabel l6 = new JLabel(" (2) Improving the services provided to the students, Teacher And Department.");
    JLabel l7 = new JLabel(" (3) Improving the accuracy of the follow up and management of student data in the university.");
    JLabel l8 = new JLabel("Features");
    JLabel l9 = new JLabel("The main objective of the proposed university management system is to computerize the existing.");
    JLabel l10 = new JLabel("system and reduce manpower and time consumption. It provides the following features: ");
    JLabel l11 = new JLabel("(1) Maintain information of students and teachers");
    JLabel l12 = new JLabel("(2) Centralized database management");
    JLabel l13 = new JLabel("(3) Reduce error in data management");
    JLabel l14 = new JLabel("(4) Easy and user-friendly interface for the operator of the system.");

    JButton b1 = new JButton("Back");

    collage() throws IOException {
        this.setTitle("Project Info.");
        setSize(900, 550);
        setLocation(300, 50);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        String path = "23583b13eadcefc.jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background_3 tt = new background_3(image);
        tt.setLayout(null);
        Font font = new Font("Algerian", Font.BOLD, 27);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);
        Color c = new Color(74, 88, 224);
        l1.setBounds(350, 30, 300, 25);
        l2.setBounds(10, 60, 890, 25);
        l3.setBounds(10, 90, 890, 25);
        l4.setBounds(100, 120, 890, 25);
        l5.setBounds(10, 150, 890, 25);
        l6.setBounds(10, 180, 890, 25);
        l7.setBounds(10, 210, 890, 25);
        l8.setBounds(350, 240, 200, 25);
        l9.setBounds(10, 270, 890, 25);
        l10.setBounds(10, 300, 890, 25);
        l11.setBounds(10, 330, 890, 25);
        l12.setBounds(10, 360, 890, 25);
        l13.setBounds(10, 390, 890, 25);
        l14.setBounds(10, 420, 890, 25);
        b1.setBounds(390, 480, 100, 30);
        
        b1.setFont(fnt);
        
        l1.setForeground(c);
        l8.setForeground(c);
        this.add(tt);
        tt.add(l1);
        tt.add(l2);
        tt.add(l3);
        tt.add(l4);
        tt.add(l5);
        tt.add(l6);
        tt.add(l7);
        tt.add(l8);
        tt.add(l9);
        tt.add(l10);
        tt.add(l11);
        tt.add(l12);
        tt.add(l13);
        tt.add(l14);
        l1.setFont(font);
        l2.setFont(fnt);
        l3.setFont(fnt);
        l4.setFont(fnt);
        l5.setFont(fnt);
        l6.setFont(fnt);
        l7.setFont(fnt);
        l8.setFont(font);
        l9.setFont(fnt);
        l10.setFont(fnt);
        l11.setFont(fnt);
        l12.setFont(fnt);
        l13.setFont(fnt);
        l14.setFont(fnt);

        tt.add(b1);
        b1.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == b1) {
            setVisible(false);
            try {
                tool y = new tool();
            } catch (IOException ex) {
                Logger.getLogger(collage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}
