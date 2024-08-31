import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

//DUVIDA PARA LAB: SEPARAR AS LISTAS EM LISTAS GENERICAS, COMO NA ANTIGA CLASSE COMPONENTES


public class App {
    public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {

        Loader.init();

        System.out.println("Bem vindo ao sistema de matrículas!\nEntrar como: \n1)Aluno\n2)Professor\n3)Secretario\n4)Criar novo cadastro");

        Scanner scan = new Scanner(System.in);

        switch (scan.nextLine()) {

            case "1":
                Cadastrador.fazerLoginAluno(scan);
                caseAluno(scan);
                break;

            case "2":
                Cadastrador.fazerLoginProf(scan);
                caseProfessor(scan);
                break;

            case "3":
                Cadastrador.fazerLoginSecretaria(scan);
                caseSecretario(scan);
                break;

                case "4":
                Cadastrador.fazerCadastro(scan);
                break;

            default:
                System.out.println("Favor selecionar uma opçõa válida");
                break;

        }

        scan.close();
        Loader.close();

    }

    public static void caseSecretario(Scanner scan) throws IllegalArgumentException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {
        System.out.println(
                "Bem vindo ao portal do secretario\nO que deseja fazer?\n1)Gerar currículo\n2)Gerenciar informações");

        String opc = scan.nextLine();
        switch (opc) {
            case "1":
                Secretario.gerarCurriculo();
                break;

            case "2":
                System.out.println(
                        "1)Criar um novo registro\n2)Acessar registros\n3)Deletar um registro\n4)Atualizar um registro");
                switch (scan.nextLine()) {
                    case "1":
                        caseCriarRegistro(scan);
                        break;
                    case "2":
                        verTodosRegistros();
                        break;
                    case "3":
                        deletarRegistro(scan);
                        break;
                    case "4":
                        atualizarRegistro(scan);
                        break;
                    default:
                        System.out.println("opcao invalida");
                        break;
                }
                break;
            default:
                System.out.println("Favor selecionar uma opção válida");
                break;
        }

    }

    public static void caseProfessor(Scanner scan) {
        System.out.println(
                "Bem vindo ao portal do professor\nDigite o ID de uma turma para consultar suas matriculas");
        Professor.consultarMatriculas(Turma.getById(scan.nextLine()));
    }

    public static void caseAluno(Scanner scan) {
        System.out.println("Bem vindo ao portal do aluno\nO que deseja fazer?\n1)MATRICULAR-SE EM DISCIPLINA\n2)CANCELAR MATRICULA DISCIPLINA");
        // to-do: Classe aluno
    }

    public static void caseCriarRegistro(Scanner scan) throws IllegalArgumentException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {
        System.out
                .println("O que deseja registrar?\n1)Aluno\n2)Curso\n3)Disciplina\n4)Professor\n5)Secretario\n6)Turma");

        switch (scan.nextLine()) {
            case "1":
                Usuario u1 = (Usuario) CriadorDeComponentes.createComponentManual(Usuario.class, scan);
                Aluno.addToList(new Aluno(u1.getLogin(), u1.getSenha()));
                break;
            case "2":
                Curso.addToList((Curso) CriadorDeComponentes.createComponentManual(Curso.class, scan));
                break;
            case "3":
                Disciplina d1 = (Disciplina) CriadorDeComponentes.createComponentManual(Disciplina.class, scan);
                Disciplina.addToList(d1);
                // Disciplina.addToList((Disciplina) CriadorDeComponentes.createComponentManual(Disciplina.class, scan));
                break;
            case "4":
                Usuario u4 = (Usuario) CriadorDeComponentes.createComponentManual(Usuario.class, scan);
                Professor.addToList(new Professor(u4.getLogin(), u4.getSenha()));
                break;
            case "5":
                Usuario u5 = (Usuario) CriadorDeComponentes.createComponentManual(Usuario.class, scan);
                Secretario.addToList(new Secretario(u5.getLogin(), u5.getSenha()));
                break;
            case "6":
                Turma.addToList((Turma) CriadorDeComponentes.createComponentManual(Turma.class, scan));
                break;
            default:
                System.out.println("Favor selecionar uma opção válida");
                break;
        }
    }

    private static void verTodosRegistros() {

        System.out.println("Alunos:");
        verRegistros(Aluno.getAll());

        System.out.println("Cursos:");
        verRegistros(Curso.getAll());

        System.out.println("Disciplina");
        verRegistros(Disciplina.getAll());

        System.out.println("Professores:");
        verRegistros(Professor.getAll());

        System.out.println("Secretarios");
        verRegistros(Secretario.getAll());

        System.out.println("Turmas");
        verRegistros(Turma.getAll());

    }

    private static <T> void verRegistros(List<T> lista) {

        if (lista != null && !lista.isEmpty()) {
            for (T t : lista) {
                if(t!=null){
                System.out.println(t);}
            }
        } else {
            System.out.println("Nao ha registros");
        }
    }

    private static void deletarRegistro(Scanner scan) {
        System.out.println(
                "Qual é o tipo de registro?\n1)Aluno\n2)Curso\n3)Disciplina\n4)Professor\n5)Secretario\n6)Turma");
        String opt = scan.nextLine();
        System.out.println("Digite o identificador");
        String id = scan.nextLine();
        try {
            switch (opt) {
                case "1":
                    Aluno.getAll().remove(Aluno.getById(id));
                    Usuario u1 = (Usuario) CriadorDeComponentes.createComponentManual(Usuario.class, scan);
                    Aluno.addToList(new Aluno(u1.getLogin(), u1.getSenha()));
                    break;
                case "2":
                    Curso.addToList((Curso) CriadorDeComponentes.createComponentManual(Curso.class, scan));
                    Curso.getAll().remove(Curso.getById(id));
                    break;
                case "3":
                    Disciplina.addToList((Disciplina) CriadorDeComponentes.createComponentManual(Disciplina.class, scan));
                    Disciplina.getAll().remove(Disciplina.getById(id));
                    break;
                case "4":
                    Usuario u4 = (Usuario) CriadorDeComponentes.createComponentManual(Usuario.class, scan);
                    Professor.addToList(new Professor(u4.getLogin(), u4.getSenha()));
                    Professor.getAll().remove(Professor.getById(id));
                    break;
                case "5":
                    Secretario.getAll().remove(Secretario.getById(id));
                    Usuario u5 = (Usuario) CriadorDeComponentes.createComponentManual(Usuario.class, scan);
                    Secretario.addToList(new Secretario(u5.getLogin(), u5.getSenha()));
                    break;
                case "6":
                    Turma.getAll().remove(Turma.getById(id));
                    Turma.addToList((Turma) CriadorDeComponentes.createComponentManual(Turma.class, scan));
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        } catch (Exception e) {
            System.out.println(id + " not found");
        }

    }

    private static void atualizarRegistro(Scanner scan) {

        System.out.println(
                "Qual é o tipo de registro?\n1)Aluno\n2)Curso\n3)Disciplina\n4)Professor\n5)Secretario\n6)Turma");
        String opt = scan.nextLine();
        System.out.println("Digite o identificador");
        String id = scan.nextLine();
        try {
            switch (opt) {
                case "1":
                    Aluno.getAll().remove(Aluno.getById(id));

                    break;
                case "2":
                    Curso.getAll().remove(Curso.getById(id));
                    break;
                case "3":
                    Disciplina.getAll().remove(Disciplina.getById(id));
                    break;
                case "4":
                    Professor.getAll().remove(Professor.getById(id));
                    break;
                case "5":
                    Secretario.getAll().remove(Secretario.getById(id));
                    break;
                case "6":
                    Turma.getAll().remove(Turma.getById(id));
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        } catch (Exception e) {
            System.out.println(id + " not found");
        }

    }

}
