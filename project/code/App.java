import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        System.out.println("Bem vindo ao sistema de matrículas!\nEntrar como: \n1)Aluno\n2)Professor\n3)Secretario");

        Scanner scan = new Scanner(System.in);

        switch (scan.nextLine()) {

            case "1":
                System.out.println("Bem vindo ao portal do aluno\nO que deseja fazer?\n1)DEBUG\n2)DEBUG");
                // to-do: Classe aluno
                break;

            case "2":
                System.out.println(
                        "Bem vindo ao portal do professor\nDigite o ID de uma turma para consultar suas matriculas");
                System.out.println(Turma.getById(scan.nextLine()).toString());
                break;

            case "3":
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

                break;

            default:
                System.out.println("Favor selecionar uma opçõa válida");
                break;

        }

        scan.close();

    }
}
