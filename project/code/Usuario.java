import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Usuario{
    private String login;
    private String senha;
    private static Usuario[] usuarios = new Usuario[1000];

    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static void lerArquivoUsuario() throws FileNotFoundException{

        Scanner scan = new Scanner(new File("project/code/Usuarios.txt"));

        int iterUsuario = 0;

        while(scan.hasNextLine()){

            String[] line = scan.nextLine().split("\t");

            usuarios[iterUsuario] = new Usuario(line[0], line[1]);
            
        }
        scan.close();
    }

    public void salvarUsuario() throws IOException{
        
        BufferedWriter escritor = new BufferedWriter(new FileWriter("project/code/Usuarios.txt", true));
        
        escritor.append(login);
        escritor.append("\t");
        escritor.append(senha);
        escritor.append("\n");

        escritor.close();
    }

    @Override
    public String toString() {
        return this.login + "\t" + this.senha;
    }

    public static Usuario[] getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(Usuario[] usuarios) {
        Usuario.usuarios = usuarios;
    }

    

    
}