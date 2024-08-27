import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Salvador {

    private static void salvar(Componente componente, BufferedWriter escritor) throws IOException {

        Class<?> classe = componente.getClass();

        for (Field field : classe.getDeclaredFields()) {
            field.setAccessible(true);

            try {
                escritor.append(field.get(componente).toString());
            } catch (Exception e) {
                System.out.println(e);
            }
            escritor.append("\t");
        }
        escritor.append("\n");

    }

    public static void salvarAll(Componente[] componenteAll) {

        BufferedWriter escritor;
        try {
            escritor = new BufferedWriter(
                    new FileWriter("project/code/data/" + componenteAll[0].getClass().getSimpleName() + ".txt", true));

            for (Componente componente : componenteAll) {
                try {
                    salvar(componente, escritor);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
            escritor.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static Componente[] lerArquivoDaClasse(Componente componente) { //Nao funciona
        Scanner scan;
        try {
            scan = new Scanner(new File("project/code/data/" + componente.getClass().getSimpleName() + ".txt"));

            Componente[] compList = new Componente[1000];

            int compIter = 0;

            while (scan.hasNextLine()) {

                Componente componente2 = new Componente();

                String[] line = scan.nextLine().split("\t");

                int fieldNum = 0;

                for (Field field : componente.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        field.set(line[fieldNum], componente2);
                        fieldNum++;
                    } catch (Exception e) {
                        System.out.println("line[fieldnum]="+line[fieldNum]);
                        System.out.println(e+ ": line 72, Salvador");
                    }
                }

                compList[compIter] = componente2;

                compIter++;

                
            }
            scan.close();
            return compList;

        } catch (FileNotFoundException e) {
            System.err.println(e);
            return null;
        }

    }
}
