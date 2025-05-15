import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextAreaCounterApp {
    private JFrame frame;
    private JTextArea textArea;
    private JLabel countLabel;

    public TextAreaCounterApp() {
        frame = new JFrame("Text Area Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        countLabel = new JLabel("Characters: 0 | Words: 0");
        frame.add(countLabel, BorderLayout.SOUTH);

        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateCount();
            }
        });

        frame.setVisible(true);
    }

    private void updateCount() {
        String text = textArea.getText();

        int characterCount = text.length();
        int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;

        countLabel.setText("Characters: " + characterCount + " | Words: " + wordCount);
    }

    public static void main(String[] args) {
        new TextAreaCounterApp();
    }
}
