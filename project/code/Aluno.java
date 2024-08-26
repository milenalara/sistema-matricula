import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aluno extends Usuario{
    private static Aluno[] alunos;
    private Disciplina[] disciplinas;

    public void lerMatriculas() throws FileNotFoundException{

        Scanner scan = new Scanner(new File("project/code/Matriculas.txt"));

        int i = 0;

        // registro de cada aluno é uma linha
        // dados separados por tab (\t)
        // chave e valor separados por ":"
        // exemplo: login:valor\
 disciplina1:nome    disciplina2:nome  disciplinaN:nome 
        while(scan.hasNextLine()){

            String[] line = scan.nextLine().split("\t");

            String[] loginStr = line[0].split(":");
            this.setLogin(loginStr[0]);

            for
        }

        scan.close();
    }

        public void salvarMatricula() throws IOException{
        
        BufferedWriter escritor = new BufferedWriter(new FileWriter("project/code/Matriculas.txt", true));
        
        escritor.append("");

        escritor.close();
    }


    public void matricularEmDisciplina(Disciplina disciplina){
        

    }

    public void cancelarDisciplina(Disciplina disciplina){
        
    }

    public void pagarDisciplina(Disciplina disciplina){
        
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    
}

