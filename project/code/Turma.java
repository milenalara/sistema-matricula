import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Turma implements Serializable {

    private String name;
    private String[] alunosIds = new String[1000];
    private String professorId;
    private String disciplinaId;
    private static List<Turma> turmas;

    public Turma() {

    }

    public static Turma getById(String identifier) {

        for (Turma componente : Turma.turmas) {
            if (componente != null) {
                if (identifier.equals(componente.getId())) {
                    return componente;
                };
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
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

    public Turma(String[] alunosIds, String professor, String disciplina) {
        super();
        this.alunosIds = alunosIds;
        this.professorId = professor;
        this.disciplinaId = disciplina;
        Turma.addToList(this);
    }

    public String[] getAlunosIds() {
        return alunosIds;
    }

    public void setAlunosIds(String[] alunosIds) {
        this.alunosIds = alunosIds;
    }

    @Override
    public String toString() {
        String info = "ID: " + this.getId() + "Professor: " + professorId + " Disciplina: " + disciplinaId + " Alunos:";
        for (String aluno : alunosIds) {
            if (!(aluno==null)) {
                info = info + " " + aluno;
            }
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
