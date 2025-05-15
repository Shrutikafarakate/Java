import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridSwapDemo extends JFrame implements ActionListener {

    private JButton[] buttons = new JButton[6];
    private int lastClickedIndex = -1; // to track the last clicked button

    public GridSwapDemo() {
        setTitle("GridLayout Swap Example");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 3)); // 2 rows, 3 columns


        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        // Find index of clicked button
        int currentIndex = -1;
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i] == clicked) {
                currentIndex = i;
                break;
            }
        }

              if (lastClickedIndex != -1 && currentIndex != lastClickedIndex) {
            String temp = buttons[currentIndex].getText();
            buttons[currentIndex].setText(buttons[lastClickedIndex].getText());
            buttons[lastClickedIndex].setText(temp);
            lastClickedIndex = -1; // reset
        } else {
            lastClickedIndex = currentIndex; // store first click
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GridSwapDemo().setVisible(true));
    }
}
