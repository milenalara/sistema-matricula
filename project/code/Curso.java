public class Curso {
    private String nome;
    private int creditos;
    private Disciplina[] disciplinas;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }
    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    
}
