import java.util.List;

class GrupoDeEstudos {
    public static void formarGrupos(List<Aluno> alunos) {
        System.out.println("GRUPOS FORMADOS:");
        for (int i = 0; i < alunos.size(); i += 5) {
            System.out.printf("Grupo %d:\n", (i / 5) + 1);
            for (int j = i; j < i + 5 && j < alunos.size(); j++) {
                alunos.get(j).mostrarDetalhes();
            }
        }
    }
}