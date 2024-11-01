import java.util.ArrayList;

class Disciplina {
    private String nomeDisciplina;
    private ArrayList<Aluno> alunos = new ArrayList<>();

    // Adicionar aluno à disciplina
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public double calcularPresenca(Aluno aluno) {
        return aluno.getPresenca(); // Aqui assumindo que 'presenca' já é uma porcentagem,
    }
}