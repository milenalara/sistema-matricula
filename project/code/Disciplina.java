import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Disciplina extends Componente{
    private String nome;
    private Boolean ativa;
    private Boolean isMatriculasAbertas;

    

    public Disciplina(String nome, Boolean ativa, Boolean isMatriculasAbertas) {
        super();
        this.nome = nome;
        this.ativa = ativa;
        this.isMatriculasAbertas = isMatriculasAbertas;
        Disciplina.addToList(this);
    }

    @Override
    public String getId() {
        return nome;
    }

    public void lerArquivo() throws FileNotFoundException{

        Scanner scan = new Scanner(new File("project/code/Disciplinas.txt"));

        while(scan.hasNextLine()){

            String[] line = scan.nextLine().split("\t");

            this.nome = line[0];

            this.ativa = Boolean.valueOf(line[1]);

            this.isMatriculasAbertas = Boolean.valueOf(line[2]);
            
        }
        scan.close();
    }
    

    public Boolean getAtiva() {
        return ativa;
    }
    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getIsMatriculasAbertas() {
        return isMatriculasAbertas;
    }

    public void setIsMatriculasAbertas(Boolean isMatriculasAbertas) {
        this.isMatriculasAbertas = isMatriculasAbertas;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "Ativa: "+ ativa + "Matriculas Abertas: " + isMatriculasAbertas; 
    }


    
}
