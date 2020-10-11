package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class dep_add extends JFrame implements MouseListener {

    JPanel p = new JPanel();
    JTextField dep = new JTextField();
    JTextArea dep_t = new JTextArea();
    JLabel dep_l = new JLabel("Name");
    JLabel id = new JLabel("ID");
    JTextField dep_tid = new JTextField();
    JButton save = new JButton("Insert");
    JButton update = new JButton("Update");
    JButton cansel = new JButton("Back");

    dep_add() throws IOException {
        this.setTitle("Department Information");
        this.setLocation(400, 150);
        this.setSize(420, 250);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        p.setLayout(null);
        Font font = new Font("ALGERIAN", Font.BOLD, 25);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);
        Font fnt1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 17);
        dep_l.setFont(fnt1);
        id.setFont(fnt1);
        save.setFont(fnt);
        cansel.setFont(fnt);
        update.setFont(fnt);
        dep_l.setBounds(20, 20, 180, 25);
        dep.setBounds(210, 20, 180, 25);
        id.setBounds(20, 60, 180, 25);
        dep_tid.setBounds(210, 60, 180, 25);
        cansel.setBounds(80, 130, 100, 30);
        save.setBounds(200, 130, 100, 30);
        update.setBounds(200, 130, 100, 30);
        String path = "9.jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background t = new background(image);
        t.setLayout(null);
        this.add(t);
        t.add(dep_l);
        t.add(dep);
        t.add(id);
        t.add(dep_tid);
        t.add(save);
        t.add(cansel);
        t.add(update);
        cansel.addMouseListener(this);
        save.addMouseListener(this);
        update.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == cansel) {
            setVisible(false);
            try {
                choose c = new choose();
            } catch (IOException ex) {
                Logger.getLogger(dep_add.class.getName()).log(Level.SEVERE, null, ex);
            }
            setVisible(false);
        }
        if (me.getSource() == save) {
            Connection conn = null;
            PreparedStatement pst1 = null;

            try {

                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst1 = (PreparedStatement) conn.prepareStatement("insert into department (department_name,depart_id) values(?,?)");

                pst1.setString(1, dep.getText());
                pst1.setString(2, dep_tid.getText());

                JOptionPane.showMessageDialog(null, "inserted");

                pst1.executeUpdate();
                dep.setText("");
                dep_tid.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }
        if (me.getSource() == update) {
            Connection conn = null;
            PreparedStatement pst = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "#Tasneem98");

                pst = conn.prepareStatement("update  department set depart_id='" + dep_tid.getText() + "',department_name='"
                        + dep.getText() + "'where depart_id=" + dep_tid.getText());

                JOptionPane.showMessageDialog(null, "updated");

                pst.execute();

                conn.close();
                dep.setText("");
                dep_tid.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
