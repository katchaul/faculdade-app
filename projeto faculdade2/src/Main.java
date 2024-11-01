import java.util.Scanner;

public class Main {
    private static GerenciamentoDeAlunos gerenciamentoDeAlunos = new GerenciamentoDeAlunos();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gerenciar Alunos");
            System.out.println("2. Calcular Média e Presença");
            System.out.println("3. Analisar Risco de Evasão");
            System.out.println("4. Formar Grupos de Estudo");
            System.out.println("5. Gerar Relatórios");
            System.out.println("6. Exportar Dados para CSV");
            System.out.println("7. Disciplinas ofertadas");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1 -> gerenciamentoDeAlunos.menuGerenciamento();
                case 2 -> CalculoMediaPresenca.calcularMediaEPercentual(gerenciamentoDeAlunos.getAlunos());
                case 3 -> AnaliseDeRisco.analiseDeRisco(gerenciamentoDeAlunos.getAlunos());
                case 4 -> GrupoDeEstudos.formarGrupos(gerenciamentoDeAlunos.getAlunos());
                case 5 -> Relatorio.gerarRelatorio(gerenciamentoDeAlunos.getAlunos());
                case 6 -> Exportacao.exportarDadosParaCSV(gerenciamentoDeAlunos.getAlunos());
                case 7 -> System.out.println(" 1 - lÓGICA DE PROGRAMAÇÃO\n" +
                        " 2 - PROGRAMAÇÃO ORIENTA A OBJETOS\n" +
                        " 3 - ESTRUTURA DE DADOS\n" +
                        " 4 - ESTRUTURA DE DADOS\n" +
                        " 5 - BANCO DE DADOS\n" +
                        " 6 - DESENVOLVIMENTO WEB |\n" +
                        " 7 - DESENVOLVIMENTO WEB ||\n" +
                        " 8 - ENGENHARIA DE SOFTWARE\n" +
                        " 9 - REDES DE COMPUTADORES\n" +
                        "10 - SISTEMAS OPERACIONAIS\n" +
                        "11 - INTELIGENCIA ARTIFICIAL\n" +
                        "12 - SEGURANÇA DA INFORMAÇÃO\n");
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}