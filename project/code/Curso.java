import java.io.Serializable;
import java.util.List;

public class Curso implements Serializable{
    private String nome;
    private int creditos;
    private String[] disciplinasIds;

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
                if (curso.getId().equals(identifier)) {
                    return curso;
                };
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
        return null;
    }
   

    public Curso(String nome, int creditos, String[] disciplinasId){
        super();
        this.nome = nome;
        this.creditos = creditos;
        this.disciplinasIds = disciplinasId;
        Curso.addToList(this);
    }

    @Override
    public String toString(){

        String infos =  nome + "Creditos: " + String.valueOf(creditos) + "\tDisciplinas: ";

        for (String disciplina : disciplinasIds) {
            infos = infos + disciplina + "\t";
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

    public static void setAll(List<Curso> cursos) {
        Curso.cursos = cursos;
    }
    


}
