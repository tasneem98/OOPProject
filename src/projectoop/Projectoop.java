package projectoop;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.logging.*;

public class Projectoop {

    // main method
    public static void main(String[] args) throws IOException {

        // showing the beginning form 
        boolean o = true;
        begin g = new begin(o);
        Timer t;
        t = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                g.setVisible(false);
                try {
                    //showing the log in form

                    log h = new log();
                } catch (IOException ex) {
                    Logger.getLogger(Projectoop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.setRepeats(false);
        t.start();
    }
}
