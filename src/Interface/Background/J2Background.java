package Interface.Background;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class J2Background implements EtatBackground {
    @Override
    public Graphics dessinerBackground(ContextBackground context, Graphics g) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(path + "J2.jpg"));

            g.drawImage(image, 0, 0,null);

            context.setEtat(this);

            return g;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
