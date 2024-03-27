package DisciplinasCRUD;

public class Main {
    public static void main(String[] args) {
        //salvando
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("Web I");
        disciplina.setCurso("BSI");
        disciplinaDAO.salve(disciplina);
        //mostrando
        for (Disciplina d: disciplinaDAO.getDisciplinas()){
            System.out.println(d.getId());
            System.out.println(d.getNome());
            System.out.println(d.getCurso());
        }
        //atualizando
        Disciplina d1 = new Disciplina();
        d1.setNome("Web II");
        d1.setCurso("BSI");
        d1.setId(1);
        disciplinaDAO.update(d1);
        //deletando
        disciplinaDAO.delete(1);
    }
}
