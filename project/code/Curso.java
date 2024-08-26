public class Curso extends Componente{
    private String nome;
    private int creditos;
    private Disciplina[] disciplinas;

    @Override
    public String toString(){

        String infos =  nome + "Creditos: " + String.valueOf(creditos) + "Disciplinas: ";

        for (Disciplina disciplina : disciplinas) {
            infos = infos + disciplina.getNome() + "\t";
        }

        return infos;
    }

    @Override
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
    


}
