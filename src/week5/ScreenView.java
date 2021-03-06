import java.awt.geom.AffineTransform;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JFrame;

public class ScreenView implements RobotView {
    class Screen extends Canvas {
        Graphics gbuf;
        Image img;
        AffineTransform transform;
        int width, height;
        public Dimension getPreferredSize() { return new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT); }
        public void paint(Graphics g) {
            getOffscreenGraphics();
            g.drawImage(img, 0, 0, this);
            ((Graphics2D)g).setTransform(transform);
            ScreenView.this.paint(g);
        }
        public void update(Graphics g) { paint(g); }
        private void createOffscreenGraphics() {
            Dimension d = getSize();
            width = d.width;
            height = d.height;
            img = createImage(width, height);
            gbuf = img.getGraphics();
            gbuf.setColor(Color.black);
            gbuf.fillRect(0, 0, (int)width, (int)height);
        }
        private void setTransform() {
            transform = new AffineTransform();
            int half_width = (int)(width * 0.5),
                half_height = (int)(height * 0.5);
            transform.scale(1.0, -1.0);
            transform.translate(half_width, -half_height);
            ((Graphics2D) gbuf).setTransform(transform);
        }
        public void clear() {
            createOffscreenGraphics();
            setTransform();
            gbuf.setColor(getForeground());
        }
        private void resizeOffsetGraphics() {
            Image oldImg = img;
            int oldWidth = width, oldHeight = height;
            createOffscreenGraphics();
            gbuf.drawImage(oldImg,
                           (width - oldWidth) / 2,
                           (height - oldHeight) / 2, this);
            setTransform();
        }
        public Graphics getOffscreenGraphics() {
            Dimension d = getSize();
            if (gbuf == null) {
                clear(); 
            } else if (width != d.width || height != d.height) {
                resizeOffsetGraphics();
            }
            return gbuf;
        }
    }
    // ?????????Robot?????????????????????
    double x, y;    // ??????????????????
    double heading; // ??????(0???360)???0??????(???)???90??????(???)????????????

    // View???????????????    
    private Screen screen;
    // ??????
    private final static int SCREEN_WIDTH = 800, SCREEN_HEIGHT = 600;
    private final static double HEIGHT = 20.0;
    private final static double WIDTH = 15.0;
    private final long delayMillis = 10;
    private final Color penColor = Color.magenta;

    private Screen createScreen() {
        JFrame frame = new JFrame("Robot");
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
        Screen screen = new Screen();
        screen.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        frame.getContentPane().add(screen);
        frame.pack();
        frame.setVisible(true);
        return screen;
    }

    ScreenView() {
        this.screen = createScreen();
    }
    private int round(double d) { return (int) (d + 0.5); }
    private void drawLine(Graphics g, double oldX, double oldY, double newX, double newY) {
        g.drawLine(round(oldX), round(oldY), round(newX), round(newY));
    }
    private void drawLine(double oldX, double oldY, double newX, double newY) {
        // ??????????????????????????????????????????????????????
        Graphics g = screen.getOffscreenGraphics();
        g.setColor(penColor);
        drawLine(g, oldX, oldY, newX, newY);
    }

    private void requestUpdate() {
        // ???????????????????????????????????????
        screen.repaint();
        // ??????????????????????????????
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
        }
    }
    public void clear() { screen.clear(); }
    public void turn(double oldHeading, double newHeading) {
        heading = newHeading;
        requestUpdate();
    }
    public void move(double oldX, double oldY,
                     double newX, double newY) {
        drawLine(oldX, oldY, newX, newY);
        x = newX;
        y = newY;
        requestUpdate();
    }

    // ??????????????????????????????HEIGHT, ???WIDTH, ?????????heading???????????????????????????????????????(x, y)???
    public void paint(Graphics g) {
        double radian = heading / 180.0 * Math.PI;
        double sine = Math.sin(radian), cosine = Math.cos(radian),
            head_x = x + cosine * HEIGHT,     head_y = y + sine * HEIGHT,
            right_x = x + sine * WIDTH * 0.5, right_y = y - cosine * WIDTH * 0.5,
            left_x = x - sine * WIDTH * 0.5,  left_y = y + cosine * WIDTH * 0.5;
        g.setColor(Color.green);
        drawLine(g, head_x, head_y, right_x, right_y);
        drawLine(g, head_x, head_y, left_x,  left_y);
        drawLine(g, left_x, left_y, right_x, right_y);
    }
}
