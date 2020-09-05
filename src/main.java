import Interface.Background.ContextBackground;
import Interface.Background.J1Background;
import Interface.Background.J2Background;
import Interface.Background.NeutreBackground;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        JFrame frame = buildFrame();

        //final BufferedImage image = ImageIO.read(new File("src\\Ressources\\Background\\J2.jpg"));

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
               // g.drawImage(image, 0, 0, null);
                ContextBackground background = new ContextBackground();

                NeutreBackground neutreBackground = new NeutreBackground();
                J1Background j1Background = new J1Background();
                J2Background j2Background = new J2Background();
                j2Background.dessinerBackground(background, g);
            }
        };


        frame.add(pane);
        frame.setVisible(true);
    }


    private static JFrame buildFrame() {
        JFrame frame = new JFrame("Hnefatafl");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        return frame;
    }

   /* public static void main(String[] args) {
        JFrame frame = new JFrame("Hnefatafl");
        Canvas canvas = new main();
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        //g.fillOval(100, 100, 200, 200);

        ContextBackground background = new ContextBackground();

        NeutreBackground neutreBackground = new NeutreBackground();
        J1Background j1Background = new J1Background();
        J2Background j2Background = new J2Background();
        j1Background.dessinerBackground(background, g);
    }

    public void keyReleased(KeyEvent e)
    {

    }*/
}