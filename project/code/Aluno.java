import java.util.List;
import java.util.ArrayList;

public class Aluno extends Usuario {
    private static List<Aluno> alunos;
    private List<Disciplina> disciplinas;

    public static Aluno getById(String identifier) {
        for (Aluno componente : Aluno.alunos) {
            if (componente != null) {
                if (componente.getId().equals(identifier)) {
                    return componente;
                };
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
        return null;
    }

    public static List<Aluno> getAll() {
        return alunos;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void addToList(Aluno aluno) {
        if(alunos == null){
            alunos = new ArrayList();
        }
        alunos.add(aluno);
    }

    public Aluno(String login, String senha, List<Disciplina> disciplinas) {
        super(login, senha);
        Aluno.addToList(this);
        this.disciplinas = disciplinas;
    }

    public Aluno(String login, String senha) {
        super(login, senha);
        Aluno.addToList(this);
        disciplinas = new ArrayList<>();
    }

    public Boolean matricularEmDisciplina(Disciplina disciplina) {
        if (disciplinas.size() >= 6) {
            System.out.println("Número máximo de disciplinas excedido.");
            return false;
        }
        for (Disciplina d : disciplinas) {
            if (disciplina.getNome().equals(d.getNome())) {
                System.out.println("Aluno já matriculado na disciplina.");
                return false;
            }
        }
        disciplinas.add(disciplina);
        return true;
    }

    public Boolean cancelarMatriculaDisciplina(Disciplina disciplina) {
        Boolean isMatriculado = false;
        if (disciplinas.size() <= 4) {
            System.out.println("Número mínimo de disciplinas matriculadas é 4.");
            return false;
        }
        for (Disciplina d : disciplinas) {
            if (disciplina.getId().equals(d.getId())) {
                isMatriculado = true;
            }
        }
        if (isMatriculado) {
            disciplinas.remove(disciplina);
            return true;
        }
        System.out.println("Aluno não está matriculado na turma.");
        return false;
    }

    public void pagarDisciplina(Disciplina disciplina) {

    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {

        String infos = "Login: " + this.getLogin() +
                "Senha: " + this.getSenha() +
                "Disciplinas em estudo: ";

        for (Disciplina disciplina : disciplinas) {
            infos = infos + " " + Disciplina.getById(disciplina.getId()).getNome();
        }

        return infos;

    }

    public static void setAll(List<Aluno> alunos) {
        Aluno.alunos = alunos;
    }



}
