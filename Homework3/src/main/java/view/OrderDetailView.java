package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.MyTableModel;

public class OrderDetailView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton backButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetailView frame = new OrderDetailView();
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
	public OrderDetailView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//        String[] columnNames = {"Name", "Age"};
//        Object[][] data = {{"Alice", 25}, {"Bob", 30}, {"Charlie", 35}};
//        DefaultTableModel model = new DefaultTableModel(data, columnNames);
		MyTableModel test = new MyTableModel();
		System.out.println(test.getColumnCount());
		System.out.println(test.getRowCount());
        JTable table = new JTable(new MyTableModel());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 600, 350);
        contentPane.add(scrollPane);

		backButton = new JButton("Go back");
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		backButton.setBounds(200, 420, 300, 30);
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
	}
	
	private void goBack() {
		MenuView mv = new MenuView();
		mv.setVisible(true);
		
		dispose();
	}

}
