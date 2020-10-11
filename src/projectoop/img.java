package projectoop;

import java.awt.Image;
import javax.swing.ImageIcon;

public class img {

    ImageIcon imgg(ImageIcon m) {
        Image image = m.getImage();
        Image newimg = image.getScaledInstance(120 / 4, 120 / 4, java.awt.Image.SCALE_FAST);
        m = new ImageIcon(newimg);
        return m;
    }

}
