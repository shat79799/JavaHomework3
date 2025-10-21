package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel titleLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel messageLabel;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JButton registerButton;
	private JButton loginButton;
	
	private LoginController lc = new LoginController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleLabel = new JLabel("飲料訂購系統");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		titleLabel.setBounds(50, 30, 400, 30);
		contentPane.add(titleLabel);
		
		usernameLabel = new JLabel("username");
		usernameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(30, 100, 100, 30);
		contentPane.add(usernameLabel);
		
		passwordLabel = new JLabel("password");
		passwordLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(30, 150, 100, 30);
		contentPane.add(passwordLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		usernameTextField.setBounds(200, 100, 250, 30);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		passwordTextField.setBounds(200, 150, 250, 30);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		registerButton = new JButton("Register");
		registerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		registerButton.setBounds(50, 220, 150, 30);
		contentPane.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goRegister();
			}
		});
		
		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		loginButton.setBounds(300, 220, 150, 30);
		contentPane.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login(usernameTextField.getText(), passwordTextField.getText());
			}
		});
		
		messageLabel = new JLabel();
		messageLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setBounds(100, 300, 300, 30);
		contentPane.add(messageLabel);
	}  
	
	private void login(String username, String password) {
		if (lc.login(username, password) == true) {
			messageLabel.setText(null);
			
			MenuView mv = new MenuView();
			mv.setVisible(true);
			
			dispose();
		} else {
			messageLabel.setText("登入失敗, 確認帳號密碼是否有效");
			messageLabel.setForeground(Color.RED);
		}
	}
	
	private void goRegister() {
		RegisterView rv = new RegisterView();
		rv.setVisible(true);
		
		dispose();
	}
}
