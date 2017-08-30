package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import interface2.App;
import model.UserSistema;

public class LoginPanel extends JPanel{

	private App app;
	private JLabel tituloPanel = new JLabel ("Interface Java"); 
	private JLabel lblLogin = new JLabel ("Login"); 
	private JTextField txtLogin  =  new JTextField("");
	private JLabel lblSenha = new JLabel ("Senha"); 
	private JPasswordField passFieldSenha = new JPasswordField("");
	private JButton btnEntrar = new JButton ("Entrar");
	
	public LoginPanel(App app){
		this.app = app;
		this.add(this.tituloPanel);
		
		//Posicionando o Login
		JPanel loginPanel = new JPanel(new FlowLayout());
		loginPanel.setPreferredSize(new Dimension(150, 150));
		loginPanel.setBackground(Color.BLUE);
		loginPanel.add(lblLogin);
		loginPanel.add(txtLogin);
		
		
		lblLogin.setBounds(10, 10, 50, 50);
		txtLogin.setBounds(10, 10, 50, 50);
		
		
		//Posicionando a Senha
		JPanel senhaPanel = new JPanel(new FlowLayout());
		senhaPanel.setBackground(Color.black);
		senhaPanel.add(lblSenha);
		senhaPanel.add(passFieldSenha);
		
		lblSenha.setBounds(10, 10, 50, 50);
		txtLogin.setBounds(10, 10, 50, 50);
		
		this.btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {			

				String nomeDoUsuarioQueQuerLogar = LoginPanel.this.txtLogin.getText(); 
				String senhaDoUsuarioQueQuerLogar = LoginPanel.this.passFieldSenha.getText();
				System.out.println();
				App app2 = LoginPanel.this.app;
				List<UserSistema> usuariosCadastrados = LoginPanel.this.app.getUsuariosCadastrados();
				
				for (UserSistema u : LoginPanel.this.app.getUsuariosCadastrados()) {
					if(u.getLogin().equals(nomeDoUsuarioQueQuerLogar) && u.getSenha().equals(senhaDoUsuarioQueQuerLogar)) {
						LoginPanel.this.app.getUsuariosLogados().add(u);
						System.out.println("Usuario logado com sucesso");
						System.out.println(u.getNome());
						System.out.println(u.getLogin());
						break;
					}//if
				}//for
				System.out.println("Usuario ou Senha nao conferem!!!");
			}
		});		
		this.add(tituloPanel);
		this.add(loginPanel);
		this.add(senhaPanel);
		this.add(btnEntrar);
	}
	
}
