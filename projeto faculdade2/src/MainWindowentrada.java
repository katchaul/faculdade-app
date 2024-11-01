import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowentrada extends JFrame {
    private boolean darkMode = true; // Estado inicial no modo escuro

    public MainWindowentrada() {
        // Configurações da janela principal
        setTitle("Portal");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Inicializa o layout no modo escuro
        initializeComponents();
        applyDarkMode();
    }

    private void initializeComponents() {
        // Rótulo do título
        JLabel titleLabel = new JLabel("P0rtal");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        titleLabel.setBounds(140, 50, 200, 50);
        add(titleLabel);

        // Painel de fundo para o formulário
        JPanel formPanel = new JPanel();
        formPanel.setBounds(50, 150, 300, 300);
        formPanel.setLayout(null);
        formPanel.setBorder(new RoundedBorder(30, new Color(102, 204, 255)));
        add(formPanel);

        // Rótulo de E-mail
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(20, 20, 260, 30);
        formPanel.add(emailLabel);

        // Campo de texto de E-mail
        JTextField emailField = new JTextField("exemplo@gmail.com");
        emailField.setBounds(20, 50, 260, 40);
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        formPanel.add(emailField);

        // Rótulo de Senha
        JLabel passwordLabel = new JLabel("Senha");
        passwordLabel.setBounds(20, 110, 260, 30);
        formPanel.add(passwordLabel);

        // Campo de senha
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 140, 260, 40);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        formPanel.add(passwordField);

        // Botão de Entrar
        JButton loginButton = new JButton("Entrar");
        loginButton.setBounds(20, 200, 260, 40);
        formPanel.add(loginButton);

        // Link para redefinir senha
        JLabel resetPasswordLabel = new JLabel("Redefinir senha");
        resetPasswordLabel.setBounds(90, 260, 120, 30);
        formPanel.add(resetPasswordLabel);

        // Botão para alternar entre Dark/Light
        JButton toggleThemeButton = new JButton("Dark");
        toggleThemeButton.setBounds(150, 500, 100, 30);
        toggleThemeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                darkMode = !darkMode; // Alterna o modo
                applyTheme(); // Aplica o tema correspondente
                toggleThemeButton.setText(darkMode ? "Dark" : "Light"); // Atualiza o texto do botão
            }
        });
        add(toggleThemeButton);

        // Armazena os componentes para fácil acesso ao alterar o tema
        components = new UIComponents(titleLabel, formPanel, emailLabel, emailField, passwordLabel, passwordField, loginButton, resetPasswordLabel);
    }

    // Classe auxiliar para agrupar os componentes e facilitar a troca de tema
    private static class UIComponents {
        JLabel titleLabel, emailLabel, passwordLabel, resetPasswordLabel;
        JPanel formPanel;
        JTextField emailField;
        JPasswordField passwordField;
        JButton loginButton;

        UIComponents(JLabel titleLabel, JPanel formPanel, JLabel emailLabel, JTextField emailField, JLabel passwordLabel, JPasswordField passwordField, JButton loginButton, JLabel resetPasswordLabel) {
            this.titleLabel = titleLabel;
            this.formPanel = formPanel;
            this.emailLabel = emailLabel;
            this.emailField = emailField;
            this.passwordLabel = passwordLabel;
            this.passwordField = passwordField;
            this.loginButton = loginButton;
            this.resetPasswordLabel = resetPasswordLabel;
        }
    }

    private UIComponents components;

    private void applyTheme() {
        if (darkMode) {
            applyDarkMode();
        } else {
            applyLightMode();
        }
    }

    private void applyDarkMode() {
        getContentPane().setBackground(new Color(20, 20, 30));
        components.titleLabel.setForeground(new Color(102, 204, 255));
        components.formPanel.setBackground(new Color(25, 25, 50));
        components.formPanel.setBorder(new RoundedBorder(30, new Color(102, 204, 255)));
        components.emailLabel.setForeground(Color.WHITE);
        components.emailField.setBackground(new Color(230, 230, 250));
        components.emailField.setForeground(Color.DARK_GRAY);
        components.passwordLabel.setForeground(Color.WHITE);
        components.passwordField.setBackground(new Color(230, 230, 250));
        components.passwordField.setForeground(Color.DARK_GRAY);
        components.loginButton.setBackground(new Color(102, 153, 255));
        components.loginButton.setForeground(Color.WHITE);
        components.resetPasswordLabel.setForeground(new Color(180, 180, 255));
    }

    private void applyLightMode() {
        getContentPane().setBackground(Color.WHITE);
        components.titleLabel.setForeground(new Color(50, 50, 50));
        components.formPanel.setBackground(new Color(240, 240, 255));
        components.formPanel.setBorder(new RoundedBorder(30, new Color(150, 150, 150)));
        components.emailLabel.setForeground(Color.BLACK);
        components.emailField.setBackground(Color.WHITE);
        components.emailField.setForeground(Color.BLACK);
        components.passwordLabel.setForeground(Color.BLACK);
        components.passwordField.setBackground(Color.WHITE);
        components.passwordField.setForeground(Color.BLACK);
        components.loginButton.setBackground(new Color(100, 149, 237)); // Azul claro para o modo claro
        components.loginButton.setForeground(Color.WHITE);
        components.resetPasswordLabel.setForeground(new Color(100, 100, 100));
    }

    public static void main(String[] args) {
        // Criando e exibindo a janela
        MainWindowentrada janela = new MainWindowentrada();
        janela.setVisible(true);
    }

    // Classe interna para criar uma borda arredondada personalizada
    static class RoundedBorder extends AbstractBorder {
        private int radius;
        private Color color;

        RoundedBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = this.radius;
            return insets;
        }
    }
}
