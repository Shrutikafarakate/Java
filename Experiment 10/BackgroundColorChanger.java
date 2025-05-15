import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BackgroundColorChanger {
    private JFrame frame;
    private JComboBox<String> colorComboBox;

    public BackgroundColorChanger() {
        frame = new JFrame("Background Color Changer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        String[] colors = {"Select Color", "Red", "Green", "Blue", "Yellow", "Orange"};
        colorComboBox = new JComboBox<>(colors);
        frame.add(colorComboBox);

        colorComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                changeBackgroundColor(selectedColor);
            }
        });

        frame.setVisible(true);
    }

    private void changeBackgroundColor(String selectedColor) {
        switch (selectedColor) {
            case "Red":
                frame.getContentPane().setBackground(Color.RED);
                break;
            case "Green":
                frame.getContentPane().setBackground(Color.GREEN);
                break;
            case "Blue":
                frame.getContentPane().setBackground(Color.BLUE);
                break;
            case "Yellow":
                frame.getContentPane().setBackground(Color.YELLOW);
                break;
            case "Orange":
                frame.getContentPane().setBackground(Color.ORANGE);
                break;
            default:
                frame.getContentPane().setBackground(UIManager.getColor("control"));
        }
    }

    public static void main(String[] args) {
        new BackgroundColorChanger();
    }
}
