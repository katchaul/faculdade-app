import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceComunicacoes extends JFrame {

    private JFrame janelaAnterior;

    public InterfaceComunicacoes(JFrame janelaAnterior) {
        this.janelaAnterior = janelaAnterior;
        setTitle("Comunicações");
        setSize(300, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Painel principal com fundo branco
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout());

        // Título "Comunicações" no topo
        JLabel titulo = new JLabel("Comunicações", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(new EmptyBorder(20, 0, 20, 0));
        mainPanel.add(titulo, BorderLayout.NORTH);

        // Painel de conteúdo para centralizar o restante da interface
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Adicionando ícone e título "Comunicações" centralizados
        JLabel iconLabel = new JLabel(new ImageIcon("IconeComunicacoes.png")); // Coloque o caminho real do ícone
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel comunicacoesLabel = new JLabel("Comunicações", SwingConstants.CENTER);
        comunicacoesLabel.setForeground(Color.BLACK);
        comunicacoesLabel.setFont(new Font("Arial", Font.BOLD, 18));
        comunicacoesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPanel.add(iconLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(comunicacoesLabel);
        contentPanel.add(Box.createVerticalStrut(20));

        // Painel de botões com fundo branco para cada botão
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new BoxLayout(botoesPanel, BoxLayout.Y_AXIS));
        botoesPanel.setBackground(Color.WHITE);

        botoesPanel.add(criarBotao("Horários"));
        botoesPanel.add(Box.createVerticalStrut(10));
        botoesPanel.add(criarBotao("Calendário Acadêmico"));
        botoesPanel.add(Box.createVerticalStrut(10));
        botoesPanel.add(criarBotao("Boletim"));
        botoesPanel.add(Box.createVerticalStrut(10));
        botoesPanel.add(criarBotao("Disciplinas"));

        contentPanel.add(botoesPanel);

        // Adicionando o botão "Voltar" ao painel principal
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoVoltar.setBackground(new Color(0, 70, 120));
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.setOpaque(true);

        // Ação para o botão Voltar
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAnterior.setVisible(true); // Torna a janela anterior visível
                dispose(); // Fecha a InterfaceComunicacoes
            }
        });

        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(botaoVoltar);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    private JButton criarBotao(String texto) {
        JButton button = new JButton(texto);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(200, 40));
        button.setMaximumSize(new Dimension(200, 40));
        button.setBackground(new Color(0, 70, 120));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);

        return button;
    }
}