public class Secretario extends Usuario{
    
    public Secretario(String login, String senha) {
        super(login, senha);
    }

    public static void gerarCurriculo(){
        System.out.println("Cursos:");
        for (Componente curso : Curso.getAll()) {
            System.out.println(curso.toString());
        }

        System.out.println("Professores:");
        for (Componente professor : Professor.getAll()) {
            System.out.println(professor.toString());
        }
    }

    public static String gerarInformacoes(Object object){
        return object.toString(); //todo:Rever funçao 
    }



}
    
    