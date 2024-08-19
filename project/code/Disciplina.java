
public class Disciplina {
    private Boolean ativa;
    private Boolean matriculasAbertas;
    
    private Aluno[] alunos;

    public Boolean getAtiva() {
        return ativa;
    }
    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }
    public Boolean getMatriculasAbertas() {
        return matriculasAbertas;
    }
    public void setMatriculasAbertas(Boolean matriculasAbertas) {
        this.matriculasAbertas = matriculasAbertas;
    }
    
    public Aluno[] getAlunos() {
        return alunos;
    }
    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    
    
}
