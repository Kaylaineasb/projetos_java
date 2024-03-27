package DisciplinasCRUD;

import DisciplinasCRUD.Disciplina;
import DisciplinasCRUD.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DisciplinaDAO {

    public void salve(Disciplina disciplina){
        String sql = "INSERT INTO disciplinas (nome,curso) VALUES (?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = FabricaConexao.createCon();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1,disciplina.getNome());
            pstm.setString(2,disciplina.getCurso());
            pstm.execute();
            System.out.println("Disciplina salva");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (conn!=null){
                    conn.close();
                }
                if (pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Disciplina> getDisciplinas(){
        String sql = "SELECT * FROM disciplinas";
        List<Disciplina> disciplinas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn = FabricaConexao.createCon();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()){
                Disciplina disciplina = new Disciplina();
                disciplina.setNome(rset.getString("nome"));
                disciplina.setCurso(rset.getString("curso"));
                disciplinas.add(disciplina);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (conn!=null){
                    conn.close();
                }
                if (pstm!=null){
                    pstm.close();
                }
                if (rset!=null){
                    rset.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return disciplinas;
    }

    public void update(Disciplina disciplina){
        String sql = "UPDATE disciplinas SET nome = ?, curso = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = FabricaConexao.createCon();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1,disciplina.getNome());
            pstm.setString(2,disciplina.getCurso());
            pstm.setInt(3,disciplina.getId());
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (conn!=null){
                    conn.close();
                }
                if (pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void delete(int id){
        String sql = "Delete from disciplinas WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = FabricaConexao.createCon();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1,id);
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (conn!=null){
                    conn.close();
                }
                if (pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
