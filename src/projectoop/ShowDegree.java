package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ShowDegree extends JFrame implements MouseListener {

    JLabel lbl_id = new JLabel("ID");
    JTextField txtFld_id = new JTextField();

    JLabel lbl_StudentName = new JLabel("Student Name");
    JTextField txtFld_StudentName = new JTextField();

    JLabel lbl_SubjectCode = new JLabel("Subject Code");
    JTextField txtFld_SubjectCode = new JTextField();

    JLabel lbl_SubjectName = new JLabel("Subject Name");
    JTextField txtFld_SubjectName = new JTextField();

    JLabel lbl_degree = new JLabel("Degree");
    JTextField txtFld_degree = new JTextField();

    JButton btn_back = new JButton("Back");
    JButton btn_ok = new JButton("OK");

    public ShowDegree() throws IOException {
        setTitle("Result");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(330, 200);
        setResizable(false);
        setSize(800, 550);

        Font fnt = new Font("Calibri Light", Font.BOLD, 20);
        Font fnt1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20);

        lbl_id.setFont(fnt1);
        lbl_StudentName.setFont(fnt1);
        lbl_SubjectCode.setFont(fnt1);
        lbl_SubjectName.setFont(fnt1);
        lbl_degree.setFont(fnt1);

        txtFld_id.setFont(fnt1);
        txtFld_StudentName.setFont(fnt1);
        txtFld_SubjectCode.setFont(fnt1);
        txtFld_SubjectName.setFont(fnt1);
        txtFld_degree.setFont(fnt1);

        btn_back.setFont(fnt);
        btn_ok.setFont(fnt);

        lbl_id.setBounds(50, 75, 300, 20);
        lbl_StudentName.setBounds(50, 150, 300, 20);
        lbl_SubjectCode.setBounds(50, 225, 300, 20);
        lbl_SubjectName.setBounds(50, 300, 300, 20);
        lbl_degree.setBounds(50, 375, 300, 20);

        txtFld_id.setBounds(350, 75, 190, 30);
        txtFld_StudentName.setBounds(350, 150, 190, 30);
        txtFld_SubjectCode.setBounds(350, 225, 190, 30);
        txtFld_SubjectName.setBounds(350, 300, 190, 30);
        txtFld_degree.setBounds(350, 375, 190, 30);

        btn_back.setBounds(200, 450, 100, 30);
        btn_ok.setBounds(400, 450, 100, 30);

        String path = "images (8).jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background_1 bgd = new background_1(image);
        bgd.setLayout(null);

        bgd.add(lbl_id);
        bgd.add(txtFld_id);

        bgd.add(lbl_StudentName);
        bgd.add(txtFld_StudentName);

        bgd.add(lbl_SubjectCode);
        bgd.add(txtFld_SubjectCode);

        bgd.add(lbl_SubjectName);
        bgd.add(txtFld_SubjectName);

        bgd.add(lbl_degree);
        bgd.add(txtFld_degree);

        bgd.add(btn_back);
        bgd.add(btn_ok);

        add(bgd);
        setVisible(true);
        btn_back.addMouseListener(this);
        btn_ok.addMouseListener(this);
        txtFld_StudentName.enable(false);
        txtFld_SubjectName.enable(false);
        txtFld_degree.enable(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == btn_back) {
            try {
                tool b = new tool();
            } catch (IOException ex) {
                Logger.getLogger(ShowDegree.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
            setVisible(false);

        }
        if (e.getSource() == btn_ok) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("select *  from student_grade where ID= '" + txtFld_id.getText()
                        + "' and Subject_Code='" + txtFld_SubjectCode.getText() + "'");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String gra = String.valueOf(rs.getDouble("grade"));

                    txtFld_degree.setText(gra);
                    txtFld_degree.enable(false);
                }

                conn.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }
        if (e.getSource() == btn_ok) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("select *  from subject_add where subject_code=" + txtFld_SubjectCode.getText());
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    txtFld_SubjectName.setText(rs.getString("name"));
                    txtFld_SubjectName.enable(false);
                }

                conn.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }
        if (e.getSource() == btn_ok) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("select *  from student_information where ID=" + txtFld_id.getText());
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    txtFld_StudentName.setText(rs.getString("Name"));
                    txtFld_StudentName.enable(false);
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
