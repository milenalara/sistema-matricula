import java.io.IOException;

public class Loader {

    public static void init() throws IOException {
        Aluno.setAll(GerenciadorDeArquivos.lerArquivoDaClasse(Aluno.class));
        Curso.setAll(GerenciadorDeArquivos.lerArquivoDaClasse(Curso.class));
        Disciplina.setAll(GerenciadorDeArquivos.lerArquivoDaClasse(Disciplina.class));
        Professor.setAll(GerenciadorDeArquivos.lerArquivoDaClasse(Professor.class));
        Secretario.setAll(GerenciadorDeArquivos.lerArquivoDaClasse(Secretario.class));
        Turma.setAll(GerenciadorDeArquivos.lerArquivoDaClasse(Turma.class));
        Componente.setAll(GerenciadorDeArquivos.lerArquivoDaClasse(Componente.class));
    }

    public static void close() {
        GerenciadorDeArquivos.salvarAll(Aluno.getAll());
        GerenciadorDeArquivos.salvarAll(Curso.getAll());
        GerenciadorDeArquivos.salvarAll(Disciplina.getAll());
        GerenciadorDeArquivos.salvarAll(Professor.getAll());
        GerenciadorDeArquivos.salvarAll(Secretario.getAll());
        GerenciadorDeArquivos.salvarAll(Turma.getAll());
        GerenciadorDeArquivos.salvarAll(Componente.getAll());
    };

}
