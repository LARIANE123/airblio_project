package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginUI {
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginUI().createAndShowGUI());
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Connexion - AIRBLIO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(200, 230, 250));
        
        JLabel title = new JLabel("AIRBLIO", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(new Color(30, 136, 229));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(new Color(33, 150, 243));
        loginPanel.setPreferredSize(new Dimension(400, 300));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0;
        loginPanel.add(emailLabel, gbc);
        
        JTextField emailField = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 1;
        loginPanel.add(emailField, gbc);
        
        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 2;
        loginPanel.add(passwordLabel, gbc);
        
        JPasswordField passwordField = new JPasswordField(20);
        gbc.gridx = 0; gbc.gridy = 3;
        loginPanel.add(passwordField, gbc);
        
        JButton loginButton = new JButton("Se connecter");
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(new Color(33, 150, 243));
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 4;
        loginPanel.add(loginButton, gbc);
        
        JLabel forgotPassword = new JLabel("Mot de passe oublié ?");
        forgotPassword.setForeground(Color.WHITE);
        forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0; gbc.gridy = 5;
        loginPanel.add(forgotPassword, gbc);
        
        JButton registerButton = new JButton("Créer un compte");
        registerButton.setBackground(new Color(255, 255, 255));
        registerButton.setForeground(new Color(33, 150, 243));
        registerButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 6;
        loginPanel.add(registerButton, gbc);
        
        mainPanel.add(loginPanel, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setVisible(true);

        // Action listener pour le bouton "Se connecter"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupération des identifiants saisis par l'utilisateur
                String email = emailField.getText();
                char[] password = passwordField.getPassword();

                // Vérification dans la base de données
                if (checkLogin(email, new String(password))) {
                    // Si les identifiants sont corrects, fermer la fenêtre de connexion
                    frame.dispose();

                    // Ouvrir le DashboardUI
                    openDashboard();
                } else {
                    JOptionPane.showMessageDialog(frame, "Identifiants incorrects. Veuillez réessayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Méthode pour vérifier les identifiants dans la base de données
    private boolean checkLogin(String email, String password) {
        Connection conn;
        String sql = "SELECT * FROM clients WHERE email = ? AND mdp = ?";
        PreparedStatement statement;
        
		try {
			conn = BD.DBconnection.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, email);
	        statement.setString(2, password); // En réalité, il est préférable de comparer le mot de passe haché
	        ResultSet resultSet = statement.executeQuery();

	        // Si un utilisateur est trouvé avec les identifiants, retourner vrai
	        return resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return false;
    }

    // Méthode pour ouvrir le DashboardUI
    private void openDashboard() {
        // Créer et afficher le dashboard
        SwingUtilities.invokeLater(() -> new DashboardUI());
    }
}
