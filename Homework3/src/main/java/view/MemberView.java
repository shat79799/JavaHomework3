package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.MemberController;
import model.MyMember;

public class MemberView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel addressLabel;
	private JLabel phoneLabel;
	private JLabel resultLabel;
	private JTextField nameTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField addressTextField;
	private JTextField phoneTextField;
	private JButton backButton;
	private JButton updateButton;
	
	private MemberController mc = new MemberController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberView frame = new MemberView();
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
	public MemberView() {
		MyMember m = mc.getCurrentMember();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleLabel = new JLabel("Your profile");
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
		nameTextField.setEnabled(true);
		nameTextField.setEditable(true);
		nameTextField.setBounds(200, 100, 250, 30);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setText(m.getName());
		
		usernameTextField = new JTextField();
		usernameTextField.setEnabled(false);
		usernameTextField.setEditable(false);
		usernameTextField.setBounds(200, 150, 250, 30);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		usernameTextField.setText(m.getUsername());
		
		passwordTextField = new JTextField();
		passwordTextField.setEnabled(false);
		passwordTextField.setEditable(false);
		passwordTextField.setBounds(200, 200, 250, 30);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		passwordTextField.setText(m.getPassword());
		
		addressTextField = new JTextField();
		addressTextField.setEnabled(true);
		addressTextField.setEditable(true);
		addressTextField.setBounds(200, 250, 250, 30);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);
		addressTextField.setText(m.getAddress());
		
		phoneTextField = new JTextField();
		phoneTextField.setEnabled(true);
		phoneTextField.setEditable(true);
		phoneTextField.setBounds(200, 300, 250, 30);
		contentPane.add(phoneTextField);
		phoneTextField.setColumns(10);
		phoneTextField.setText(m.getPhone());
		
		resultLabel = new JLabel();
		resultLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setBounds(100, 350, 300, 30);
		contentPane.add(resultLabel);
		
		backButton = new JButton("Go back");
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		backButton.setBounds(50, 400, 150, 30);
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		
		updateButton = new JButton("Update info");
		updateButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		updateButton.setBounds(300, 400, 150, 30);
		contentPane.add(updateButton);
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mc.isUpdatingMemberInfoSuccess(nameTextField.getText(), addressTextField.getText(), phoneTextField.getText())) {
					resultLabel.setText("更新成功");
					resultLabel.setForeground(Color.BLACK);
				} else {
					resultLabel.setText("更新失敗, 請確認資料格式是否有誤");
					resultLabel.setForeground(Color.RED);
				}
			}
		});
		
	}
	
	private void goBack() {
		MenuView mv = new MenuView();
		mv.setVisible(true);
		
		dispose();
	}

}
