import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Exportacao {
    public static void exportarDadosParaCSV(List<Aluno> alunos) {
        String nomeArquivo = "alunos_exportados.csv";
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.append("Nome,Idade,Semestre,Nota Oficial,Nota Parcial,Presenca,Atividades Sala,Atividades Extras\n");
            for (Aluno aluno : alunos) {
                writer.append(aluno.toCSV()).append("\n");
            }
            System.out.println("Dados exportados com sucesso para " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao exportar dados: " + e.getMessage());
        }
    }
}
