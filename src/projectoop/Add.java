package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Add extends JFrame implements MouseListener, ActionListener {

    JLabel l_stud_id, l_stud_subj_code, l_stud_grade;
    JTextField t_stud_id, t_stud_subj_code, t_stud_grade;
    JButton btn_back, insert, update;
    JPanel p1, p2, p3, p4;

    Add() throws IOException {
        grade();
    }

    public void grade() throws IOException {
        this.setTitle("Grade Information");
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocation(450, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("ALGERIAN", Font.BOLD, 25);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);
        Font fnt1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20);

        l_stud_id = new JLabel("ID");
        l_stud_subj_code = new JLabel("Code");
        l_stud_grade = new JLabel("Grade");
        t_stud_id = new JTextField();
        t_stud_subj_code = new JTextField();
        t_stud_grade = new JTextField();

        btn_back = new JButton("Back");
        insert = new JButton("Insert");
        update = new JButton("Update");

        l_stud_id.setBounds(25, 30, 100, 25);
        l_stud_subj_code.setBounds(25, 85, 100, 25);
        l_stud_grade.setBounds(25, 135, 100, 30);
        t_stud_id.setBounds(170, 30, 190, 30);
        t_stud_subj_code.setBounds(170, 85, 190, 30);
        t_stud_grade.setBounds(170, 135, 190, 30);

        insert.setBounds(20, 230, 100, 30);
        btn_back.setBounds(280, 230, 100, 30);
        update.setBounds(150, 230, 100, 30);

        insert.setFont(fnt);
        btn_back.setFont(fnt);
        update.setFont(fnt);

        l_stud_grade.setFont(fnt1);
        l_stud_id.setFont(fnt1);
        l_stud_subj_code.setFont(fnt1);

        t_stud_grade.setFont(fnt1);
        t_stud_id.setFont(fnt1);
        t_stud_subj_code.setFont(fnt1);
        String path = "9.jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background t = new background(image);
        t.setLayout(null);
        t.add(l_stud_id);
        t.add(t_stud_id);
        t.add(l_stud_subj_code);
        t.add(t_stud_subj_code);
        t.add(l_stud_grade);
        t.add(t_stud_grade);
        t.add(btn_back);
        t.add(insert);
        t.add(update);
        add(t);
        btn_back.addMouseListener(this);
        insert.addMouseListener(this);
        update.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == btn_back) {
            try {
                choose s = new choose();
            } catch (IOException ex) {
                Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);

        }
        if (e.getSource() == insert) {
            Connection conn = null;
            PreparedStatement pst1 = null;

            try {

                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst1 = (PreparedStatement) conn.prepareStatement("insert into student_grade (ID,Subject_Code,grade) values(?,?,?)");

                pst1.setString(1, t_stud_id.getText());
                pst1.setString(2, t_stud_subj_code.getText());
                pst1.setString(3, t_stud_grade.getText());
                JOptionPane.showMessageDialog(null, "inserted");
                pst1.executeUpdate();
                t_stud_id.setText("");
                t_stud_subj_code.setText("");
                t_stud_grade.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }
        if (e.getSource() == update) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("update  student_grade set Subject_Code='" + t_stud_subj_code.getText()
                        + "',grade='" + t_stud_grade.getText() + "'where ID=" + t_stud_id.getText());

                JOptionPane.showMessageDialog(null, "updated");

                pst.execute();

                conn.close();
                t_stud_id.setText("");
                t_stud_subj_code.setText("");
                t_stud_grade.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
