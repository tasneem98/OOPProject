package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class rearch extends JFrame implements MouseListener {

    JLabel L1 = new JLabel("User Name:");
    JLabel L2 = new JLabel("Current Password:");
    JLabel L3 = new JLabel("New Password:");
    JLabel L4 = new JLabel("Confirm Password:");
    JTextField T1 = new JTextField();
    JPasswordField T2 = new JPasswordField();
    JTextField T3 = new JTextField();
    JTextField T4 = new JTextField();

    JButton b1 = new JButton("Back");
    JButton b2 = new JButton("Insert");

    public rearch() throws IOException {
        R();
    }

    public void R() throws IOException {

        this.setTitle("Change Password");
        this.setSize(520, 510);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 200);

        Font f = new Font("Araile", Font.CENTER_BASELINE, 20);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);

        L1.setFont(f);
        L2.setFont(f);
        L3.setFont(f);
        L4.setFont(f);
        b1.setFont(fnt);
        b2.setFont(fnt);

        L1.setBounds(40, 80, 150, 25);
        T1.setBounds(250, 80, 200, 25);
        L2.setBounds(40, 160, 200, 25);
        T2.setBounds(250, 160, 200, 25);
        L3.setBounds(40, 240, 150, 25);
        T3.setBounds(250, 240, 200, 25);
        L4.setBounds(40, 330, 200, 25);
        T4.setBounds(250, 330, 200, 25);
        b1.setBounds(30, 400, 100, 30);
        b2.setBounds(390, 400, 100, 30);

        String path = "78.jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background_1 t = new background_1(image);
        t.setLayout(null);

        add(t);
        t.add(L1);
        t.add(L2);
        t.add(L3);
        t.add(L4);
        t.add(T1);
        t.add(T2);
        t.add(T3);
        t.add(T4);
        t.add(b1);
        t.add(b2);
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

        } else if (e.getSource() == b2) {

            Connection conn = null;
            PreparedStatement pst1 = null;

            try {

                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst1 = (PreparedStatement) conn.prepareStatement("insert into change_password "
                        + "(user_name,current_password,new_password,confirm_password ) values(?,?,?,?)");

                pst1.setString(1, T1.getText());
                pst1.setString(2, T2.getText());

                pst1.setString(3, T3.getText());
                pst1.setString(4, T4.getText());

                JOptionPane.showMessageDialog(null, "inserted");
                pst1.executeUpdate();
                T1.setText("");
                T2.setText("");
                T3.setText("");
                T4.setText("");

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
