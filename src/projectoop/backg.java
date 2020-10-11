package projectoop;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class backg extends JPanel {

    BufferedImage img;

    backg(BufferedImage image) {
        this.img = image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        int w = getWidth();
        int h = getHeight();
        int iw = img.getWidth();
        int ih = img.getHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.min(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);

        g2.drawImage(img, 0, 0, width * 2, height * 2, this);
    }
}
