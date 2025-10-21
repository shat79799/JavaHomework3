package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MenuController;
import model.MyMember;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class MenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private MenuController mc = new MenuController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
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
	public MenuView() {
		MyMember m = mc.getCurrentMember();
		String weather = mc.getCurrentWeather();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Welcome, " + m.getName());
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		titleLabel.setBounds(50, 50, 400, 30);
		contentPane.add(titleLabel);
		
		JLabel subtitleLabel = new JLabel(weather);
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subtitleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		subtitleLabel.setBounds(50, 100, 400, 30);
		contentPane.add(subtitleLabel);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(150, 300, 200, 50);
		contentPane.add(logoutButton);
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goLogin();
			}
		});
		
		JButton memberButton = new JButton("Your profile");
		memberButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		memberButton.setBounds(50, 150, 150, 100);
		contentPane.add(memberButton);
		memberButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				goMember();
			}
		});
		
		JButton orderButton = new JButton(m.getRole() == 1 ? "Order Detail" : "Order");
		orderButton.setBounds(300, 150, 150, 100);
		contentPane.add(orderButton);
		orderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (m.getRole() == 1) {
					goOrderDetail();
				} else {
					goOrder();
				}
			}
		});
	}
	
	private void goMember() {
		MemberView mv = new MemberView();
		mv.setVisible(true);
		
		dispose();
	}
	
	private void goOrder() {
		OrderView ov = new OrderView();
		ov.setVisible(true);
		
		dispose();
	}
	
	private void goOrderDetail() {
		OrderDetailView odv = new OrderDetailView();
		odv.setVisible(true);
		
		dispose();
	}
	
	private void goLogin() {
		LoginView lv = new LoginView();
		lv.setVisible(true);
		
		dispose();
	}

}
