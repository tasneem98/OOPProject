package projectoop;

import java.io.*;
import javax.swing.*;

public class begin extends JFrame {

    JLabel l1;
    JPanel p1 = new JPanel();
    private Boolean b;

    begin(boolean g) throws IOException {
        setUndecorated(true);
        setLocation(200, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(g);
        ImageIcon i = new ImageIcon("1.png");
        l1 = new JLabel(i);

        add(p1);
        p1.add(l1);
        pack();
    }
}
