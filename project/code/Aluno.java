import java.util.List;

public class Aluno extends Usuario{
    private String[] disciplinas;

    private static List<Aluno> alunos;
    
    public static void addToList(Aluno aluno){
        alunos.add(aluno);
    }

    public static List<Aluno> getAll(){
        return alunos;
    }

    public static Aluno getById(String identifier) {

        for (Aluno componente : Aluno.alunos) {
            if (componente != null) {
                if (identifier == componente.getId()) {
                    return componente;
                };
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
        return null;
    }

    public void matricularEmDisciplina(Disciplina disciplina){
        
        
    }

    public void cancelarDisciplina(Disciplina disciplina){
        
    }

    public void pagarDisciplina(Disciplina disciplina){
        
    }

    public String[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {

        String infos = "Login: " + this.getLogin()+
        "Senha: " + this.getSenha()+
        "Disciplinas em estudo: ";

        for (String disciplina : disciplinas) {
            infos = infos + " " +disciplina;            
        }

        return infos;

    }

    public Aluno(String login, String senha){
        super(login, senha);
        Aluno.addToList(this);
    }

    public static void setAll(List<Aluno> alunos) {
        Aluno.alunos = alunos;
    }
    
}

