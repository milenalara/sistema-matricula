import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

//DUVIDA PARA LAB: SEPARAR AS LISTAS EM LISTAS GENERICAS, COMO NA ANTIGA CLASSE COMPONENTES

public class App {
    public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {

        Loader.init();

        System.out.println(
                "Bem vindo ao sistema de matrículas!\nEntrar como: \n1)Aluno\n2)Professor\n3)Secretario\n4)Criar novo cadastro");
                
        Scanner scan = new Scanner(System.in);

        switch (scan.nextLine()) {
            case "1":
                String nome = Cadastrador.fazerLoginAluno(scan);
                caseAluno(scan, nome);
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

        String opc;
        System.out.println("Bem vindo ao portal do secretario");

        do {
            System.out.println("O que deseja fazer?\n1)Gerar currículo\n2)Gerenciar informações\n0)Encerrar o programa");
            opc = scan.nextLine();
            switch (opc) {
                case "0":
                    break;
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
        } while (!opc.equals("0"));
    }

    public static void caseProfessor(Scanner scan) {
        System.out.println("Bem vindo ao portal do professor\n");
        String op;
        do {
            System.out.println("Digite o ID de uma turma para consultar suas matriculas");
            Professor.consultarMatriculas(Turma.getById(scan.nextLine()));
            System.out.println("Deseja consultar outra turma? (S/N)");
            op = scan.nextLine();
        } while (op.equals("S"));
    }

    public static void caseAluno(Scanner scan, String nome) {
        System.out.println("Bem vindo ao portal do aluno");

        Aluno aluno = Aluno.getById(nome);
        String op;

        do {
            System.out.println("O que deseja fazer?");
            System.out.println("1)Matricular-se em disciplina");
            System.out.println("2)Cancelar matrícula em disciplina");
            System.out.println("3)Visualizar disciplinas matriculadas");
            System.out.println("4)Realizar pagamento da mensalidade");
            System.out.println("0)Encerrar o programa");

            op = scan.nextLine();
            switch (op) {
                case "1":
                    System.out.println("Informe o nome da disciplina: ");

                    Disciplina disciplina = Disciplina.getById(scan.nextLine());
                    if (disciplina == null) {
                        return;
                    }
                    aluno.matricularEmDisciplina(disciplina);
                    break;
                case "2":
                    System.out.println("Informe o nome da disciplina: ");
                    String nomeDisciplina = scan.nextLine();
                    disciplina = Disciplina.getById(nomeDisciplina);
                    if (disciplina == null) {
                        return;
                    }
                    aluno.cancelarMatriculaDisciplina(disciplina);
                    break;
                case "3":
                    aluno.visualizarDisciplinas();
                    break;
                case "4":
                    aluno.pagarDisciplinas(scan);
                    break;
                default:
                    System.out.println("\n=======================================\n");
                    System.out.println("Opção inválida");
                    System.out.println("\n=======================================\n");
                    break;
            }
        } while (!op.equals("0"));
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
                // Disciplina.addToList((Disciplina)
                // CriadorDeComponentes.createComponentManual(Disciplina.class, scan));
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
        System.out.println("\n=========Alunos========");
        verRegistros(Aluno.getAll());

        System.out.println("=========Cursos=========");
        verRegistros(Curso.getAll());

        System.out.println("=======Disciplina=======");
        verRegistros(Disciplina.getAll());

        System.out.println("=======Professores=======");
        verRegistros(Professor.getAll());

        System.out.println("=======Secretarios=======");
        verRegistros(Secretario.getAll());

        System.out.println("=========Turmas=========");
        verRegistros(Turma.getAll());
        System.out.println();
    }

    private static <T> void verRegistros(List<T> lista) {

        if (lista != null && !lista.isEmpty()) {
            for (T t : lista) {
                if (t != null) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("Nao há registros");
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
                    Disciplina
                            .addToList((Disciplina) CriadorDeComponentes.createComponentManual(Disciplina.class, scan));
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
