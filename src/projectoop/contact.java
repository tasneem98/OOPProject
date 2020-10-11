package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class contact extends JFrame implements MouseListener {

    JLabel L = new JLabel("Contacts:");
    JLabel L1 = new JLabel("Mobile phone:");
    JTextField T1 = new JTextField();
    JLabel L2 = new JLabel("Email:");
    JTextField T2 = new JTextField();
    JLabel L3 = new JLabel("Address:");
    JTextField T3 = new JTextField();
    JLabel L4 = new JLabel("Alternative Mobile Phone:");
    JTextField T4 = new JTextField();
    JLabel L5 = new JLabel("Fax:");
    JTextField T5 = new JTextField();

    JButton b1 = new JButton("Back");
    JButton b2 = new JButton("Insert");

    public contact() throws IOException {

        this.setTitle("Contact");
        this.setSize(700, 550);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 150);

        Font f = new Font("Araile", Font.CENTER_BASELINE, 20);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);

        L.setFont(f);
        L1.setFont(f);
        L2.setFont(f);
        L3.setFont(f);
        L4.setFont(f);
        L5.setFont(f);

        b1.setFont(fnt);
        b2.setFont(fnt);

        L.setBounds(30, 30, 120, 25);
        L1.setBounds(200, 100, 300, 25);
        T1.setBounds(450, 100, 230, 25);
        L2.setBounds(200, 160, 300, 25);
        T2.setBounds(450, 160, 230, 25);
        L3.setBounds(200, 220, 300, 25);
        T3.setBounds(450, 220, 230, 25);
        L4.setBounds(200, 280, 300, 25);
        T4.setBounds(450, 280, 230, 25);
        L5.setBounds(200, 340, 300, 25);
        T5.setBounds(400, 340, 230, 25);

        b1.setBounds(30, 480, 100, 30);
        b2.setBounds(500, 480, 100, 30);

        String path = "58.png";
        BufferedImage image = ImageIO.read(new File(path));
        background_2 t = new background_2(image);
        t.setLayout(null);

        t.add(L);
        t.add(L1);
        t.add(L2);
        t.add(L3);
        t.add(L4);
        t.add(L5);

        t.add(b1);
        t.add(b2);
        t.add(T1);
        t.add(T2);
        t.add(T3);
        t.add(T4);
        t.add(T5);

        add(t);
        b1.addMouseListener(this);
        b2.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == b1) {
            setVisible(false);
            try {
                tool h = new tool();
            } catch (IOException ex) {
                Logger.getLogger(dep_view.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == b2) {
            Connection conn = null;
            PreparedStatement pst1 = null;

            try {

                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst1 = (PreparedStatement) conn.prepareStatement("insert into contact "
                        + "(mobile_phone,Email,Address,fax,alternative_mobile_phone)" + " values(?,?,?,?,?)");

                pst1.setString(1, T1.getText());
                pst1.setString(2, T2.getText());
                pst1.setString(3, T3.getText());
                pst1.setString(4, T5.getText());
                pst1.setString(5, T4.getText());
                JOptionPane.showMessageDialog(null, "inserted");

                pst1.executeUpdate();
                T1.setText("");
                T2.setText("");
                T3.setText("");
                T4.setText("");
                T5.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

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
