import java.awt.*;
import java.awt.geom.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Вращение отрезка вокруг точки");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setContentPane(new SegmentRotation());
        jFrame.setVisible(true);
    }
    //Класс описывает вращение отрезка
    static class SegmentRotation extends JPanel {
        private AffineTransform transforms;

        private SegmentRotation() {
            Timer timer = new Timer();
            timer.schedule(new MyTimerTask(), 0, 1);
        }

        private class MyTimerTask extends TimerTask {
            int i = 0;

            @Override
            public void run() {
                transforms = AffineTransform.getRotateInstance(i++ * 0.001, 400 / 2, 400 / 2);
                repaint();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.transform(transforms);
            g2d.draw(new Line2D.Float(400 / 3, 400 / 3, 400 / 2, 400 / 2));
        }
    }
}