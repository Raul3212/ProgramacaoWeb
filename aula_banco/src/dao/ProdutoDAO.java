package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexao.ConnectionFactory;
import entity.Produto;

public class ProdutoDAO {

public List<Produto> listAll(){
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "select * from produto";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				produtos.add(new Produto(rs.getLong("id"), rs.getString("nome"), 
						rs.getString("descricao"), rs.getDouble("preco")));
			}
			
			return produtos;
			
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
	
	public Produto getById(long id){
		
		Produto produto = null;
		Connection con = ConnectionFactory.getConnection();
		String sql = "select * from produto where id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				produto = new Produto(rs.getLong("id"), rs.getString("nome"), 
						rs.getString("descricao"), rs.getDouble("preco"));
			}
			
			return produto;
			
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
	
	public boolean insert(Produto p){
		
		Connection con = ConnectionFactory.getConnection();
		String sql = "insert into produto(nome, descricao, preco) values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getDescricao());
			ps.setDouble(3, p.getPreco());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(int id, Produto p){
		Connection con = ConnectionFactory.getConnection();
		String sql = "update produto set nome = ?, descricao = ?, preco = ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getDescricao());
			ps.setDouble(3, p.getPreco());
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
		String sql = "delete from produto where id = ?";
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
