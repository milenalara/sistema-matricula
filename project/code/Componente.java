import java.io.Serializable;
import java.util.Random;

public class Componente implements Serializable {
    private final String ID = String.valueOf(new Random().nextInt(5000));

    private static Componente[] componentes = new Componente[1000];

    public Componente() {
        addToList(this);
    }

    public static Componente getById(String identifier) {

        for (Componente componente : componentes) {
            if (componente != null) {
                if (identifier == componente.getId()) {
                    return componente;
                }
                ;
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado"); // Mudar para exception
        return null;
    }

    public static void addToList(Componente comp) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] == null) {
                componentes[i] = comp;
                break;
            }
        }
    }

    public String getId() {
        return ID;
    }

    public static Componente[] getAll() {
        return componentes;
    }

    public static void setAll(Componente[] componentes) {
        Componente.componentes = componentes;
    }

    public static void printAllComponents() {
        for (Componente componente : componentes) {
            System.out.println(componente.toString());
        }
    }

}
