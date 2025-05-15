import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterGUI extends JFrame implements ActionListener {
    private JTextField counterField;
    private JButton countUpButton, countDownButton, resetButton;
    private int count = 0;

    public CounterGUI() {
        setTitle("Counter");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Counter"));

        counterField = new JTextField("0", 10);
        counterField.setEditable(false);
        add(counterField);

        countUpButton = new JButton("Count Up");
        countDownButton = new JButton("Count Down");
        resetButton = new JButton("Reset");

        countUpButton.addActionListener(this);
        countDownButton.addActionListener(this);
        resetButton.addActionListener(this);

        add(countUpButton);
        add(countDownButton);
        add(resetButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countUpButton) {
            count++;
        } else if (e.getSource() == countDownButton) {
            count--;
        } else if (e.getSource() == resetButton) {
            count = 0;
        }
        counterField.setText(Integer.toString(count));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CounterGUI());
    }
}
