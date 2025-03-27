package interfaces;
import javax.swing.*;
import java.awt.*;

public class ModernInterventionForm {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Création d'intervention");
            frame.setSize(600, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            panel.setBackground(new Color(230, 240, 250));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 0;

            JLabel titleLabel = new JLabel("Création d'intervention", JLabel.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            titleLabel.setForeground(new Color(50, 50, 150));
            gbc.gridwidth = 2;
            panel.add(titleLabel, gbc);

            gbc.gridy++;
            gbc.gridwidth = 1;
            panel.add(new JLabel("Client :"), gbc);
            gbc.gridx = 1;
            JTextField clientField = new JTextField(20);
            styleTextField(clientField);
            panel.add(clientField, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            panel.add(new JLabel("Date d'intervention :"), gbc);
            gbc.gridx = 1;
            JTextField dateField = new JTextField(20);
            styleTextField(dateField);
            panel.add(dateField, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            panel.add(new JLabel("Matériel utilisé :"), gbc);
            gbc.gridx = 1;
            JTextField materielField = new JTextField(20);
            styleTextField(materielField);
            panel.add(materielField, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            panel.add(new JLabel("Descriptions :"), gbc);
            gbc.gridx = 1;
            JTextArea descriptionArea = new JTextArea(3, 20);
            JScrollPane scrollPane = new JScrollPane(descriptionArea);
            styleTextArea(descriptionArea);
            panel.add(scrollPane, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = 2;
            JButton validateButton = new JButton("Valider");
            styleButton(validateButton);
            panel.add(validateButton, gbc);

            gbc.gridy++;
            JButton homeButton = new JButton("Retour à l'accueil");
            styleButton(homeButton);
            panel.add(homeButton, gbc);

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    private static void styleTextField(JTextField field) {
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 200), 2));
    }

    private static void styleTextArea(JTextArea area) {
        area.setFont(new Font("Arial", Font.PLAIN, 14));
        area.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 200), 2));
    }

    private static void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(50, 50, 150));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }
}
