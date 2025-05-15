import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GenderSelection extends JFrame implements ActionListener {
    private JRadioButton maleButton, femaleButton, otherButton;
    private JButton submitButton;
    private JLabel resultLabel;

    public GenderSelection() {
        setTitle("Gender Selection");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel questionLabel = new JLabel("Select your gender:");

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        otherButton = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup(); // Group to ensure only one is selected
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        resultLabel = new JLabel("Your selected gender will appear here.");

        // Add components to frame
        add(questionLabel);
        add(maleButton);
        add(femaleButton);
        add(otherButton);
        add(submitButton);
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (maleButton.isSelected()) {
            resultLabel.setText("Selected Gender: Male");
        } else if (femaleButton.isSelected()) {
            resultLabel.setText("Selected Gender: Female");
        } else if (otherButton.isSelected()) {
            resultLabel.setText("Selected Gender: Other");
        } else {
            resultLabel.setText("Please select a gender.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GenderSelection::new);
    }
}
