package projectoop;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.*;

public class tool extends JFrame implements MouseListener {

    JMenuBar b = new JMenuBar();
    JPanel jPanel2 = new JPanel();
    JMenu tt = new JMenu("Setup");
    JMenu tt1 = new JMenu("Result");

    JMenu tt3 = new JMenu("Security");
    JMenu t = new JMenu("Project Info.");

    JMenu t2 = new JMenu("Department");
    JMenu t3 = new JMenu("Student Register");

    JButton view = new JButton("View Departement");
    JButton Register = new JButton("Contact");
    JButton view_st = new JButton("View Registered Student");

    JButton log = new JButton("Log Out");
    JButton chanage_pass = new JButton("Chanage Password");
    JButton view_r = new JButton("Result");

    tool() throws IOException {
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Help");
        setResizable(false);
        b.setBounds(120, 30, 120, 30);
        b.setBackground(Color.white);
        Font f = new Font("ALGERIAN", Font.ITALIC, 20);

        t2.setBackground(Color.white);
        t3.setBackground(Color.white);
        t.setBackground(Color.white);

        view.setBackground(Color.white);
        Register.setBackground(Color.white);
        view_r.setBackground(Color.white);
        view_st.setBackground(Color.white);

        log.setBackground(Color.white);
        chanage_pass.setBackground(Color.white);

        tt.setForeground(Color.BLUE);
        tt1.setForeground(Color.blue);
        tt3.setForeground(Color.blue);
        tt.setFont(f);
        tt1.setFont(f);
        tt3.setFont(f);
        setJMenuBar(b);
        b.setSize(50, 10);

        ImageIcon i = new ImageIcon("13.jpg");
        ImageIcon i1 = new ImageIcon("5-512.png");
        ImageIcon i2 = new ImageIcon("45.jpg");
        ImageIcon i4 = new ImageIcon("computer-1331579_960_720.png");
        ImageIcon i5 = new ImageIcon("download (3).jpg");
        ImageIcon i6 = new ImageIcon("12.jpg");
        ImageIcon i7 = new ImageIcon("34.png");
        ImageIcon i8 = new ImageIcon("17.png");
        ImageIcon i9 = new ImageIcon("123.jpg");
        ImageIcon i10 = new ImageIcon("view.png");
        ImageIcon i11 = new ImageIcon("images (2).png");
        ImageIcon i12 = new ImageIcon("images (5).jpg");
        ImageIcon i14 = new ImageIcon("14.jpg");
        ImageIcon i15 = new ImageIcon("images.png");
        ImageIcon i16 = new ImageIcon("images (7).jpg");
        ImageIcon i17 = new ImageIcon("images (6).jpg");
        ImageIcon i18 = new ImageIcon("images (3).jpg");

        img m = new img();

        tt.setIcon(m.imgg(i));
        t2.setIcon(m.imgg(i1));
        t.setIcon(m.imgg(i2));

        t3.setIcon(m.imgg(i5));

        view.setIcon(m.imgg(i10));
        view_r.setIcon(m.imgg(i9));
        view_st.setIcon(m.imgg(i7));

        Register.setIcon(m.imgg(i11));
        tt1.setIcon(m.imgg(i14));
        tt3.setIcon(m.imgg(i15));
        chanage_pass.setIcon(m.imgg(i16));
        log.setIcon(m.imgg(i17));

        String path = "download (4).jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background_1 t10 = new background_1(image);

        add(jPanel2);
        tt1.add(view_r);

        b.add(tt);
        b.add(tt1);

        b.add(tt3);
        tt.add(t);

        tt.add(t2);
        tt.add(t3);

        t2.add(view);
        t3.add(Register);
        t3.add(view_st);

        tt3.add(log);
        tt3.add(chanage_pass);
        tt1.add(view_r);
        add(t10);
        setVisible(true);
        view.addMouseListener(this);
        view_r.addMouseListener(this);
        view_st.addMouseListener(this);
        log.addMouseListener(this);
        Register.addMouseListener(this);

        t.addMouseListener(this);
        chanage_pass.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == view) {
            setVisible(false);

            try {
                dep_view v = new dep_view();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
        if (e.getSource() == view_r) {
            setVisible(false);
            try {
                ShowDegree v = new ShowDegree();
            } catch (IOException ex) {
                Logger.getLogger(tool.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == view_st) {
            setVisible(false);

            try {
                personal_information_view v = new personal_information_view();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }

        }
        if (e.getSource() == log) {
            setVisible(false);
            try {
                log v = new log();
            } catch (IOException ex) {
                Logger.getLogger(tool.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == Register) {
            setVisible(false);
            try {
                contact v = new contact();
            } catch (IOException ex) {
                Logger.getLogger(tool.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == chanage_pass) {
            setVisible(false);
            try {
                rearch v = new rearch();
            } catch (IOException ex) {
                Logger.getLogger(tool.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == t) {
            setVisible(false);
            try {
                collage c = new collage();
            } catch (IOException ex) {
                Logger.getLogger(tool.class.getName()).log(Level.SEVERE, null, ex);
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
