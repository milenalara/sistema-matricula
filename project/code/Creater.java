import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Creater {

    public static Object createComponentManual(Class<?> classe, Scanner scan)
            throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {

        Object componente = classe.getDeclaredConstructor().newInstance();

        for (Field field : classe.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType().isArray()) { 

                Object lista = field.get(componente);

                System.out.println(
                        "Digite " + field.getName() + " (Digite FIM para teriminar)");
                String in = scan.nextLine();
                int iter = 0;
                while (in != "FIM") {
                    Array.set(lista, iter, in);
                    iter++;
                }

            } else {
                System.out.println("Digite o " + field.getName());
                if (field.getType() == String.class) {
                    field.set(componente, new String(scan.nextLine()));
                }
                if (field.getType() == Boolean.class) {
                    field.set(componente, scan.nextBoolean());
                }
                if (field.getType() == int.class) {
                    field.set(componente, scan.nextInt());
                }

            }
        }

        return componente;
    }

}
