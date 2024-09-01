import java.util.List;
import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;

public class Turma implements Serializable {
    private Integer MAX_ALUNOS = 60;
    private String name;
    private List<Aluno> alunos;
    private String professorId;
    private String disciplinaId;
    private static List<Turma> turmas;

    public Turma() {
        name = Long.toString(new Date().getTime()); // generating random number for Id
        Turma.addToList(this);
    }
    
    public Turma(String disciplinaId) {
        this.disciplinaId = disciplinaId;
        Turma.addToList(this);
    }

    public static Turma getById(String identifier) {
        if (turmas == null) {
            turmas = new ArrayList<>();
        }
        for (Turma componente : Turma.turmas) {
            if (componente != null) {
                if (identifier.equals(componente.getId())) {
                    return componente;
                };
            }
        }
        System.out.println("Turma " + identifier + " nao encontrada");
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void addToList(Turma turma) {
        if (Turma.turmas == null) {
            Turma.turmas = new ArrayList();
        }
        turmas.add(turma);
    }

    public static List<Turma> getAll() {
        return turmas;
    }

    public Turma(List<Aluno> alunos, String professor, String disciplina) {
        super();
        this.alunos = alunos;
        this.professorId = professor;
        this.disciplinaId = disciplina;
        Turma.addToList(this);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunosIds(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Boolean addAluno(Aluno aluno) {
        if(alunos == null) {
            alunos = new ArrayList<>();
        }
        if(alunos.size() >= 60) {
            System.out.println("Limite de alunos por turma = " + MAX_ALUNOS + ". Favor criar turma nova");
            return false;
        }
        alunos.add(aluno);
        return true;
    }

    @Override
    public String toString() {
        String info = "ID: " + this.getId() + "Professor: " + professorId + " Disciplina: " + disciplinaId + " Alunos:";
        for (Aluno aluno : alunos) {
                info = info + " " + aluno.getLogin();
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

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(String disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

}
