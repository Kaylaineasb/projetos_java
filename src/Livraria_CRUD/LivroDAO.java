package Livraria_CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public void save(Livro livro) throws Exception{
        String sql = "INSERT INTO livros(nome,qtdPag,nota) VALUES(?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = FabricaConexao.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1,livro.getNome());
            pstm.setInt(2,livro.getQtdPag());
            pstm.setInt(3,livro.getNota());
            pstm.execute();
            System.out.println("Livro cadastrado");
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

    public List<Livro> exibirLivros(){
        String sql = "SELECT * FROM livros";
        List<Livro> livros = new ArrayList<>();
        Connection conn =null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try{
            conn = FabricaConexao.createConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()){
                Livro livro = new Livro();
                livro.setNome(rset.getString("nome"));
                livro.setQtdPag(rset.getInt("qtdPag"));
                livro.setNota(rset.getInt("nota"));
                livros.add(livro);
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
        return livros;
    }

    public void update(Livro livro) throws Exception{
        String sql = "UPDATE livros SET nome = ?,qtdPag= ?, nota = ? " +
                "WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = FabricaConexao.createConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, livro.getNome());
            pstm.setInt(2,livro.getQtdPag());
            pstm.setInt(3,livro.getNota());
            pstm.setInt(4,livro.getId());
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
    public void deleteById(int id){
        String sql = "DELETE FROM livros WHERE id= ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = FabricaConexao.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(conn!=null){
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
