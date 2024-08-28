import java.util.List;

public class Turma{

    private static List<Turma> turmas;

    public static Turma getById(String identifier) {

        for (Turma componente : Turma.turmas) {
            if (componente != null) {
                if (identifier == componente.getId()) {
                    return componente;
                };
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
        return null;
    }
    
    public static void addToList(Turma turma){
        turmas.add(turma);
    }

    public static List<Turma> getAll(){
        return turmas;
    }
    
    private String name;
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

    public static void setAll(List<Turma> turmas) {
        Turma.turmas = turmas;
    }

    public static List<Turma> getTurmas() {
        return turmas;
    }

    public static void setTurmas(List<Turma> turmas) {
        Turma.turmas = turmas;
    }

    public String getId() {
        return name;
    }

    public void setId(String name) {
        this.name = name;
    }


    

}
