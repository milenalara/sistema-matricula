
import java.util.List;

public class Professor extends Usuario{

    private static List<Professor> professores;
    
    public static Professor getById(String identifier) {

        for (Professor componente : Professor.professores) {
            if (componente != null) {
                if (identifier == componente.getId()) {
                    return componente;
                };
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
        return null;
    }
    
    public static List<Professor> getAll(){
        return professores;
    }
    
    public static void addToList(Professor professor){
        professores.add(professor);
    }
    public Professor(String login, String senha) {
        super(login, senha);
    }

    public Professor(){
        super();
    }

    public void consultarMatriculas(Turma turma){
        String[] alunos = turma.getAlunosIds();

        if(alunos.length <= 0){
            System.out.println("Não possui alunos matriculados nessa diciplina");
        }else{
            System.out.println("Alunos matriculados na turma da diciplina: " + turma.getDisciplinaId() + ": ");

            for(String aluno : alunos){
                System.out.println(aluno);
            }
        }
    }

    public static void setAll(List<Professor> professores) {
        Professor.professores = professores;
    }

}
