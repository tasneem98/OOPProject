package projectoop;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class choose extends JFrame implements MouseListener, ActionListener {

    JRadioButton r1, r2, r3, r4;
    JButton b1, b2;
    JButton EDIT = new JButton("Edit");
    ButtonGroup bg, bg1;

    JLabel l1;

    choose() throws IOException {
        this.setTitle("Choosing");
        this.setSize(450, 350);
        this.setResizable(false);
        this.setLocation(450, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("ALGERIAN", Font.BOLD, 25);
        Font fnt = new Font("Calibri Light", Font.BOLD, 20);
        Font fnt1 = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20);

        r1 = new JRadioButton(" Student");
        r2 = new JRadioButton(" Subject");
        r3 = new JRadioButton(" Grade");
        r4 = new JRadioButton(" Department");
        b1 = new JButton("Add");
        b2 = new JButton("Log out");
        String path = "698.jpg";
        BufferedImage image = ImageIO.read(new File(path));
        background t = new background(image);
        t.setLayout(null);
        bg = new ButtonGroup();

        l1 = new JLabel("SELECT FROM CHOICES");

        l1.setFont(font);

        l1.setBounds(65, 10, 390, 100);
        b1.setBounds(80, 170, 100, 30);
        b2.setBounds(170, 240, 100, 30);
        EDIT.setBounds(230, 170, 100, 30);
        r1.setBounds(10, 120, 100, 25);
        r2.setBounds(120, 120, 100, 25);
        r3.setBounds(230, 120, 100, 25);
        r4.setBounds(340, 120, 100, 25);

        b1.setFont(fnt);
        EDIT.setFont(fnt);
        b2.setFont(fnt);

        this.add(t);
        t.add(l1);
        t.add(r1);
        t.add(r2);
        t.add(r3);
        t.add(b1);
        t.add(EDIT);
        t.add(r4);
        t.add(b2);
        bg.add(r1);
        bg.add(r2);
        r1.setBackground(null);
        bg.add(r3);
        bg.add(r4);
        b1.addMouseListener(this);
        EDIT.addMouseListener(this);
        r3.addMouseListener(this);
        b2.addMouseListener(this);
        b1.addActionListener(this);
        r3.addActionListener(this);
        r4.addMouseListener(this);
    }

    private JRadioButton JRadioButton(String _Student_) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

        boolean isGradeSelected = r3.isSelected();

        if (isGradeSelected) {

            if (me.getSource() == EDIT) {
                try {
                    edit_grade g = new edit_grade();

                } catch (IOException ex) {
                    Logger.getLogger(choose.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            } else if (me.getSource() == b1) {
                setVisible(false);
                try {
                    Add h = new Add();
                    h.update.setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(choose.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            }

        }
        if (r2.isSelected()) {

            if (me.getSource() == EDIT) {
                try {
                    edit_subject g2 = new edit_subject();

                } catch (IOException ex) {
                    Logger.getLogger(choose.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            } else if (me.getSource() == b1) {
                setVisible(false);
                try {
                    AddSubject h2 = new AddSubject();
                    h2.btn_update.setVisible(false);

                } catch (IOException ex) {
                    Logger.getLogger(choose.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            }

        }
        if (r1.isSelected()) {

            if (me.getSource() == EDIT) {
                try {

                    search g1 = new search();

                } catch (IOException ex) {
                    Logger.getLogger(choose.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            } else if (me.getSource() == b1) {
                setVisible(false);

                try {
                    Student_add h1 = new Student_add();
                    h1.btn_update.setVisible(false);

                } catch (IOException ex) {
                    Logger.getLogger(choose.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            }

        }
        if (r4.isSelected()) {

            if (me.getSource() == EDIT) {
                try {
                    dep_edit g2 = new dep_edit();

                } catch (IOException ex) {
                    Logger.getLogger(choose.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            } else if (me.getSource() == b1) {
                setVisible(false);
                try {
                    dep_add h2 = new dep_add();
                    h2.update.setVisible(false);

                } catch (IOException ex) {
                    Logger.getLogger(choose.class.getName()).log(Level.SEVERE, null, ex);
                }
                setVisible(false);
            }

        }

        if (me.getSource() == b2) {
            setVisible(false);
            try {
                log p = new log();
            } catch (IOException ex) {
                Logger.getLogger(choose.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}
