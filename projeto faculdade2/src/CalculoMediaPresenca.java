import java.util.List;

class CalculoMediaPresenca {
    public static void calcularMediaEPercentual(List<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            System.out.printf("Aluno: %s | Média: %.2f | Presença: %.2f%%\n", aluno.getNome(), aluno.calcularMedia(), aluno.getPresenca());
        }
    }
}
