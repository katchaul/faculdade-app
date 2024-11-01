import java.util.List;

class AnaliseDeRisco {
    public static void analiseDeRisco(List<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            String risco;
            if (aluno.getPresenca() < 30 || aluno.calcularMedia() <= 5 || aluno.getAtividadesSala() <= 7 || aluno.getAtividadesExtras() < 3) {
                risco = "Alto";
            } else if (aluno.getPresenca() >= 30 && aluno.getPresenca() <= 60 || aluno.calcularMedia() > 5 && aluno.calcularMedia() < 7 || aluno.getAtividadesSala() > 7 && aluno.getAtividadesSala() <= 10 || aluno.getAtividadesExtras() >= 3 && aluno.getAtividadesExtras() < 5) {
                risco = "Médio";
            } else {
                risco = "Baixo";
            }
            System.out.printf("Aluno: %s | Risco de Evasão/Reprovação: %s\n", aluno.getNome(), risco);
        }
    }
}