import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private static List<Aluno> alunos;

    private List<Turma> turmas = new ArrayList<>();

    public static void addToList(Aluno aluno) {
        alunos.add(aluno);
    }

    public static List<Aluno> getAll() {
        return alunos;
    }

    public static Aluno getById(String identifier) {

        for (Aluno componente : Aluno.alunos) {
            if (componente != null) {
                if (componente.getId().equals(identifier)) {
                    return componente;
                }
                ;
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
        return null;
    }

    public Boolean matricularEmTurma(Turma turma) {
        if (turmas.size() >= 6) {
            System.out.println("Número máximo de disciplinas excedido.");
            return false;
        }
        for (Turma t : turmas) {
            if (turma.getDisciplinaId().equals(t.getDisciplinaId())) {
                System.out.println("Aluno já matriculado na disciplina.");
                return false;
            }
        }
        turmas.add(turma);
        return true;
    }

    public Boolean cancelarMatriculaTurma(Turma turma) {
        Boolean isMatriculado = false;
        if (turmas.size() <= 4) {
            System.out.println("Número mínimo de disciplinas matriculadas é 4.");
            return false;
        }
        for (Turma t : turmas) {
            if (turma.getId().equals(t.getId())) {
                isMatriculado = true;
            }
        }
        if (isMatriculado) {
            turmas.remove(turma);
            return true;
        }
        System.out.println("Aluno não está matriculado na turma.");
        return false;
    }

    public void pagarDisciplina(Disciplina disciplina) {

    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public String toString() {

        String infos = "Login: " + this.getLogin() +
                "Senha: " + this.getSenha() +
                "Disciplinas em estudo: ";

        for (Turma turma : turmas) {
            infos = infos + " " + Disciplina.getById(turma.getDisciplinaId()).getNome();
        }

        return infos;

    }

    public Aluno(String login, String senha) {
        super(login, senha);
        Aluno.addToList(this);
    }

    public static void setAll(List<Aluno> alunos) {
        Aluno.alunos = alunos;
    }

}
