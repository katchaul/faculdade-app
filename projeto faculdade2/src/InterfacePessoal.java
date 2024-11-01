import javax.swing.*;
import java.awt.*;

public class InterfacePessoal extends JFrame {

    public InterfacePessoal() {
        // Configurações da janela principal
        setTitle("Interface Pessoal");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com layout e fundo branco
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBackground(Color.WHITE);
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        // Ícone de pessoa no topo
        JLabel iconeLabel = new JLabel("\uD83D\uDC64", SwingConstants.CENTER); // Ícone de pessoa
        iconeLabel.setFont(new Font("SansSerif", Font.PLAIN, 36));
        iconeLabel.setForeground(new Color(50, 50, 50)); // Cor do ícone: Cinza escuro
        iconeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Título "Pessoal" centralizado
        JLabel tituloLabel = new JLabel("Pessoal");
        tituloLabel.setForeground(new Color(50, 50, 50));
        tituloLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Botão "Dados Pessoais"
        JButton dadosPessoaisBtn = criarBotao("Dados Pessoais");

        // Botão "Nível Acadêmico"
        JButton nivelAcademicoBtn = criarBotao("Nível Acadêmico");

        // Adicionando componentes ao painel principal
        painelPrincipal.add(Box.createVerticalStrut(20)); // Espaçamento superior
        painelPrincipal.add(iconeLabel);
        painelPrincipal.add(Box.createVerticalStrut(10)); // Espaçamento entre ícone e título
        painelPrincipal.add(tituloLabel);
        painelPrincipal.add(Box.createVerticalStrut(20)); // Espaçamento entre título e botões
        painelPrincipal.add(dadosPessoaisBtn);
        painelPrincipal.add(Box.createVerticalStrut(10)); // Espaçamento entre botões
        painelPrincipal.add(nivelAcademicoBtn);

        // Adicionando o painel principal à janela
        add(painelPrincipal);

        setVisible(true);
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.setBackground(new Color(0, 70, 120)); // Cor de fundo azul escuro
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding para centralizar o texto
        botao.setFont(new Font("SansSerif", Font.PLAIN, 16)); // Fonte ajustada
        botao.setMaximumSize(new Dimension(300, 50)); // Tamanho máximo dos botões
        botao.setOpaque(true);
        botao.setBorderPainted(false);

        // Efeito hover para o botão
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(0, 102, 153)); // Azul mais claro no hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(0, 70, 120)); // Azul escuro padrão
            }
        });

        return botao;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfacePessoal());
    }
}
