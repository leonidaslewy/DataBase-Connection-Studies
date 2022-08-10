package persistent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Departamento;

public class DepartamentoDAO implements DAO<Departamento> {

    @Override
    public void inserir(Departamento e) {
        // criar a conexao
		Connection con = FabricaConexoes.getConexao();
		// montar o SQL
		String sql = "INSERT INTO departamento (nome) VALUES (?)";
		
		// rodar o SQL
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, e.getNome());
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
        
    }

    @Override
    public void excluir(Departamento e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Departamento> listar(int limit, int offset) {
        var departamentos = new ArrayList<Departamento>();
		// montar o SQL
		String sql = "SELECT id, nome FROM departamento LIMIT ? OFFSET ?";
		
		// rodar o SQL
		try(var con = FabricaConexoes.getConexao(); 
			var pstm = con.prepareStatement(sql);) {
			pstm.setInt(1, limit);
			pstm.setInt(2, offset);
			ResultSet resposta = pstm.executeQuery();
			while(resposta.next()) {
				var nome = resposta.getString("nome");
				var id = resposta.getInt("id");
				Departamento e = new Departamento(nome, id);
				departamentos.add(e);
			}
			pstm.close();
			
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		return departamentos;
    }

    @Override
    public void alterar(Departamento e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Departamento buscar(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
