class Aluno {
    private String nome;
    private int idade;
    private int semestre;
    public double notaOficial;
    public double notaParcial;
    public double presenca;
    public int atividadesSala;
    public int atividadesExtras;

    public Aluno(String nome, int idade, int semestre, double notaOficial, double notaParcial, double presenca, int atividadesSala, int atividadesExtras) {
        this.nome = nome;
        this.idade = idade;
        this.semestre = semestre;
        this.notaOficial = notaOficial;
        this.notaParcial = notaParcial;
        this.presenca = presenca;
        this.atividadesSala = atividadesSala;
        this.atividadesExtras = atividadesExtras;
    }

    public double calcularMedia() {
        return ((notaOficial * 7) + (notaParcial * 3)) / 10;
    }

    public double getPresenca() {
        return presenca;
    }

    public int getAtividadesSala() {
        return atividadesSala;
    }

    public int getAtividadesExtras() {
        return atividadesExtras;
    }

    public String getNome() {
        return nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void mostrarDetalhes() {
        System.out.printf("Nome: %s | Idade: %d | Semestre: %d | Média: %.2f | Presença: %.2f%%\n", nome, idade, semestre, calcularMedia(), presenca);
    }

    public String toCSV() {
        return String.format("%s,%d,%d,%.2f,%.2f,%.2f,%d,%d", nome, idade, semestre, notaOficial, notaParcial, presenca, atividadesSala, atividadesExtras);
    }
}
