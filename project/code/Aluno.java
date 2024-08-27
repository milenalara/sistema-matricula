import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aluno extends Usuario {
    private Disciplina[] disciplinas;

    public Aluno(String login, String senha) {
        super(login, senha);
        // TODO Auto-generated constructor stub
    }

    public Aluno(String login, String senha, String[] disciplinas) {
        super(login, senha);
        for (String string : disciplinas) {
            Disciplina disciplina = (Disciplina)Disciplina.getById(disciplinas[0]);
        }
    }

    public void lerMatriculas() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("project/code/Matriculas.txt"));

        while (scan.hasNextLine()) {

            String[] line = scan.nextLine().split("\t");
            String login = line[0];

            for (int i = 1; i < line.length; i++) {
                Disciplina disciplina = (Disciplina) Disciplina.getById(line[i]);
                Disciplina.addToList(disciplina);
            }
        }

        scan.close();
    }

    public void salvarUsuario() throws IOException {

        BufferedWriter escritor = new BufferedWriter(new FileWriter("project/code/Matriculas.txt", true));

        escritor.append(this.getLogin());
        
        for (Disciplina disciplina : disciplinas) {
            escritor.append("\t");
            escritor.append(disciplina.getNome());
        }

        escritor.append("\n");

        escritor.close();
    }

    public void matricularEmDisciplina(Disciplina disciplina) {

    }

    public void cancelarDisciplina(Disciplina disciplina) {

    }

    public void pagarDisciplina(Disciplina disciplina) {

    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {

        String infos = "Login: " + this.getLogin() +
                "Senha: " + this.getSenha() +
                "Disciplinas em estudo: ";

        for (Disciplina disciplina : disciplinas) {
            infos = infos + disciplina.getNome();
        }

        return infos;

    }

}
