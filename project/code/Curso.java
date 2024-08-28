
import java.util.List;

public class Curso{
    private String nome;
    private int creditos;
    private Disciplina[] disciplinas;

    private static List<Curso> cursos;
    
    public static void addToList(Curso curso){
        cursos.add(curso);
    }

    public static List<Curso> getAll(){
        return cursos;
    }
    public static Curso getById(String identifier) {

        for (Curso curso : Curso.cursos) {
            if (curso != null) {
                if (identifier == curso.getId()) {
                    return curso;
                };
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
        return null;
    }
   

    public Curso(String nome, int creditos, Disciplina[] disciplinas){
        super();
        this.nome = nome;
        this.creditos = creditos;
        this.disciplinas = disciplinas;
        Curso.addToList(this);
    }

    @Override
    public String toString(){

        String infos =  nome + "Creditos: " + String.valueOf(creditos) + "Disciplinas: ";

        for (Disciplina disciplina : disciplinas) {
            infos = infos + disciplina.getNome() + "\t";
        }

        return infos;
    }

    public String getId() {
        return nome;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }
    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    public static void setAll(List<Curso> cursos) {
        Curso.cursos = cursos;
    }
    


}
