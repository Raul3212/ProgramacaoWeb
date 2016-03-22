package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entity.Funcionario;
import entity.Produto;

public class FuncionarioDAO {

	public List<Funcionario> listAll(){
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "select * from funcionario";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				funcionarios.add(new Funcionario(rs.getLong("id"), rs.getString("nome"), 
						rs.getString("email"), rs.getDouble("salario")));
			}
			
			return funcionarios;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public Funcionario getById(int id){
		Funcionario funcionario = null;
		Connection con = ConnectionFactory.getConnection();
		String sql = "select * from produto where id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				funcionario = new Funcionario(rs.getLong("id"), rs.getString("nome"), 
						rs.getString("email"), rs.getDouble("salario"));
			}
			
			return funcionario;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public boolean insert(Funcionario f){
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "insert into funcionario(nome, email, salario) values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, f.getNome());
			ps.setString(2, f.getEmail());
			ps.setDouble(3, f.getSalario());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(int id, Funcionario f){
		Connection con = ConnectionFactory.getConnection();
		String sql = "update funcionario set nome = ?, email = ?, salario = ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, f.getNome());
			ps.setString(2, f.getEmail());
			ps.setDouble(3, f.getSalario());
			ps.setLong(4, id);
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(int id){
		Connection con = ConnectionFactory.getConnection();
		String sql = "delete from funcionario where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
}
