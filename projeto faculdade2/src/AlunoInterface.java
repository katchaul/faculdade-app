import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlunoInterface extends JFrame {

    public AlunoInterface() {
        setTitle("Aluno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLocationRelativeTo(null);

        // Painel principal com BorderLayout para estruturação
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Título "Aluno" no topo
        JLabel titulo = new JLabel("Aluno", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(new EmptyBorder(20, 0, 20, 0));
        mainPanel.add(titulo, BorderLayout.NORTH);

        // Painel intermediário para centralizar o painel de botões
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new GridBagLayout());
        centralPanel.setBackground(Color.WHITE);

        // Painel para os botões com BoxLayout para alinhamento vertical
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new BoxLayout(botoesPanel, BoxLayout.Y_AXIS));
        botoesPanel.setBackground(Color.WHITE);
        botoesPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Adicionando botões estilizados ao painel de botões
        botoesPanel.add(criarBotao("Atividade/Lembretes", "Icone1.png"));
        botoesPanel.add(Box.createVerticalStrut(10));
        botoesPanel.add(criarBotao("Acadêmico\nMaterial Diário | Matérias", "Icone2.png"));
        botoesPanel.add(Box.createVerticalStrut(10));
        botoesPanel.add(criarBotao("Comunicações\nHorários | Calendário | Boletim..", "Icone3.png"));
        botoesPanel.add(Box.createVerticalStrut(10));
        botoesPanel.add(criarBotao("Grupo acadêmico\nTrabalho avaliativo", "Icone4.png"));
        botoesPanel.add(Box.createVerticalStrut(10));
        botoesPanel.add(criarBotao("Financeiro\nFaturas | pagamentos", "Icone5.png"));

        // Adicionando o painel de botões ao painel central
        centralPanel.add(botoesPanel);

        // Adicionando o painel central ao centro do painel principal
        mainPanel.add(centralPanel, BorderLayout.CENTER);

        // Adicionando o painel principal ao frame
        add(mainPanel);
    }

    private JButton criarBotao(String texto, String iconePath) {
        JButton button = new JButton("<html><div style='text-align: center;'>" + texto.replace("\n", "<br>") + "</div></html>");
        button.setPreferredSize(new Dimension(250, 50));
        button.setMaximumSize(new Dimension(250, 50));
        button.setBackground(new Color(0, 70, 120));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);

        try {
            Icon icon = new ImageIcon(iconePath);
            button.setIcon(icon);
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setIconTextGap(10);
        } catch (Exception e) {
            System.out.println("Ícone não encontrado para " + texto);
        }

        // Adiciona o ActionListener para abrir a InterfaceComunicacoes ao clicar em "Comunicações"
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (texto.startsWith("Comunicações")) {
                    InterfaceComunicacoes comunicacoesFrame = new InterfaceComunicacoes(AlunoInterface.this);
                    comunicacoesFrame.setVisible(true);
                    setVisible(false); // Oculta a AlunoInterface
                }
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AlunoInterface().setVisible(true);
        });
    }
}