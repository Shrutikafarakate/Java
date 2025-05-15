import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberConverter extends JFrame implements ActionListener {
    private JTextField inputField, resultField;
    private JButton binaryButton, octalButton, hexButton;

    public NumberConverter() {
        setTitle("Number Converter");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter the number"));
        inputField = new JTextField(10);
        inputPanel.add(inputField);
        add(inputPanel, BorderLayout.NORTH);

       
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        binaryButton = new JButton("Binary");
        octalButton = new JButton("Octal");
        hexButton = new JButton("Hex");

        binaryButton.addActionListener(this);
        octalButton.addActionListener(this);
        hexButton.addActionListener(this);

        buttonPanel.add(binaryButton);
        buttonPanel.add(octalButton);
        buttonPanel.add(hexButton);
        add(buttonPanel, BorderLayout.CENTER);

        
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.add(new JLabel("Result"));
        resultField = new JTextField(15);
        resultField.setEditable(false);
        resultPanel.add(resultField);
        add(resultPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int number = Integer.parseInt(inputField.getText());
            if (e.getSource() == binaryButton) {
                resultField.setText(Integer.toBinaryString(number));
            } else if (e.getSource() == octalButton) {
                resultField.setText(Integer.toOctalString(number));
            } else if (e.getSource() == hexButton) {
                resultField.setText(Integer.toHexString(number).toUpperCase());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NumberConverter().setVisible(true));
    }
}
