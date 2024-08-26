import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Disciplina {
    private String nome;
    private Boolean ativa;
    private Boolean matriculasAbertas;
    private static Disciplina[] disciplinas = new Disciplina[1000];
    
    public Disciplina(String nome){
        this.nome = nome;
        this.ativa = true;
        this.matriculasAbertas = true;

        for (int i = 0; i < disciplinas.length; i++) {
            if(disciplinas[i]==null){
                disciplinas[i] = this;
            }
        }
        
    }

    public void lerArquivo() throws FileNotFoundException{

        Scanner scan = new Scanner(new File("project/code/Disciplinas.txt"));

        while(scan.hasNextLine()){

            String[] line = scan.nextLine().split("\t");

            this.nome = line[0];

            this.ativa = Boolean.valueOf(line[1]);

            this.matriculasAbertas = Boolean.valueOf(line[2]);
            
        }
        scan.close();
    }
    

    public Boolean getAtiva() {
        return ativa;
    }
    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }
    public Boolean getMatriculasAbertas() {
        return matriculasAbertas;
    }
    public void setMatriculasAbertas(Boolean matriculasAbertas) {
        this.matriculasAbertas = matriculasAbertas;
    }

    public String getNome() {
        return nome;
    }
    public static Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public static Disciplina searchDisciplina(String nome) {
        for (Disciplina disciplina : disciplinas) {
            if(disciplina.getNome().equals(nome)) {
                return disciplina;
            }
        }
        return null;
    }


    
}
