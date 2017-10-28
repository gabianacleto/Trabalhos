package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
import persistencia.Conexao;
import persistencia.UserSistemaDAO;

public class LoginPanel extends JFrame{
	Conexao conecta = new Conexao();
	
	private JLabel titulo = new JLabel("Tela de Login");
	private JLabel lblLogin = new JLabel("Login ");
	private JTextField txtLogin = new JTextField("");
	private JLabel lblSenha = new JLabel("Senha ");
	private JPasswordField txtSenha = new JPasswordField();
	private JButton btnEntrar = new JButton("Entrar");
	
	public LoginPanel() {
		this.add(this.titulo);
		this.setSize(300,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		
		lblLogin.setBounds(40,20,50,25);
		add(lblLogin);
		txtLogin.setBounds(40,45,200,25);
		add(txtLogin);
		
		lblSenha.setBounds(40,70,100,25);
		add(lblSenha);
		txtSenha.setBounds(40,90,200,25);
		add(txtSenha);

		btnEntrar.setBounds(50,145,100,25);
		add(btnEntrar);
		
		this.btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				// Fazer a validação do login com o banco de dados e verificar o nivel de acesso
					UserSistemaDAO dao = new UserSistemaDAO();
					
					try {
						if(dao.checkLogin(txtLogin.getText(), String.valueOf(txtSenha.getPassword()))) {
							new Tela().setVisible(true);
							dispose();
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao validar: "+e1);
					}
				// FIM
				
			}
		});
	}
	
	public static void main(String[] args) {
		new LoginPanel();
	}
	
}
