package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.UserSistema;
import model.Pessoa;
import persistencia.Conexao;

public class UserSistemaDAO {

Connection Conn;
	
	public UserSistemaDAO(){
				
	}
	
	public void inserir(UserSistema a) throws Exception{
		Conexao daolog = new Conexao();
		String sql = "INSERT INTO alunos(nome) values('"+a.getLogin()+"')";
		System.out.println(sql);		
		PreparedStatement stm = Conn.prepareStatement(sql);
		stm.executeUpdate();
	}
	
	
	public boolean checkLogin (String login,String senha) throws Exception {
		Connection conn = Conexao.getMysqlConnection();
		String sql ="SELECT * FROM tblUser WHERE login = ? AND senha = ?";
		boolean check = false;
		
		PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, login);
			
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}else {
				JOptionPane.showMessageDialog(null, "Usuario ou senha estão invalidos");
			}
		return check;
		
}
	}