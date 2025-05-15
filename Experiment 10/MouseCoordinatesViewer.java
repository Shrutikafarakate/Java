import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseCoordinatesViewer extends JFrame implements MouseMotionListener {
    JLabel coordinatesLabel;

    public MouseCoordinatesViewer() {
        setTitle("Mouse Coordinates Viewer");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        coordinatesLabel = new JLabel("Move the mouse...", SwingConstants.CENTER);
        coordinatesLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(coordinatesLabel, BorderLayout.CENTER);
        addMouseMotionListener(this);

        setVisible(true);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        coordinatesLabel.setText("X: " + e.getX() + "  |  Y: " + e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        coordinatesLabel.setText("Dragging at X: " + e.getX() + "  Y: " + e.getY());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseCoordinatesViewer::new);
    }
}
