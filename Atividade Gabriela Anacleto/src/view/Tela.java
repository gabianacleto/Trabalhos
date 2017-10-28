package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import persistencia.Conexao;
import persistencia.UserSistemaDAO;

public class Tela extends JFrame{
Conexao conecta = new Conexao();
	
	private JLabel titulo = new JLabel("Tela de Login");
	private JLabel lblLogin = new JLabel("Login ");
	private JTextField txtLogin = new JTextField("");
	private JLabel lblSenha = new JLabel("Senha ");
	private JPasswordField txtSenha = new JPasswordField();
	private JButton btnEntrar = new JButton("Entrar");
	
	public Tela() {
		JOptionPane.showMessageDialog(null , "Usuario logado com sucesso!");
	}
	}
