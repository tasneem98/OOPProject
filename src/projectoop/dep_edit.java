package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class dep_edit extends JFrame implements MouseListener {

    JButton b;
    JButton bt, tb;
    JLabel l, la;
    JTextField t;

    public dep_edit() throws IOException {

        gui();
    }

    public void gui() throws IOException {
        this.setTitle("Department Edit");
        this.setResizable(false);
        this.setSize(450, 350);
        setLocation(200, 250);

        Font font = new Font("ALGERIAN", Font.BOLD, 25);
        Font fnt1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String path = "15 (2).jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background tt = new background(image);
        tt.setLayout(null);
        this.add(tt);
        tt.setLayout(null);
        b = new JButton("Back");
        b.setBounds(280, 250, 100, 30);

        bt = new JButton("Search");
        bt.setBounds(20, 250, 100, 30);
        tb = new JButton("Delete");
        tb.setBounds(150, 250, 100, 30);

        l = new JLabel("Department name");
        l.setBounds(80, 30, 280, 30);
        la = new JLabel("ID");
        la.setBounds(40, 150, 100, 30);
        t = new JTextField();
        t.setBounds(140, 150, 190, 30);

        l.setFont(font);
        la.setFont(fnt1);
        t.setFont(fnt1);

        b.setFont(fnt);
        bt.setFont(fnt);
        tb.setFont(fnt);
        l.setForeground(Color.BLACK);
        la.setForeground(Color.BLACK);
        tt.add(l);
        tt.add(la);
        tt.add(t);
        tt.add(b);
        tt.add(bt);
        tt.add(tb);

        this.setVisible(true);
        b.addMouseListener(this);
        bt.addMouseListener(this);
        tb.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == b) {
            setVisible(false);
            try {
                choose c = new choose();
            } catch (IOException ex) {
                Logger.getLogger(dep_add.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
        }

        if (e.getSource() == tb) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("delete from department where depart_id =" + t.getText());

                JOptionPane.showMessageDialog(null, "deleted");

                pst.execute();

                conn.close();
                t.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        } else if (e.getSource() == bt) {
            Connection conn = null;
            PreparedStatement pst = null;
            setVisible(false);

            try {
                dep_add s = new dep_add();
                s.save.setVisible(false);

                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("select *  from department where depart_id =" + t.getText());

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    String id = String.valueOf(rs.getInt("depart_id"));

                    s.dep_tid.setText(id);
                    s.dep_tid.enable(false);

                    s.dep.setText(rs.getString("department_name"));

                }

                conn.close();

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
