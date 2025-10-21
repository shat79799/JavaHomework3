package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RegisterController;
import model.MyMember;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class RegisterView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel addressLabel;
	private JLabel phoneLabel;
	private JLabel messageLabel;
	private JTextField nameTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField addressTextField;
	private JTextField phoneTextField;
	private JButton cancelButton;
	private JButton registerButton;
	
	private RegisterController rc = new RegisterController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleLabel = new JLabel("Register");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(50, 30, 400, 30);
		contentPane.add(titleLabel);
		
		nameLabel = new JLabel("name");
		nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(50, 100, 100, 30);
		contentPane.add(nameLabel);
		
		usernameLabel = new JLabel("username");
		usernameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(50, 150, 100, 30);
		contentPane.add(usernameLabel);
		
		passwordLabel = new JLabel("password");
		passwordLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(50, 200, 100, 30);
		contentPane.add(passwordLabel);
		
		addressLabel = new JLabel("address");
		addressLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setBounds(50, 250, 100, 30);
		contentPane.add(addressLabel);
		
		phoneLabel = new JLabel("phone");
		phoneLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setBounds(50, 300, 100, 30);
		contentPane.add(phoneLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(200, 100, 250, 30);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(200, 150, 250, 30);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(200, 200, 250, 30);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(200, 250, 250, 30);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);
		
		phoneTextField = new JTextField();
		phoneTextField.setBounds(200, 300, 250, 30);
		contentPane.add(phoneTextField);
		phoneTextField.setColumns(10);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		cancelButton.setBounds(50, 370, 150, 30);
		contentPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goLogin();
			}
		});
		
		registerButton = new JButton("Register");
		registerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		registerButton.setBounds(300, 370, 150, 30);
		contentPane.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				String address = addressTextField.getText();
				String phone = phoneTextField.getText();
				MyMember m = new MyMember(name, username, password, address, phone);
				
				register(m);
			}
		});
		
		messageLabel = new JLabel();
		messageLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setBounds(100, 420, 300, 30);
		contentPane.add(messageLabel);
	}
	
	private void goLogin() {
		LoginView lv = new LoginView();
		lv.setVisible(true);
		
		dispose();
	}
	
	private void register(MyMember member) {
		if (rc.register(member) == true) {
			MenuView mv = new MenuView();
			mv.setVisible(true);
			
			dispose();
		} else {
			messageLabel.setText("註冊失敗, 該帳號可能已註冊, 或是資料格式有誤");
			messageLabel.setForeground(Color.RED);
		}
	}

}
