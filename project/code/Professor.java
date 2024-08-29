
import java.util.List;
import java.util.ArrayList;

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
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void addToList(Professor professor){
        if(professores == null){
            professores = new ArrayList();
        }
        professores.add(professor);
    }
    public Professor(String login, String senha) {
        super(login, senha);
    }

    public Professor(){
        super();
    }

    public static void consultarMatriculas(Turma turma){
        try {
            
            String[] alunos = turma.getAlunosIds();
            
            if(alunos.length <= 0){
                System.out.println("Não possui alunos matriculados nessa diciplina");
            }else{
                System.out.println("Alunos matriculados na turma da diciplina " + turma.getId() + ": ");
                
                for(String aluno : alunos){
                    if(aluno!=null){
                    System.out.println(aluno);}
                }
            }
        } catch (Exception e) {
            System.out.println("Nao foi possivel consultar matriculas");
        }
    }

    public static void setAll(List<Professor> professores) {
        Professor.professores = professores;
    }

}
