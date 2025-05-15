import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBallPanel extends JPanel implements MouseListener, Runnable {
    private int x = 50, y = 50;         
    private int dx = 2, dy = 3;        
    private final int DIAMETER = 30;    
   private boolean running = false;    
    public BouncingBallPanel() {
        setBackground(Color.WHITE);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    @Override
    public void run() {
        while (running) {
         
            x += dx;
            y += dy;

           
            if (x < 0 || x + DIAMETER > getWidth()) {
                dx = -dx;
            }
            if (y < 0 || y + DIAMETER > getHeight()) {
                dy = -dy;
            }

            repaint();

            try {
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!running) {
            running = true;
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

   
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Blue Ball");
        BouncingBallPanel panel = new BouncingBallPanel();
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
