import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TicketSalesGUI extends JFrame implements ActionListener {
    private JComboBox<String> boatComboBox;
    private JTextField totalMembersField;
    private JButton generateNameFieldsButton, addButton, viewButton, cancelButton;
    private JPanel memberNamesPanel;
    private JScrollPane memberNamesScrollPane, scrollPane;
    private List<JTextField> memberNameFields;
    private JTable ticketsTable;
    private DefaultTableModel tableModel;
    private List<BoatTicket> boatTickets;
    private Map<String, Integer> boatCapacities;
    private Map<String, Integer> boatSeatsAvailable;

    public TicketSalesGUI() {
        super("Boat Ticket Sales System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initializeBoatData();
        boatTickets = new ArrayList<>();
        createUIComponents();
        setupLayout();
        setVisible(true);
    }

    private void initializeBoatData() {
        boatCapacities = new HashMap<>();
        boatCapacities.put("Discovery(seats:12)", 12);
        boatCapacities.put("Voyager(seats:10)", 10);
        boatCapacities.put("Explorer(seats:5)", 5);
        boatCapacities.put("Pioneer(seats:2)", 2);
        boatCapacities.put("Navigator(seats:8)", 8);

        boatSeatsAvailable = new HashMap<>();
        boatSeatsAvailable.put("Discovery(seats:12)", 12);
        boatSeatsAvailable.put("Voyager(seats:10)", 10);
        boatSeatsAvailable.put("Explorer(seats:5)", 5);
        boatSeatsAvailable.put("Pioneer(seats:2)", 2);
        boatSeatsAvailable.put("Navigator(seats:8)", 8);
    }

    private void createUIComponents() {
        boatComboBox = new JComboBox<>(boatCapacities.keySet().toArray(new String[0]));
        totalMembersField = new JTextField(5);
        
        generateNameFieldsButton = new JButton("Generate Name Fields");
        addButton = new JButton("Add Ticket");
        viewButton = new JButton("View Tickets");
        cancelButton = new JButton("Cancel Ticket");
        
        // Customize button colors
        Color buttonColor = new Color(0, 123, 255); // Blue color
        generateNameFieldsButton.setBackground(buttonColor);
        generateNameFieldsButton.setForeground(Color.WHITE);
        generateNameFieldsButton.setFont(new Font("Arial", Font.BOLD, 14));

        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.BOLD, 14));

        viewButton.setBackground(buttonColor);
        viewButton.setForeground(Color.WHITE);
        viewButton.setFont(new Font("Arial", Font.BOLD, 14));

        cancelButton.setBackground(new Color(220, 53, 69)); // Red color
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Larger member names panel
        memberNamesPanel = new JPanel();
        memberNamesPanel.setLayout(new BoxLayout(memberNamesPanel, BoxLayout.Y_AXIS));
        memberNamesScrollPane = new JScrollPane(memberNamesPanel);
        memberNamesScrollPane.setPreferredSize(new Dimension(300, 200));
        memberNamesScrollPane.setBorder(BorderFactory.createTitledBorder("Enter Member Names"));
        memberNameFields = new ArrayList<>();

        String[] columnNames = {"Boat", "Total Members", "Member Names", "Payment Method"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        ticketsTable = new JTable(tableModel);
        ticketsTable.getColumnModel().getColumn(2).setCellRenderer(new MultiLineCellRenderer());
        scrollPane = new JScrollPane(ticketsTable);

        generateNameFieldsButton.addActionListener(this);
        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }
    
    private void setupLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(new Color(248, 248, 248));
        
        // Input panel (top)
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(new Color(248, 248, 248));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        // Boat selection
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(new JLabel("Boat:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        inputPanel.add(boatComboBox, gbc);
    
        // Available seats label
        gbc.gridx = 3; gbc.gridy = 0; gbc.gridwidth = 1;
        JLabel availableSeatsLabel = new JLabel("Available Seats: " + boatSeatsAvailable.get(boatComboBox.getSelectedItem()));
        inputPanel.add(availableSeatsLabel, gbc);
    
        // Members input
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        inputPanel.add(new JLabel("Total Members:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.1;
        inputPanel.add(totalMembersField, gbc);
        gbc.gridx = 2; gbc.weightx = 0.9;
        inputPanel.add(generateNameFieldsButton, gbc);
    
        // Member names panel
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3; 
        gbc.weighty = 0.5; gbc.fill = GridBagConstraints.BOTH;
        inputPanel.add(memberNamesScrollPane, gbc);
    
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(248, 248, 248));
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(cancelButton);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 3; 
        gbc.weighty = 0; gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(buttonPanel, gbc);
    
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    
        add(mainPanel);
    
        // Update available seats whenever boat selection changes
        boatComboBox.addActionListener(e -> {
            String selectedBoat = (String) boatComboBox.getSelectedItem();
            int availableSeats = boatSeatsAvailable.get(selectedBoat);
            availableSeatsLabel.setText("Available Seats: " + availableSeats);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateNameFieldsButton) {
            generateMemberNameFields();
        } else if (e.getSource() == addButton) {
            addTicket();
        } else if (e.getSource() == viewButton) {
            displayTicketsInTable();
        } else if (e.getSource() == cancelButton) {
            cancelTicket();
        }
    }

    private void generateMemberNameFields() {
        try {
            // Get the selected boat and its capacity
            String selectedBoat = (String) boatComboBox.getSelectedItem();
            int boatCapacity = boatCapacities.get(selectedBoat);

            // Ensure the entered number of members does not exceed the boat's capacity
            int numberOfMembers = Integer.parseInt(totalMembersField.getText().trim());
            if (numberOfMembers <= 0 || numberOfMembers > boatCapacity) {
                throw new NumberFormatException();
            }

            memberNamesPanel.removeAll();
            memberNameFields.clear();

            // Generate name fields based on the boat's capacity
            for (int i = 0; i < numberOfMembers; i++) {
                JTextField nameField = new JTextField();
                nameField.setPreferredSize(new Dimension(250, 40));  // Wider and taller
                nameField.setMaximumSize(new Dimension(Short.MAX_VALUE, 40)); // Height control
                nameField.setFont(new Font("Arial", Font.PLAIN, 16)); // Optional: larger font
                nameField.setBorder(BorderFactory.createTitledBorder("Member " + (i + 1)));

                memberNameFields.add(nameField);
                memberNamesPanel.add(nameField);
                memberNamesPanel.add(Box.createVerticalStrut(5));
            }

            memberNamesPanel.revalidate();
            memberNamesPanel.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for Total Members, not exceeding the boat capacity.", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addTicket() {
        try {
            String selectedBoat = (String) boatComboBox.getSelectedItem();
            if (selectedBoat == null) throw new Exception("Please select a boat.");
            
            int numberOfMembers = Integer.parseInt(totalMembersField.getText().trim());
            if (numberOfMembers <= 0) throw new Exception("Total Members must be positive.");
            
            if (memberNameFields.size() != numberOfMembers) {
                throw new Exception("Number of name fields doesn't match Total Members.");
            }
            
            List<String> memberNames = new ArrayList<>();
            for (JTextField field : memberNameFields) {
                String name = field.getText().trim();
                if (name.isEmpty()) throw new Exception("Please fill in all member names.");
                memberNames.add(name);
            }
            
            int capacity = boatCapacities.get(selectedBoat);
            if (numberOfMembers > capacity) {
                throw new Exception("Exceeds boat capacity (" + capacity + ").");
            }

            // Check if there are enough available seats
            if (boatSeatsAvailable.get(selectedBoat) < numberOfMembers) {
                throw new Exception("Not enough available seats.");
            }

            // Update available seats after booking
            boatSeatsAvailable.put(selectedBoat, boatSeatsAvailable.get(selectedBoat) - numberOfMembers);

            // Show payment dialog
            PaymentDialog paymentDialog = new PaymentDialog(this, numberOfMembers);
            paymentDialog.setVisible(true);
            
            if (!paymentDialog.isPaymentSuccess()) {
                throw new Exception("Payment not completed.");
            }
            
            String boatName = selectedBoat;
            BoatTicket ticket = new BoatTicket(
                boatName, numberOfMembers, memberNames,
                true, paymentDialog.getPaymentMethod()
            );
            
            boatTickets.add(ticket);
            saveTicketToFile(ticket); // Save to file

            // Clear inputs
            totalMembersField.setText("");
            memberNamesPanel.removeAll();
            memberNameFields.clear();
            memberNamesPanel.revalidate();
            memberNamesPanel.repaint();
            
            JOptionPane.showMessageDialog(this, 
                "Ticket added successfully!\nPayment Method: " + ticket.getPaymentMethod(),
                "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayTicketsInTable() {
        tableModel.setRowCount(0);
        
        for (BoatTicket ticket : boatTickets) {
            tableModel.addRow(new Object[] {
                ticket.getBoatName(),
                ticket.getNumberOfMembers(),
                String.join(", ", ticket.getMemberNames()),
                ticket.getPaymentMethod()
            });
        }
    }

    private void saveTicketToFile(BoatTicket ticket) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tickets.txt", true))) {
            writer.write(ticket.toString() + "\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error saving ticket to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rewriteTicketsFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tickets.txt"))) {
            for (BoatTicket ticket : boatTickets) {
                writer.write(ticket.toString() + "\n");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error updating tickets file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelTicket() {
        if (boatTickets.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No tickets to cancel.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Create a dialog to select which ticket to cancel
        String[] ticketOptions = boatTickets.stream()
            .map(t -> t.getBoatName() + " (" + t.getNumberOfMembers() + " members)")
            .toArray(String[]::new);

        String selected = (String) JOptionPane.showInputDialog(
            this,
            "Select ticket to cancel:",
            "Cancel Ticket",
            JOptionPane.QUESTION_MESSAGE,
            null,
            ticketOptions,
            ticketOptions[0]);

        if (selected != null) {
            int index = -1;
            for (int i = 0; i < ticketOptions.length; i++) {
                if (ticketOptions[i].equals(selected)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                BoatTicket cancelledTicket = boatTickets.get(index);
                
                // Return the seats to available count
                String boatName = cancelledTicket.getBoatName();
                int members = cancelledTicket.getNumberOfMembers();
                boatSeatsAvailable.put(boatName, boatSeatsAvailable.get(boatName) + members);
                
                // Remove the ticket
                boatTickets.remove(index);
                
                // Rewrite the tickets file without the cancelled ticket
                rewriteTicketsFile();
                
                // Update the table
                displayTicketsInTable();
                
                JOptionPane.showMessageDialog(this, 
                    "Ticket cancelled successfully!\n" + members + " seats returned to " + boatName,
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicketSalesGUI());
    }
}

class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
    public MultiLineCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}