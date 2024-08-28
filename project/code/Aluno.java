public class Aluno extends Usuario {
    private Disciplina[] disciplinas;

    public void matricularEmDisciplina(Disciplina disciplina) {

    }

    public void cancelarDisciplina(Disciplina disciplina) {

    }

    public void pagarDisciplina(Disciplina disciplina) {

    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {

        String infos = "Login: " + this.getLogin() +
                "Senha: " + this.getSenha() +
                "Disciplinas em estudo: ";

        for (Disciplina disciplina : disciplinas) {
            infos = infos + disciplina.getNome();
        }

        return infos;

    }

    public Aluno(String login, String senha) {
        super(login, senha);
        Aluno.addToList(this);
    }

    public static void deserialize() {
        String[] linhas = GerenciadorDeArquivos.readFile("./Test.txt");
        for (String linha : linhas) {
            if (linha == null) {
                break;
            }
            String[] data = linha.split("\t");
            String login = data[0];
            System.out.println("login: " + login);
            String senha = data[1];
            System.out.println("senha: " + senha);


            for (int i = 2; i < data.length; i++) {
                if (data[i] == null) {
                    break;
                }
                System.out.println("disciplina " + (i-1) + ": " + data[i]);
            }
        }
    }

}
