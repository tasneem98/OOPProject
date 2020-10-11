package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Student_add extends JFrame implements MouseListener {

    JLabel l_stud_id = new JLabel("ID");
    JTextField t_stud_id = new JTextField();
    JLabel l_stud_name = new JLabel("Name");
    JTextField t_stud_name = new JTextField();
    JLabel l_stud_gender = new JLabel("Gender");
    String[] x = {"Male", "Female"};
    JComboBox com_stud_gender = new JComboBox(x);
    JLabel l_stud_age = new JLabel("Age");
    JTextField t_stud_age = new JTextField();
    JLabel l_stud_address = new JLabel("Address");
    JTextField t_stud_address = new JTextField();
    JLabel l_stud_phone = new JLabel("Phone");
    JTextField t_stud_phone = new JTextField();
    JButton but_insert = new JButton("Insert");
    JButton btn_update = new JButton("Update");
    JButton but_back = new JButton("Back");
    JLabel stud_image = new JLabel();
    JLabel l = new JLabel("Add Student");
    JTextField user_ent = new JTextField();
    JPasswordField password = new JPasswordField();
    JLabel user = new JLabel("User Name");

    JLabel pass = new JLabel("Password");

    Student_add() throws IOException {
        setTitle("Student Information");
        setSize(600, 600);
        setResizable(false);
        setLocation(450, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Font font = new Font("ALGERIAN", Font.BOLD, 25);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);
        Font fnt1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20);

        stud_image.setIcon(new ImageIcon("image.jpg"));

        stud_image.setBounds(450, 0, 450, 200);
        l_stud_id.setBounds(15, 50, 100, 25);
        l_stud_name.setBounds(15, 110, 100, 25);
        l_stud_gender.setBounds(15, 170, 100, 30);
        l_stud_age.setBounds(15, 230, 100, 30);
        l_stud_address.setBounds(15, 290, 100, 30);
        l_stud_phone.setBounds(15, 350, 100, 30);
        pass.setBounds(15, 450, 100, 30);
        user.setBounds(15, 400, 100, 30);

        t_stud_id.setBounds(140, 50, 190, 30);
        t_stud_name.setBounds(140, 110, 190, 30);
        com_stud_gender.setBounds(140, 170, 190, 30);
        t_stud_age.setBounds(140, 230, 190, 30);
        t_stud_address.setBounds(140, 290, 190, 30);
        t_stud_phone.setBounds(140, 350, 190, 30);
        user_ent.setBounds(140, 400, 190, 30);

        password.setBounds(140, 450, 190, 30);

        but_insert.setBounds(425, 510, 100, 30);
        btn_update.setBounds(275, 510, 100, 30);
        but_back.setBounds(125, 510, 100, 30);

        l_stud_address.setFont(fnt1);
        l_stud_age.setFont(fnt1);
        l_stud_gender.setFont(fnt1);
        l_stud_id.setFont(fnt1);
        l_stud_name.setFont(fnt1);
        l_stud_phone.setFont(fnt1);
        l.setFont(font);

        t_stud_address.setFont(fnt1);
        t_stud_age.setFont(fnt1);
        t_stud_id.setFont(fnt1);
        t_stud_name.setFont(fnt1);
        t_stud_phone.setFont(fnt1);

        but_insert.setFont(fnt);
        btn_update.setFont(fnt);
        but_back.setFont(fnt);
        String path = "9.jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background t = new background(image);
        t.setLayout(null);
        t.add(l_stud_id);
        t.add(t_stud_id);
        t.add(l_stud_name);
        t.add(t_stud_name);
        t.add(l_stud_gender);
        t.add(com_stud_gender);
        t.add(l_stud_age);
        t.add(t_stud_age);
        t.add(l_stud_address);
        t.add(t_stud_address);
        t.add(l_stud_phone);
        t.add(t_stud_phone);
        t.add(but_insert);
        t.add(btn_update);
        t.add(but_back);
        t.add(stud_image);

        user_ent.setFont(fnt1);

        user.setFont(fnt1);
        pass.setFont(fnt1);

        t.add(user);
        t.add(user_ent);
        t.add(pass);
        t.add(password);

        add(t);

        but_back.addMouseListener(this);
        btn_update.addMouseListener(this);
        but_insert.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == but_back) {
            try {
                choose f = new choose();
            } catch (IOException ex) {
                Logger.getLogger(Student_add.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == but_back) {
            setVisible(false);
            try {
                choose ff = new choose();
            } catch (IOException ex) {
                Logger.getLogger(Student_add.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);

        }
        if (e.getSource() == but_insert) {
            Connection conn = null;
            PreparedStatement pst1 = null;

            try {

                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst1 = (PreparedStatement) conn.prepareStatement("insert into student_information "
                        + "(ID,Name,Gender,Age,Address,Phone,username,password ) values(?,?,?,?,?,?,?,?)");

                pst1.setString(1, t_stud_id.getText());
                pst1.setString(2, t_stud_name.getText());
                pst1.setString(3, (String) com_stud_gender.getSelectedItem());
                pst1.setString(4, t_stud_age.getText());
                pst1.setString(5, t_stud_address.getText());
                pst1.setString(6, t_stud_phone.getText());
                pst1.setString(7, user_ent.getText());
                pst1.setString(8, password.getText());
                JOptionPane.showMessageDialog(null, "inserted");
                pst1.executeUpdate();
                t_stud_id.setText("");
                t_stud_name.setText("");
                com_stud_gender.setSelectedItem("");
                t_stud_age.setText("");
                t_stud_address.setText("");
                t_stud_phone.setText("");
                user_ent.setText("");
                password.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }
        if (e.getSource() == btn_update) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("update  student_information set Name='" + t_stud_name.getText() + "',Gender='"
                        + (String) com_stud_gender.getSelectedItem() + "',Age='" + t_stud_age.getText()
                        + "',Address='" + t_stud_address.getText() + "',Phone='" + t_stud_phone.getText()
                        + "',username='" + user_ent.getText() + "',password='" + password.getText() + "'where ID =" + t_stud_id.getText());

                JOptionPane.showMessageDialog(null, "updated");

                pst.execute();

                conn.close();
                t_stud_id.setText("");
                t_stud_name.setText("");
                com_stud_gender.setSelectedItem("");
                t_stud_age.setText("");
                t_stud_address.setText("");
                t_stud_phone.setText("");
                user_ent.setText("");
                password.setText("");

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
