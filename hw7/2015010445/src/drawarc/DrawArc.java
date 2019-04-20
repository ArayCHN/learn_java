package drawarc;
import java.awt.*;
import javax.swing.*;
public class DrawArc extends JFrame {
    public class paintingWindow extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            g.fillRect(290, 300, 20, 250);
            g.setColor(Color.BLUE);
            g.fillArc(150, 150, 300, 300, 30, 30);
            g.fillArc(150, 150, 300, 300, 120, 30);
            g.fillArc(150, 150, 300, 300, -150, 30);
            g.fillArc(150, 150, 300, 300, -60, 30);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Monospaced", Font.PLAIN, 24));
            g.drawString("Gone with the wind", 20, 550);
        }
    }
    public DrawArc() {
        JFrame frame = new JFrame("DrawArc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.add(new paintingWindow());
    }
    public static void main(String[] args) {
        DrawArc app = new DrawArc();
    }
}
