import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {

        Loader.init();

        System.out.println("Bem vindo ao sistema de matrículas!\nEntrar como: \n1)Aluno\n2)Professor\n3)Secretario");

        Scanner scan = new Scanner(System.in);

        switch (scan.nextLine()) {

            case "1":
                caseAluno(scan);
                break;

            case "2":
                caseProfessor(scan);
                break;

            case "3":
                caseSecretario(scan);
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
                        "1)Criar um novo registro\n2)Acessar um existente\n3)Deletar um registro\n4)Atualizar um regsitro\n5)Ver todos registros");
                switch (scan.nextLine()) {
                    case "1":
                        caseCriarRegistro(scan);
                        break;
                    case "2":
                        // TODO));
                        break;
                    case "3":
                        // TODO));
                        break;
                    case "4":
                        // TODO));
                        break;
                        case "5":
                        verTodosRegistros();
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
        System.out.println(Turma.getById(scan.nextLine()));
    }

    public static void caseAluno(Scanner scan) {
        System.out.println("Bem vindo ao portal do aluno\nO que deseja fazer?\n1)DEBUG\n2)DEBUG");
        // to-do: Classe aluno
    }

    public static void caseCriarRegistro(Scanner scan) throws IllegalArgumentException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {
        System.out
                .println("O que deseja registrar?\n1)Aluno\n2)Curso\n3)Disciplina\n4)Professor\n5)Secretario\n6)Turma");

        switch (scan.nextLine()) {
            case "1":
                Usuario u1 = (Usuario) Creater.createComponentManual(Usuario.class, scan);
                Aluno.addToList(new Aluno(u1.getLogin(), u1.getSenha()));
                break;
            case "2":
                Curso.addToList((Curso) Creater.createComponentManual(Curso.class, scan));
                break;
            case "3":
                Disciplina.addToList((Disciplina) Creater.createComponentManual(Disciplina.class, scan));
                break;
            case "4":
                Usuario u4 = (Usuario) Creater.createComponentManual(Usuario.class, scan);
                Professor.addToList(new Professor(u4.getLogin(), u4.getSenha()));
                break;
            case "5":
                Usuario u5 = (Usuario) Creater.createComponentManual(Usuario.class, scan);
                Secretario.addToList(new Secretario(u5.getLogin(), u5.getSenha()));
                break;
            case "6":
                Turma.addToList((Turma) Creater.createComponentManual(Turma.class, scan));
                break;
            default:
                System.out.println("Favor selecionar uma opção válida");
                break;
        }
    }

    private static void verTodosRegistros(){

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

    private static <T> void verRegistros(List<T> lista){

        if(lista!=null&&!lista.isEmpty()){
        for (T t : lista) {
            System.out.println(t);}
        }else{
            System.out.println("Nao ha registros");
        }


    }
}
