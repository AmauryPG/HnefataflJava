import Interface.Background.ContextBackground;
import Interface.Background.J1Background;
import Interface.Background.J2Background;
import Interface.Background.NeutreBackground;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class main {

   /* public static void main(String args[]) {
        JFrame frame = new JFrame("Key Listener");
        Container contentPane = frame.getContentPane();
        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent event) {
                printEventInfo("Key Pressed", event);
            }
            @Override
            public void keyReleased(KeyEvent event) {
                printEventInfo("Key Released", event);
            }
            @Override
            public void keyTyped(KeyEvent event) {
                printEventInfo("Key Typed", event);
            }
            private void printEventInfo(String str, KeyEvent e) {
                System.out.println(str);
                int code = e.getKeyCode();
                System.out.println("   Code: " + KeyEvent.getKeyText(code));
                System.out.println("   Char: " + e.getKeyChar());
                int mods = e.getModifiersEx();
                System.out.println("    Mods: "
                        + KeyEvent.getModifiersExText(mods));
                System.out.println("    Location: "
                        + keyboardLocation(e.getKeyLocation()));
                System.out.println("    Action? " + e.isActionKey());
            }
            private String keyboardLocation(int keybrd) {
                switch (keybrd) {
                    case KeyEvent.KEY_LOCATION_RIGHT:
                        return "Right";
                    case KeyEvent.KEY_LOCATION_LEFT:
                        return "Left";
                    case KeyEvent.KEY_LOCATION_NUMPAD:
                        return "NumPad";
                    case KeyEvent.KEY_LOCATION_STANDARD:
                        return "Standard";
                    case KeyEvent.KEY_LOCATION_UNKNOWN:
                    default:
                        return "Unknown";
                }
            }
        };
        JTextField textField = new JTextField();
        textField.addKeyListener(listener);
        contentPane.add(textField, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }*/

    static int i = 0;
    static JPanel pane = null;
    static NeutreBackground neutreBackground = new NeutreBackground();
    static J1Background j1Background = new J1Background();
    static J2Background j2Background = new J2Background();
    static ContextBackground background = new ContextBackground();
    static boolean tour = false;

    public static void main(String[] args) throws IOException, InterruptedException {
        JFrame frame = buildFrame();
        boolean tour = false;

        //final BufferedImage image = ImageIO.read(new File("src\\Ressources\\Background\\J2.jpg"));

        pane = neutreBackground.dessinerBackground(background);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                BackgroundTour();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                BackgroundTourChange();
            }
        });

        frame.add(pane);
        frame.setVisible(true);

        while(true)
        {

            frame.remove(pane);
            frame.add(pane);
            frame.revalidate();
            sleep(50);
        }
    }

    private static JFrame buildFrame() {
        JFrame frame = new JFrame("Hnefatafl");


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        return frame;
    }

    public static void BackgroundTour()
    {
        if(tour)
        {
            BackgroundJ1();
        }
        else
        {
            BackgroundJ2();
        }
    }

    public static void BackgroundTourChange()
    {
        tour = !tour;
    }

    public static void BackgroundNeutre()
    {
        pane = neutreBackground.dessinerBackground(background);
    }

    public static void BackgroundJ1()
    {
        pane = j1Background.dessinerBackground(background);
    }

    public static void BackgroundJ2()
    {
        pane = j2Background.dessinerBackground(background);
    }
}