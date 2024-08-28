import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

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

    public static void caseSecretario(Scanner scan) {
        System.out.println(
                "Bem vindo ao portal do secretario\nO que deseja fazer?\n1)Gerar currículo\n2)Gerenciar informações");

        String opc = scan.nextLine();
        switch (opc) {
            case "1":
                Secretario.gerarCurriculo();
                break;

            case "2":
                System.out.println(
                        "1)Criar um novo registro\n2)Acessar um existente");
                switch (scan.nextLine()) {
                    case "1":
                        caseCriarRegistro(scan);
                        break;
                    case "2":
                        Secretario.gerarInformacoes(Componente.getById(scan.nextLine()));
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
        System.out.println(Turma.getById(scan.nextLine()).toString());
    }

    public static void caseAluno(Scanner scan) {
        System.out.println("Bem vindo ao portal do aluno\nO que deseja fazer?\n1)MATRICULAR EM DISCIPLINA\n2)CANCELAR MATRICULA EM DISCIPLINA\n3)LISTAS DISCIPLINAS MATRICULADAS\n4)ENCERRAR");
        String op = scan.nextLine();
        do {
            switch (op) {
                case "1":
                    System.out.println("Informe o login");
                    String login = scan.nextLine();
                    System.out.println("Informe a senha:");
                    String senha = scan.nextLine();
                    System.out.println("Informe o nome da disciplina desejada:");
                    String disc = scan.nextLine();
                    Disciplina disciplina = (Disciplina)Disciplina.getById(disc);
                    Aluno aluno = new Aluno(login, senha);
                    break;
                case "2":
                
                    break;
                case "3":
                    Aluno.deserialize();
                    break;
                default:
                System.out.println("Opção inválida");
                    break;
            }
            op = scan.nextLine();
        } while (!op.equals("0"));
    }

    public static void caseCriarRegistro(Scanner scan) {
        System.out
                .println("O que deseja registrar?\n1)Aluno\n2)Curso\n3)Disciplina\n4)Professor\n5)Secretario\n6)Turma");

        switch (scan.nextLine()) {
            case "1":
                System.out.println("Digite, em ordem, o login e senha");
                String login = scan.nextLine();
                String senha = scan.nextLine();
                new Aluno(login, senha);
                break;
            case "2":
                System.out.println(
                        "Digite, em ordem, o nome, os cretidos e o nome das disciplinas (Digite FIM para terminar)");
                String nome = scan.nextLine();
                int creditos = scan.nextInt();
                List<Disciplina> disciplinas = new ArrayList<>();
                String disciplina = scan.nextLine();
                while (disciplina != "FIM") {
                    disciplinas.add((Disciplina) Disciplina.getById(disciplina));
                }
                Disciplina[] disciplinaList = (Disciplina[]) disciplinas.toArray();
                new Curso(nome, creditos, disciplinaList);
                break;
            case "3":
                System.out.println(
                        "Digite, em ordem, o nome, se esta ativa (true ou false) e se as matriculas estao abertas (true ou false)");
                String nomeDisc = scan.nextLine();
                Boolean ativa = scan.nextBoolean();
                Boolean matrAbertas = scan.nextBoolean();
                new Disciplina(nomeDisc, ativa, matrAbertas);
                break;
            case "4":
                System.out.println("Digite, em ordem, o login e senha");
                String loginP = scan.nextLine();
                String senhaP = scan.nextLine();
                new Professor(loginP, senhaP);
                break;
            case "5":
                System.out.println("Digite, em ordem, o login e senha");
                String loginS = scan.nextLine();
                String senhaS = scan.nextLine();
                new Secretario(loginS, senhaS);
                break;
            case "6":
                System.out
                        .println("Digite, em ordem, o professor, a disciplina e os alunos (Digite FIM para teriminar)");
                String prof = scan.nextLine();
                String disc = scan.nextLine();
                List<Aluno> alunos = new ArrayList<>();
                String aluno = scan.nextLine();
                while (aluno != "FIM") {
                    alunos.add((Aluno) Aluno.getById(aluno));
                }
                Aluno[] alunoList = (Aluno[]) alunos.toArray();
                new Turma(alunoList, (Professor) Professor.getById(prof), (Disciplina) Disciplina.getById(disc));
                break;
            default:
                System.out.println("Favor selecionar uma opção válida");
                break;
        }
    }
}
