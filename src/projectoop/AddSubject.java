package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AddSubject extends JFrame implements MouseListener {

    JLabel lbl_code = new JLabel("Code");
    JTextField txtFld_code = new JTextField();

    JLabel lbl_name = new JLabel("name");
    JTextField txtFld_name = new JTextField();

    JLabel lbl_hours = new JLabel("Hours");
    JTextField txtfld_hours = new JTextField();

    JLabel lbl_img = new JLabel();

    JButton btn_insert = new JButton("Insert");
    JButton btn_update = new JButton("Update");
    JButton btn_back = new JButton("Back");

    public AddSubject() throws IOException {
        setTitle("Subject Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(330, 200);
        setResizable(false);
        setSize(560, 300);
        setVisible(true);

        Font fnt = new Font("Calibri Light", Font.BOLD, 20);
        Font fnt1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20);

        lbl_code.setFont(fnt1);
        lbl_hours.setFont(fnt1);
        lbl_name.setFont(fnt1);

        txtFld_code.setFont(fnt1);
        txtFld_name.setFont(fnt1);

        Font font = new Font("ALGERIAN", Font.BOLD, 25);
        txtfld_hours.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 15));

        btn_back.setFont(fnt);
        btn_insert.setFont(fnt);
        btn_update.setFont(fnt);

        lbl_code.setBounds(27, 24, 70, 20);
        lbl_name.setBounds(27, 74, 70, 20);
        lbl_hours.setBounds(27, 124, 70, 20);

        txtFld_code.setBounds(120, 20, 190, 30);
        txtFld_name.setBounds(120, 70, 190, 30);
        txtfld_hours.setBounds(120, 120, 50, 30);

        btn_insert.setBounds(50, 230, 100, 30);
        btn_update.setBounds(230, 230, 100, 30);
        btn_back.setBounds(380, 230, 100, 30);
        String path = "9.jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background t = new background(image);
        t.setLayout(null);

        t.add(lbl_code);
        t.add(txtFld_code);

        t.add(lbl_name);
        t.add(txtFld_name);

        t.add(lbl_hours);
        t.add(txtfld_hours);

        t.add(btn_back);
        t.add(btn_update);
        t.add(btn_insert);

        add(t);

        btn_back.addMouseListener(this);
        btn_update.addMouseListener(this);
        btn_insert.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == btn_back) {
            try {
                choose ff = new choose();
                setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(AddSubject.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);

        }
        if (e.getSource() == btn_insert) {
            Connection conn = null;
            PreparedStatement pst1 = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");
                pst1 = (PreparedStatement) conn.prepareStatement("insert into subject_add (subject_code,name,Hours) values(?,?,?)");
                pst1.setString(1, txtFld_code.getText());
                pst1.setString(2, txtFld_name.getText());
                pst1.setString(3, txtfld_hours.getText());
                JOptionPane.showMessageDialog(null, "insertd");
                pst1.executeUpdate();
                txtFld_code.setText("");
                txtFld_name.setText("");
                txtfld_hours.setText("");
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

                pst = conn.prepareStatement("update  subject_add set name='" + txtFld_name.getText() + "',Hours='"
                        + txtfld_hours.getText() + "'where subject_code=" + txtFld_code.getText());

                JOptionPane.showMessageDialog(null, "updated");

                pst.execute();

                conn.close();
                txtFld_code.setText("");
                txtFld_name.setText("");
                txtfld_hours.setText("");

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
