import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class ImageSelectorGUI extends JFrame implements ItemListener {

    private JComboBox<String> imageComboBox;
    private JLabel imageLabel;
    private String[] imageNames = { "nature.png", "bird.png", "flower.png" }; 
    private final String imagePath = "images" + File.separator;

    public ImageSelectorGUI() {
        setTitle("Image Selector");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        imageComboBox = new JComboBox<>(imageNames);
        imageComboBox.addItemListener(this);

        
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        
        loadImage(imageNames[0]);

        add(imageComboBox, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void loadImage(String imageName) {
        File imageFile = new File(imagePath + imageName);
        if (imageFile.exists()) {
            ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
            Image scaledImage = icon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
            imageLabel.setText(""); 
        } else {
            imageLabel.setText("Image not found: " + imageFile.getPath());
            imageLabel.setIcon(null);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedImage = (String) imageComboBox.getSelectedItem();
            loadImage(selectedImage);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageSelectorGUI::new);
    }
}
