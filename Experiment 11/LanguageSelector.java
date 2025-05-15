import javax.swing.*;
import java.awt.*;

public class LanguageSelector extends JFrame {

    public LanguageSelector() {
        setTitle("FlowLayout Example");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        
        JCheckBox javaCheckBox = new JCheckBox("Java");
        JCheckBox pythonCheckBox = new JCheckBox("Python");
        JCheckBox cppCheckBox = new JCheckBox("C++");

        
        add(javaCheckBox);
        add(pythonCheckBox);
        add(cppCheckBox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LanguageSelector().setVisible(true));
    }
}
