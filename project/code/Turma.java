
public class Turma extends Componente{
    

    private Aluno[] alunos;
    private Professor professor;
    private Disciplina disciplina;

    
    
    public Turma(Aluno[] alunos, Professor professor, Disciplina disciplina) {
        super();
        this.alunos = alunos;
        this.professor = professor;
        this.disciplina = disciplina;
        Turma.addToList(this);
    }
    public Aluno[] getAlunos() {
        return alunos;
    }
    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        String info = "ID: "+ this.getId() +"Professor: "+ professor + "Disciplina: "+ disciplina;
        for (Aluno aluno : alunos) {
            info = info + aluno.getLogin();
        }
        return info;
    }

    

}
