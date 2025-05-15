import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberReverser extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton reverseButton;
    private JLabel resultLabel;

    public NumberReverser() {
        setTitle("Number Reverser");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel enterLabel = new JLabel("Enter a number:");
        inputField = new JTextField(15);
        reverseButton = new JButton("Reverse");
        resultLabel = new JLabel("Reversed number will appear here");

        reverseButton.addActionListener(this);

        add(enterLabel);
        add(inputField);
        add(reverseButton);
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputText = inputField.getText();
        try {
            int number = Integer.parseInt(inputText);
            int reversed = reverseNumber(number);
            resultLabel.setText("Reversed Number: " + reversed);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid integer.");
        }
    }

    private int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberReverser::new);
    }
}
