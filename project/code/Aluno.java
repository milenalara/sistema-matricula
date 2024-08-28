public class Aluno extends Usuario{
    private Disciplina[] disciplinas;

    public void matricularEmDisciplina(Disciplina disciplina){
        

    }

    public void cancelarDisciplina(Disciplina disciplina){
        
    }

    public void pagarDisciplina(Disciplina disciplina){
        
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {

        String infos = "Login: " + this.getLogin()+
        "Senha: " + this.getSenha()+
        "Disciplinas em estudo: ";

        for (Disciplina disciplina : disciplinas) {
            infos = infos + disciplina.getNome();            
        }

        return infos;

    }

    public Aluno(String login, String senha){
        super(login, senha);
        Aluno.addToList(this);
    }
    
}

