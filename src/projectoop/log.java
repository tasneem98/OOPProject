package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class log extends JFrame implements MouseListener {

    JButton log = new JButton("Log In");
    JButton exit = new JButton("Exit");
    JTextField user_ent = new JTextField();
    JPasswordField password = new JPasswordField();
    JLabel user = new JLabel("User Name");
    JLabel l = new JLabel("Log In");
    JLabel pass = new JLabel("Password");
    String passNum = new String("123");
    JLabel im;

    log() throws IOException {
        setSize(500, 450);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setTitle("Log In");

        setLayout(new GridLayout(1, 2));
        Color c = new Color(138, 43, 226);
        user_ent.setBounds(190, 200, 130, 30);
        user.setBounds(50, 200, 120, 30);
        password.setBounds(190, 250, 130, 30);

        pass.setBounds(50, 250, 120, 30);
        log.setBounds(100, 320, 100, 30);
        exit.setBounds(300, 320, 100, 30);
        l.setBounds(205, 120, 150, 40);
        user.setForeground(c);
        l.setForeground(c);
        pass.setForeground(c);

        Font font = new Font("ALGERIAN", Font.BOLD, 25);
        Font fnt1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);

        user_ent.setFont(fnt1);

        user.setFont(fnt1);
        pass.setFont(fnt1);
        l.setFont(font);
        log.setFont(fnt);
        exit.setFont(fnt);
        
        String path = "15 (1).jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background t = new background(image);
        t.setLayout(null);

        t.add(l);
        t.add(user);
        t.add(user_ent);
        t.add(pass);
        t.add(password);
        t.add(log);
        add(t);
        t.add(exit);

        log.addMouseListener(this);
        exit.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }

        if (e.getSource() == log) {
            if (user_ent.getText().equals("user") && password.getText().equals(passNum)) {
                setVisible(false);
                try {
                    choose s = new choose();
                } catch (IOException ex) {
                    Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (user_ent.getText().equals("student") && password.getText().equals(passNum)) {
                setVisible(false);
                try {
                    tool s = new tool();
                } catch (IOException ex) {
                    Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, " user name / password is mistake ");
                setVisible(true);

            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
