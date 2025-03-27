package interfaces;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



public class DashboardUI {
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DashboardUI::new);
    }

    public DashboardUI() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("AirBlio - Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // 🎨 Header avec boutons de navigation
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        headerPanel.setBackground(new Color(50, 100, 255));
        headerPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JButton btnDemande = createStyledButton("📌 Demande d'intervention");
        JButton btnCompte = createStyledButton("👤 Mon compte");
        JButton btnHistorique = createStyledButton("📜 Historique");

        headerPanel.add(btnDemande);
        headerPanel.add(btnCompte);
        headerPanel.add(btnHistorique);

        // 🖼 Section de bienvenue
        JPanel welcomePanel = new JPanel(new GridLayout(1, 2));
        welcomePanel.setBackground(Color.BLACK);
        welcomePanel.setPreferredSize(new Dimension(frame.getWidth(), 250));

        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\Laria\\eclipse-workspace\\ProjetSIA\\image\\img1.jpg")); // Image de gauche
        JLabel welcomeText = new JLabel("<html><div style='color:white;padding:20px;'><h1>Bienvenue chez AirBlio</h1>\n" +
                "Nous mettons notre expertise à votre service pour vous proposer du matériel de qualité.<br>" +
                "AirBlio, c'est des interventions de qualité et rapides.</div></html>");
        welcomePanel.add(imageLabel);
        welcomePanel.add(welcomeText);

        // 🏗️ Section des matériaux (grid)
        JPanel materialsPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        materialsPanel.setBackground(Color.WHITE);

        String[] items = {"Palmes", "Lunettes", "Bouteilles", "Corde", "Bateau", "Sarbacane"};
        String[] images = {"palmes.jpg", "lunettes.jpg", "bouteilles.jpg", "corde.jpg", "bateau.jpg", "sarbacane.jpg"};

        for (int i = 0; i < items.length; i++) {
            JPanel itemPanel = new JPanel(new BorderLayout());
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
            JLabel imgLabel = new JLabel(new ImageIcon(images[i]));
            JLabel textLabel = new JLabel("<html><h2>" + items[i] + "</h2><p>Lorem ipsum dolor sit amet...</p></html>");
            textLabel.setHorizontalAlignment(SwingConstants.CENTER);
            itemPanel.add(imgLabel, BorderLayout.CENTER);
            itemPanel.add(textLabel, BorderLayout.SOUTH);
            materialsPanel.add(itemPanel);
        }

        // ✅ Footer avec bouton "Faire une demande d'intervention"
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.BLACK);
        footerPanel.setPreferredSize(new Dimension(frame.getWidth(), 80));

        JButton interventionButton = createStyledButton("📖 Faire une demande d'intervention");
        footerPanel.add(interventionButton);

        // 💡 Ajout des actions aux boutons
        btnDemande.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Ouverture de la page des demandes"));
        btnCompte.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Ouverture de la page Mon Compte"));
        btnHistorique.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Ouverture de l'historique"));
        interventionButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Formulaire de demande d'intervention"));

        // 🏗️ Ajout des sections au mainPanel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(welcomePanel, BorderLayout.CENTER);
        mainPanel.add(materialsPanel, BorderLayout.SOUTH);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    
    // 🖌️ Fonction pour créer un bouton stylisé
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(50, 100, 255));
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }
}
