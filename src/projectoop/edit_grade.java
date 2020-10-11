package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class edit_grade extends JFrame implements MouseListener {

    JLabel id = new JLabel("ID");
    JLabel stu_gra = new JLabel("Student Grade");
    JTextField id_ent = new JTextField();
    JButton search = new JButton("Search");
    JButton back = new JButton("Back");
    JButton drl = new JButton("Delete");

    edit_grade() throws IOException {

        setSize(400, 350);
        setLocation(200, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setTitle("Edit Grade");

        String path = "15 (2).jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background t = new background(image);
        t.setLayout(null);
        id.setForeground(Color.BLACK);
        stu_gra.setForeground(Color.BLACK);
        Font fnt1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 25);
        Font font = new Font("ALGERIAN", Font.BOLD, 25);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);

        search.setFont(fnt);
        back.setFont(fnt);
        drl.setFont(fnt);
        stu_gra.setFont(font);
        id.setFont(fnt1);
        id_ent.setFont(fnt1);
        stu_gra.setBounds(90, 30, 290, 30);
        id.setBounds(20, 120, 100, 20);
        id_ent.setBounds(90, 120, 190, 30);
        search.setBounds(20, 230, 100, 30);
        back.setBounds(280, 230, 100, 30);
        drl.setBounds(150, 230, 100, 30);
        add(t);
        t.add(stu_gra);
        t.add(id_ent);
        t.add(id);
        t.add(search);
        t.add(drl);
        t.add(back);
        back.addMouseListener(this);
        search.addMouseListener(this);

        drl.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == back) {
            try {
                choose s = new choose();
            } catch (IOException ex) {
                Logger.getLogger(edit_grade.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);

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

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == drl) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("delete from student_grade where ID =" + id_ent.getText());

                JOptionPane.showMessageDialog(null, "deleted");

                pst.execute();

                conn.close();

                id_ent.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }
        if (e.getSource() == search) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("select *  from student_grade where ID =" + id_ent.getText());

                ResultSet rs = pst.executeQuery();
                id_ent.setText("");
                while (rs.next()) {
                    String id = String.valueOf(rs.getInt("ID"));
                    String grade = String.valueOf(rs.getDouble("grade"));

                    Add s = new Add();
                    setVisible(false);
                    s.insert.setVisible(false);
                    s.t_stud_id.setText(id);
                    s.t_stud_id.enable(false);
                    s.t_stud_subj_code.setText(rs.getString("Subject_Code"));
                    s.t_stud_subj_code.enable(false);
                    s.t_stud_grade.setText(grade);

                }

                conn.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }

    }

}
