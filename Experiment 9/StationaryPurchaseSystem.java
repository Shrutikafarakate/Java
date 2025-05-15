import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StationaryPurchaseSystem extends JFrame implements ActionListener {
    JCheckBox cbNotebook, cbPen, cbPencil;
    JButton btnOrder;

    public StationaryPurchaseSystem() {
        setTitle("Stationary Purchase System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        cbNotebook = new JCheckBox("Notebook @ 50");
        cbPen = new JCheckBox("Pen @ 30");
        cbPencil = new JCheckBox("Pencil @ 10");

        btnOrder = new JButton("Order");
        btnOrder.addActionListener(this);

        add(new JLabel("Stationary Purchase System"));
        add(cbNotebook);
        add(cbPen);
        add(cbPencil);
        add(btnOrder);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double total = 0.0;
        StringBuilder message = new StringBuilder();

        if (cbNotebook.isSelected()) {
            String input = JOptionPane.showInputDialog(this, "Enter Quantity for Notebook");
            int qty = Integer.parseInt(input);
            double price = qty * 50;
            total += price;
            message.append("Notebook Quantity: ").append(qty).append("  Total:").append(price).append("\n");
        }

        if (cbPen.isSelected()) {
            String input = JOptionPane.showInputDialog(this, "Enter Quantity for Pen");
            int qty = Integer.parseInt(input);
            double price = qty * 30;
            total += price;
            message.append("Pen Quantity: ").append(qty).append("  Total:").append(price).append("\n");
        }

        if (cbPencil.isSelected()) {
            String input = JOptionPane.showInputDialog(this, "Enter Quantity for Pencil");
            int qty = Integer.parseInt(input);
            double price = qty * 10;
            total += price;
            message.append("Pencil Quantity: ").append(qty).append("  Total:").append(price).append("\n");
        }

        message.append("------------------------\n");
        message.append("Total: ").append(total);

        if (total > 0) {
            JOptionPane.showMessageDialog(this, message.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Successfully Ordered.", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select at least one item.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StationaryPurchaseSystem::new);
    }
}
