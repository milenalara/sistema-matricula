import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

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

    }

    public static void caseSecretario(Scanner scan) {
        System.out.println(
                "Bem vindo ao portal do secretario\nO que deseja fazer?\n1)Gerar currículo\n2)Gerar informações");
        String opc = scan.nextLine();
        switch (opc) {
            case "1":
                Secretario.gerarCurriculo();
                break;

            case "2":
                System.out.println(
                        "Digite o identificador (ID de turma, login de professor, login de aluno, nome de curso...)");
                Secretario.gerarInformacoes(Componente.getById(scan.nextLine()));
                break;

            default:
                System.out.println("Favor selecionar uma opçõa válida");
                break;
        }

    }

    public static void caseProfessor(Scanner scan) {
        System.out.println(
                "Bem vindo ao portal do professor\nDigite o ID de uma turma para consultar suas matriculas");
        System.out.println(Turma.getById(scan.nextLine()).toString());
    }

    public static void caseAluno(Scanner scan) {
        System.out.println("Bem vindo ao portal do aluno\nO que deseja fazer?\n1)DEBUG\n2)DEBUG");
        // to-do: Classe aluno
        System.out.println("1 - registrar aluno");
        System.out.println("2 - listar alunos");
        String opc;

        do {
            opc = scan.nextLine();

            switch (opc) {
                case "0":
                    break;
                case "1":
                    System.out.println("login: ");
                    String login = scan.nextLine();
                    System.out.println("senha: ");
                    String senha = scan.nextLine();
                    
                    String[] disciplinas = new String[6];
                    System.out.println("disciplina 1: ");
                    disciplinas[0] = scan.nextLine();
                    System.out.println("disciplina 2: ");
                    disciplinas[1] = scan.nextLine();
                    System.out.println("disciplina 3: ");
                    disciplinas[2] = scan.nextLine();
                    System.out.println("disciplina 4: ");
                    disciplinas[3] = scan.nextLine();

                    Aluno aluno = new Aluno(login, senha, disciplinas);
                    Aluno.addToList(aluno);
                    break;
                case "2":
                    for (Aluno al : (Aluno[]) Aluno.getAll()) {
                        System.out.println(al.toString());
                    }
                    break;
                default:
                    break;
            }
        } while (!opc.equals("0"));
    }
}
