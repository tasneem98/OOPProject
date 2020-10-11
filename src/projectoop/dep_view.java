package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class dep_view extends JFrame implements MouseListener {

    JLabel l1 = new JLabel("Departement Name:");
    JLabel l2 = new JLabel("Departement ID:");
    JTextField l3 = new JTextField();
    JTextField l4 = new JTextField();

    JButton b1 = new JButton("Back");
    JButton ok = new JButton("OK");

    dep_view() throws IOException {

        JPanel p = new JPanel();
        this.setTitle("View Department");
        this.setLocation(400, 150);
        this.setSize(500, 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        p.setLayout(null);
        Font fnt1 = new Font("Arial", Font.BOLD, 25);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);
        Color c = new Color(60, 179, 113);
        l1.setForeground(c);
        l2.setForeground(c);
        l1.setFont(fnt1);
        l2.setFont(fnt1);
        l3.setFont(fnt1);
        l4.setFont(fnt1);
        l1.setBounds(20, 20, 250, 25);
        l2.setBounds(20, 70, 250, 25);
        l3.setBounds(270, 20, 180, 25);
        l3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        l3.setBackground(Color.white);
        l4.setBounds(270, 70, 180, 25);
        l4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        b1.setBounds(100, 145, 100, 30);
        ok.setBounds(350, 145, 100, 30);
        
        b1.setFont(fnt);
        ok.setFont(fnt);
        
        String path = "89.jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background_2 t = new background_2(image);
        t.setLayout(null);
        this.add(t);
        t.add(l1);
        t.add(l3);
        t.add(l2);
        t.add(l4);
        t.add(b1);
        t.add(ok);
        b1.addMouseListener(this);
        l3.enable(false);

        ok.addMouseListener(this);
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
            setVisible(false);

        }
        if (e.getSource() == ok) {

            Connection conn = null;
            PreparedStatement pst = null;

            try {

                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");
                pst = conn.prepareStatement("select *  from department where depart_id=" + l4.getText());

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {

                    l3.setText(rs.getString("department_name"));
                    l3.enable(false);

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
