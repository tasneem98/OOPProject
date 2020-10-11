package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class search extends JFrame implements MouseListener {

    JButton b1 = new JButton("Back");
    JButton b2 = new JButton("Search");
    JButton b3 = new JButton("Delete");
    JLabel L1 = new JLabel("Student Edit");
    JLabel L2 = new JLabel("ID");
    JTextField T = new JTextField();

    public search() throws IOException {
        F();
    }

    public void F() throws IOException {
        this.setTitle("Student Update");
        this.setSize(400, 350);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 250);

        Color c = new Color(169, 196, 245);
        L1.setForeground(Color.BLACK);
        L2.setForeground(Color.BLACK);
        Font font = new Font("ALGERIAN", Font.BOLD, 25);
        Font fnt1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);

        L1.setFont(font);
        L2.setFont(fnt1);
        T.setFont(fnt1);
        b1.setFont(fnt);
        b2.setFont(fnt);
        b3.setFont(fnt);
        L1.setBounds(90, 30, 290, 30);
        L2.setBounds(20, 120, 100, 20);
        T.setBounds(90, 120, 190, 30);
        b2.setBounds(20, 230, 100, 30);
        b1.setBounds(280, 230, 100, 30);
        b3.setBounds(150, 230, 100, 30);

        String path = "15 (2).jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background t = new background(image);
        t.setLayout(null);

        t.add(L1);
        t.add(L2);
        t.add(T);
        t.add(b1);
        t.add(b2);
        t.add(b3);
        add(t);

        b1.addMouseListener(this);
        b2.addMouseListener(this);
        b3.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == b1) {
            try {
                choose f = new choose();
                setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);

        }
        if (e.getSource() == b2) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Student_add f = new Student_add();
                f.but_insert.setVisible(false);
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("select *  from student_information where ID =" + T.getText());

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    String id = String.valueOf(rs.getInt("ID"));
                    String age = String.valueOf(rs.getInt("Age"));
                    String phone = String.valueOf(rs.getInt("Phone"));

                    f.t_stud_id.setText(id);
                    f.t_stud_id.enable(false);
                    f.t_stud_name.setText(rs.getString("Name"));
                    f.com_stud_gender.setSelectedItem(rs.getString("Gender"));
                    f.t_stud_age.setText(age);
                    f.t_stud_address.setText(rs.getString("Address"));
                    f.t_stud_phone.setText(phone);
                    f.user_ent.setText(rs.getString("username"));
                    f.password.setText(rs.getString("password"));

                }

                conn.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
            setVisible(false);

        }
        if (e.getSource() == b3) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("delete from student_information where ID =" + T.getText());

                JOptionPane.showMessageDialog(null, "deleted");

                pst.execute();

                conn.close();
                T.setText("");

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
