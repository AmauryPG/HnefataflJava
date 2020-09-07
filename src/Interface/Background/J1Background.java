package Interface.Background;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class J1Background implements EtatBackground {
    @Override
    public JPanel dessinerBackground(ContextBackground context) {
        JPanel panel;

            panel = new JPanel() {

                @Override
                protected void paintComponent(Graphics g) {
                    BufferedImage image = null;
                    try {
                        image = ImageIO.read(new File(path + "J1.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g.drawImage(image, 0, 0,null);

                }
            };
            context.setEtat(this);

            return panel;
    }
}
