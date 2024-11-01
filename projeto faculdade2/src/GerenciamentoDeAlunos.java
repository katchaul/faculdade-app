import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GerenciamentoDeAlunos {
    private List<Aluno> alunos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menuGerenciamento() {
        System.out.println("\n--- Gerenciamento de Alunos ---");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Consultar Aluno");
        System.out.println("3. Atualizar Aluno");
        System.out.println("4. Excluir Aluno");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1 -> cadastrarAluno();
            case 2 -> consultarAlunos();
            case 3 -> atualizarAluno();
            case 4 -> excluirAluno();
            default -> System.out.println("Opção inválida.");
        }
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    private void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Semestre: ");
        int semestre = scanner.nextInt();
        System.out.print("Nota Oficial: ");
        double notaOficial = scanner.nextDouble();
        System.out.print("Nota Parcial: ");
        double notaParcial = scanner.nextDouble();
        System.out.print("Presença (%): ");
        double presenca = scanner.nextDouble();
        System.out.print("Atividades em Sala: ");
        int atividadesSala = scanner.nextInt();
        System.out.print("Atividades Extracurriculares: ");
        int atividadesExtras = scanner.nextInt();
        alunos.add(new Aluno(nome, idade, semestre, notaOficial, notaParcial, presenca, atividadesSala, atividadesExtras));
        System.out.println("Aluno cadastrado com sucesso.");
    }

    private void consultarAlunos() {
        for (Aluno aluno : alunos) {
            aluno.mostrarDetalhes();
        }
    }

    private void atualizarAluno() {
        System.out.print("Digite o nome do aluno para atualizar: ");
        String nome = scanner.next();
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.print("Nova Nota Oficial: ");
                aluno.notaOficial = scanner.nextDouble();
                System.out.print("Nova Nota Parcial: ");
                aluno.notaParcial = scanner.nextDouble();
                System.out.print("Nova Presença (%): ");
                aluno.presenca = scanner.nextDouble();
                System.out.print("Novas Atividades em Sala: ");
                aluno.atividadesSala = scanner.nextInt();
                System.out.print("Novas Atividades Extracurriculares: ");
                aluno.atividadesExtras = scanner.nextInt();
                System.out.println("Dados do aluno atualizados.");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private void excluirAluno() {
        System.out.print("Digite o nome do aluno para excluir: ");
        String nome = scanner.next();
        alunos.removeIf(aluno -> aluno.getNome().equalsIgnoreCase(nome));
        System.out.println("Aluno excluído, se existia no sistema.");
    }
}