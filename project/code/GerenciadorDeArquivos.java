import java.io.ObjectOutputStream;
import java.nio.file.NoSuchFileException;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GerenciadorDeArquivos {

    public static void salvarAll(Componente[] componenteAll) {
        if (componenteAll != null) {
            try {
                FileOutputStream fOutputStrem = new FileOutputStream(
                        new File("project/code/data/" + componenteAll[0].getClass().getSimpleName() + ".txt"));

                ObjectOutputStream oOutputStream = new ObjectOutputStream(fOutputStrem);

                for (Componente componente : componenteAll) {
                    oOutputStream.writeObject(componente);
                }

                oOutputStream.close();
                fOutputStrem.close();
            } catch (Exception e) {
                System.out.println("Line 24; GerenciadorDeArquivos: " + e);
            }
        }
    }

    public static Componente[] lerArquivoDaClasse(Class<?> classe) throws IOException {

        try {
            FileInputStream fInput = new FileInputStream(
                    new File("project/code/data/" + classe.getSimpleName() + ".txt"));
            ObjectInputStream oInput = new ObjectInputStream(fInput);

            Componente[] compList = new Componente[1000];
            int compIter = 0;

            while (true) {
                try {
                    Componente readComp = (Componente) oInput.readObject();
                    if (readComp != null) {
                        compList[compIter] = readComp;
                    }
                    compIter++;
                } catch (EOFException e) {
                    oInput.close();
                    return compList;
                }
            }
        }catch(FileNotFoundException fileE){
            new File("project/code/data/" + classe.getSimpleName() + ".txt").createNewFile();
            
            return null;
        }catch(EOFException eofe){
            return new Componente[1000];
        } catch (Exception e) {
            System.out.println("Line 53; GerenciadorDeArquivos: " + e);
            return null;
        }

    }
}