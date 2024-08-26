import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aluno extends Usuario{
    private Disciplina[] disciplinas;

    public void lerMatriculas() throws FileNotFoundException{

        Scanner scan = new Scanner(new File("project/code/Matriculas.txt"));

        // registro de cada aluno é uma linha
        // dados separados por tab (\t)
        // chave e valor separados por ":"
        // exemplo: login:valor\
 disciplina1:nome    disciplina2:nome  disciplinaN:nome 
        while(scan.hasNextLine()){

            String[] line = scan.nextLine().split("\t");

            String[] loginStr = line[0].split(":");
            this.setLogin(loginStr[0]);

            for (int i = 1; i < line.length; i++) {
                String[] str = line[0].split(":");
            }
        }

        scan.close();
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

    @Override
    public String toString() {

        String infos = "Login: " + this.getLogin()+
        "Senha: " + this.getSenha()+
        "Disciplinas em estudo: ";

        for (Disciplina disciplina : disciplinas) {
            infos = infos + disciplina.getNome();            
        }

        return infos;

    }
    
}

