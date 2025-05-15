import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="FactorialApplet" width=300 height=200>
</applet>
*/

public class FactorialApplet extends Applet implements ActionListener {

    Label label;
    TextField inputField, resultField;
    Button computeButton;

    public void init() {
        label = new Label("Enter a number:");
        inputField = new TextField(10);
        resultField = new TextField(15);
        resultField.setEditable(false);
        computeButton = new Button("Find Factorial");

        add(label);
        add(inputField);
        add(computeButton);
        add(new Label("Factorial:"));
        add(resultField);

        computeButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(inputField.getText());
            long fact = 1;
            for (int i = 2; i <= num; i++) {
                fact *= i;
            }
            resultField.setText(String.valueOf(fact));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input!");
        }
    }
}
