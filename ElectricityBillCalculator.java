
import javax.swing.*;
import java.awt.*;

public class ElectricityBillCalculator extends JFrame {

    private JTextField nameField, idField, unitsField;
    private JTextArea billArea;

    private JButton calculateButton, clearButton, exitButton;

    public ElectricityBillCalculator() {

        setTitle("Electricity Bill Calculator");
        setSize(750, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        // Header
        JLabel heading = new JLabel(
            "ELECTRICITY BILL CALCULATOR", JLabel.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        heading.setOpaque(true);
        heading.setBackground(new Color(35, 55, 85));
        heading.setPreferredSize(new Dimension(750, 70));

        add(heading, BorderLayout.NORTH);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 12, 15));

        inputPanel.setBorder(
            BorderFactory.createTitledBorder("Consumer Details")
        );

        nameField = new JTextField();
        idField = new JTextField();
        unitsField = new JTextField();

        inputPanel.add(new JLabel("Consumer Name:"));
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Consumer ID:"));
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Units Consumed (kWh):"));
        inputPanel.add(unitsField);

        calculateButton = new JButton("Calculate Bill");
        clearButton = new JButton("Clear");

        inputPanel.add(calculateButton);
        inputPanel.add(clearButton);

        add(inputPanel, BorderLayout.NORTH);

        // Bill Display Area
        billArea = new JTextArea();
        billArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        billArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(billArea);

        JPanel billPanel = new JPanel(new BorderLayout());

        billPanel.setBorder(
            BorderFactory.createTitledBorder("Electricity Bill")
        );

        billPanel.add(scrollPane, BorderLayout.CENTER);

        add(billPanel, BorderLayout.CENTER);

        // Bottom Buttons
        JPanel bottomPanel = new JPanel();

        exitButton = new JButton("Exit");

        bottomPanel.add(exitButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button Actions
        calculateButton.addActionListener(e -> calculateBill());

        clearButton.addActionListener(e -> clearFields());

        exitButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    // Electricity Bill Calculation
    private void calculateBill() {

        String name = nameField.getText().trim();
        String id = idField.getText().trim();
        String unitsText = unitsField.getText().trim();

        if (name.isEmpty() || id.isEmpty() || unitsText.isEmpty()) {

            JOptionPane.showMessageDialog(
                this, "Please fill all fields!"
            );
            return;
        }

        try {

            double units = Double.parseDouble(unitsText);

            if (units < 0 || !Double.isFinite(units)) {
                JOptionPane.showMessageDialog(
                    this, "Please enter valid units!"
                );
                return;
            }

            // Slab-wise calculation
            double charge1 = Math.min(units, 100) * 3;

            double charge2 = Math.max(
                0, Math.min(units - 100, 100)
            ) * 5;

            double charge3 = Math.max(
                0, units - 200
            ) * 7;

            double fixedCharge = 50;

            double totalEnergyCharge =
                charge1 + charge2 + charge3;

            double totalBill =
                totalEnergyCharge + fixedCharge;

            // Generate Bill
            billArea.setText("");

            billArea.append(
                "========================================\n"
            );
            billArea.append(
                "          ELECTRICITY BILL              \n"
            );
            billArea.append(
                "========================================\n\n"
            );

            billArea.append("Consumer Name : " + name + "\n");
            billArea.append("Consumer ID   : " + id + "\n");
            billArea.append("Units Consumed: " + units + " kWh\n\n");

            billArea.append("----------------------------------------\n");
            billArea.append("          BILL BREAKDOWN                \n");
            billArea.append("----------------------------------------\n");

            billArea.append(
                String.format("First 100 Units    : Rs. %.2f%n",
                    charge1)
            );

            billArea.append(
                String.format("Next 100 Units     : Rs. %.2f%n",
                    charge2)
            );

            billArea.append(
                String.format("Above 200 Units    : Rs. %.2f%n",
                    charge3)
            );

            billArea.append(
                String.format("Fixed Charges      : Rs. %.2f%n",
                    fixedCharge)
            );

            billArea.append("----------------------------------------\n");

            billArea.append(
                String.format("Total Energy Charge: Rs. %.2f%n",
                    totalEnergyCharge)
            );

            billArea.append(
                String.format("TOTAL BILL         : Rs. %.2f%n",
                    totalBill)
            );

            billArea.append("----------------------------------------\n");
            billArea.append("\n     Thank You For Using Our Service!\n");

            JOptionPane.showMessageDialog(
                this, "Electricity Bill Calculated Successfully!"
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this, "Please enter a valid numeric value!"
            );
        }
    }

    // Clear Fields
    private void clearFields() {

        nameField.setText("");
        idField.setText("");
        unitsField.setText("");
        billArea.setText("");

        nameField.requestFocus();
    }

    // Main Method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
            new ElectricityBillCalculator()
        );
    }
}
