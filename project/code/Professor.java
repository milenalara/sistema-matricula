public class Professor extends Usuario{
    
    public Professor(String login, String senha) {
        super(login, senha);
    }

    public void consultarMatriculas(Turma turma){
        Aluno[] alunos = turma.getAlunos();

        if(alunos.length <= 0){
            System.out.println("Não possui alunos matriculados nessa diciplina");
        }else{
            System.out.println("Alunos matriculados na turma da diciplina: " + turma.getDisciplina().getNome() + ": ");

            for(Aluno aluno : alunos){
                System.out.println(aluno.getLogin());
            }
        }
    }

}
