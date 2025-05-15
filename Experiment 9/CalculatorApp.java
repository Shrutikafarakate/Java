import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField display;
    private String operator = "";
    private double num1 = 0;

    public CalculatorApp() {
        setTitle("Standard Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Buttons panel
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "C", "√", "x²", "x³",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "%", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.matches("[0-9]")) {
                display.setText(display.getText() + command);
            } else if (command.matches("[+\\-*/%]")) {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                display.setText("");
            } else if (command.equals("=")) {
                double num2 = Double.parseDouble(display.getText());
                double result = switch (operator) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num2 != 0 ? num1 / num2 : Double.NaN;
                    case "%" -> num1 % num2;
                    default -> 0;
                };
                display.setText(new DecimalFormat("#.##").format(result));
                operator = "";
            } else if (command.equals("C")) {
                display.setText("");
                num1 = 0;
                operator = "";
            } else if (command.equals("√")) {
                double val = Double.parseDouble(display.getText());
                display.setText(new DecimalFormat("#.##").format(Math.sqrt(val)));
            } else if (command.equals("x²")) {
                double val = Double.parseDouble(display.getText());
                display.setText(new DecimalFormat("#.##").format(val * val));
            } else if (command.equals("x³")) {
                double val = Double.parseDouble(display.getText());
                display.setText(new DecimalFormat("#.##").format(val * val * val));
            }
        } catch (NumberFormatException ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorApp::new);
    }
}
