import java.util.List;

class Relatorio {
    public static void gerarRelatorio(List<Aluno> alunos) {
        System.out.println("\n--- Relatório Acadêmico ---");
        for (Aluno aluno : alunos) {
            aluno.mostrarDetalhes();
        }
    }
}