package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class personal_information_view extends JFrame implements MouseListener {

    JPanel p = new JPanel();
    JLabel id, f_name, m_name, l_name, gender, telenumber, birth_date;

    JTextField t_id, l1, l2, l3, l6, l4, l5;
    JButton b1 = new JButton("Back");
    JButton ok = new JButton("OK");

    personal_information_view() throws IOException {
        this.setTitle("View Registered Student");
        this.setLocation(400, 150);
        this.setSize(380, 400);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        id = new JLabel(" ID");
        f_name = new JLabel(" NAME");
        m_name = new JLabel("Age");
        l_name = new JLabel("Address");
        gender = new JLabel("GENDER");
        telenumber = new JLabel("TELEPHONE NUMBER");
        birth_date = new JLabel("user name");
        
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);
        
        t_id = new JTextField();
        l1 = new JTextField();
        l2 = new JTextField();
        l3 = new JTextField();
        l4 = new JTextField();
        l5 = new JTextField();
        l6 = new JTextField();
        id.setBounds(20, 20, 120, 25);
        t_id.setBounds(150, 20, 180, 25);
        f_name.setBounds(20, 60, 120, 25);
        l2.setBounds(150, 60, 180, 25);
        l2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        m_name.setBounds(20, 100, 120, 25);
        l3.setBounds(150, 100, 180, 25);
        l3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        l_name.setBounds(20, 140, 120, 25);
        l4.setBounds(150, 140, 180, 25);
        l4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        gender.setBounds(20, 180, 120, 25);
        l6.setBounds(150, 180, 180, 25);
        l6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        telenumber.setBounds(20, 220, 120, 25);
        l5.setBounds(150, 220, 180, 25);
        l5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        birth_date.setBounds(20, 260, 100, 25);
        l1.setBounds(150, 260, 180, 25);
        l1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

        b1.setBounds(80, 300, 100, 30);
        ok.setBounds(200, 300, 100, 30);
        
        b1.setFont(fnt);
        ok.setFont(fnt);
        
        String path = "e.jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background t = new background(image);
        t.setLayout(null);
        this.add(t);
        t.setLayout(null);
        t.add(id);
        t.add(t_id);
        t.add(f_name);
        t.add(l2);
        t.add(m_name);
        t.add(l3);
        t.add(l_name);
        t.add(l4);
        t.add(gender);
        t.add(l6);

        t.add(birth_date);
        t.add(l1);
        t.add(telenumber);
        t.add(l5);
        t.add(b1);
        t.add(ok);
        b1.addMouseListener(this);
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

        }
        if (e.getSource() == ok) {

            Connection conn = null;
            PreparedStatement pst = null;
            try {

                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("select *  from student_information where ID=" + t_id.getText());

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    String age = String.valueOf(rs.getInt("Age"));
                    String phone = String.valueOf(rs.getInt("Phone"));

                    l2.setText(rs.getString("Name"));
                    l2.enable(false);
                    l3.setText(age);
                    l3.enable(false);
                    l4.setText(rs.getString("Address"));
                    l4.enable(false);
                    l5.setText(phone);
                    l5.enable(false);
                    l1.setText(rs.getString("username"));
                    l1.enable(false);
                    l6.setText(rs.getString("Gender"));
                    l6.enable(false);
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
