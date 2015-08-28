
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Aluno;

public class AlunoDAO {
    public void cadastrar(Aluno aluno) throws Exception{
        String nome = aluno.getNome();
        String email = aluno.getEmail();
        String telefone = aluno.getTelefone();
        
        PreparedStatement ps = ConexaoDB.getConexao().prepareStatement("insert into "
                + "aluno(nome,email,telefone) values(?,?,?)");
        ps.setString(1, nome);
        ps.setString(2, email);
        ps.setString(3, telefone);
        ps.execute();
    }
    
    public Aluno consultar(int id)throws Exception{
        PreparedStatement ps = ConexaoDB.getConexao().prepareStatement("select * from aluno where id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");
            
            return new Aluno(id,nome,email,telefone);
            
        }else{
            return null;
        }
        
    }
    
    public void atualizar(Aluno aluno) throws Exception{
        PreparedStatement ps = ConexaoDB.getConexao().prepareStatement("update aluno set nome=?,"
                + " email=?,telefone=? where id=?");
        ps.setString(1, aluno.getNome());
        ps.setString(2, aluno.getEmail());
        ps.setString(3, aluno.getTelefone());
        ps.setInt(4, aluno.getId());
        ps.execute();
    }
    public void excluir(Aluno aluno) throws Exception{
        PreparedStatement ps = ConexaoDB.getConexao().prepareStatement("delete from aluno where id=?");
        ps.setInt(1, aluno.getId());
        ps.execute();
    }
    
    
}
