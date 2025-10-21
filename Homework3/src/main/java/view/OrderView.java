package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import config.MyProduct;
import controller.OrderController;
import util.Tool;

public class OrderView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static JLabel titleLabel = new JLabel();;
	private JTextField nameTextField;
	private JTextField product1TextField;
	private JTextField product2TextField;
	private JTextField product3TextField;
	private JTextField product4TextField;
	private JLabel calculateLabel;
	private JCheckBox payCheckBox;
	private JCheckBox vipCheckBox;
	private JTextArea resultTextArea;
	
	final String title = "";
	final String nameTitle = "顧客姓名";
	final String totalTitle = "小計";
	final String saveButtonTitle = "儲存訂單";
	final String resetButtonTitle = "清除訂單";
	final String pdfButtonTitle = "列印收據";
	final String excelButtonTitle = "匯出報表";
	final String payCheckBoxTitle = "使用電子支付(滿1500可享有87折優惠)";
	final String vipCheckBoxTitle = "使用VVIP(可享有4折優惠, 優先計算)";
	
	private boolean isBlackTeaCountError = false;
	private boolean isGreenTeaCountError = false;
	private boolean isOolongTeaCountError = false;
	private boolean isMilkTeaCountError = false;
	private OrderController oc = new OrderController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderView frame = new OrderView();
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
	public OrderView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		titlePanel.setBounds(10, 10, 460, 40);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		titleLabel = new JLabel(title);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 0, 460, 40);
		titlePanel.add(titleLabel);
		
		JPanel namePanel = new JPanel();
		namePanel.setBackground(Color.WHITE);
		namePanel.setBounds(60, 60, 150, 40);
		contentPane.add(namePanel);
		namePanel.setLayout(null);
		
		JLabel nameLabel = new JLabel(nameTitle);
		nameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		nameLabel.setBounds(10, 0, 130, 40);
		namePanel.add(nameLabel);
		
		JPanel product1Panel = new JPanel();
		product1Panel.setBackground(Color.WHITE);
		product1Panel.setBounds(60, 110, 150, 40);
		contentPane.add(product1Panel);
		product1Panel.setLayout(null);
		
		JLabel product1Label = new JLabel(MyProduct.BlackTea.getDescription() + "($" + MyProduct.BlackTea.getPrice() + ")");
		product1Label.setHorizontalAlignment(SwingConstants.TRAILING);
		product1Label.setBounds(10, 0, 130, 40);
		product1Panel.add(product1Label);
		
		JPanel product2Panel = new JPanel();
		product2Panel.setBackground(Color.WHITE);
		product2Panel.setBounds(60, 160, 150, 40);
		contentPane.add(product2Panel);
		product2Panel.setLayout(null);
		
		JLabel product2Label = new JLabel(MyProduct.GreenTea.getDescription() + "($" + MyProduct.GreenTea.getPrice() + ")");
		product2Label.setHorizontalAlignment(SwingConstants.TRAILING);
		product2Label.setBounds(10, 0, 130, 40);
		product2Panel.add(product2Label);
		
		JPanel product3Panel = new JPanel();
		product3Panel.setBackground(Color.WHITE);
		product3Panel.setBounds(60, 210, 150, 40);
		contentPane.add(product3Panel);
		product3Panel.setLayout(null);
		
		JLabel product3Label = new JLabel(MyProduct.OolongTea.getDescription() + "($" + MyProduct.OolongTea.getPrice() + ")");
		product3Label.setHorizontalAlignment(SwingConstants.TRAILING);
		product3Label.setBounds(10, 0, 130, 40);
		product3Panel.add(product3Label);
		
		JPanel product4Panel = new JPanel();
		product4Panel.setBackground(Color.WHITE);
		product4Panel.setBounds(60, 260, 150, 40);
		contentPane.add(product4Panel);
		product4Panel.setLayout(null);
		
		JLabel product4Label = new JLabel(MyProduct.MilkTea.getDescription() + "($" + MyProduct.MilkTea.getPrice() + ")");
		product4Label.setHorizontalAlignment(SwingConstants.TRAILING);
		product4Label.setBounds(10, 0, 130, 40);
		product4Panel.add(product4Label);
			
		JPanel totalPanel = new JPanel();
		totalPanel.setBackground(Color.WHITE);
		totalPanel.setBounds(60, 310, 150, 40);
		contentPane.add(totalPanel);
		totalPanel.setLayout(null);
		
		JLabel totalLabel = new JLabel(totalTitle);
		totalLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		totalLabel.setBounds(10, 0, 130, 40);
		totalPanel.add(totalLabel);
		
		nameTextField = new JTextField();
		nameTextField.setEnabled(false);
		nameTextField.setEditable(false);
		nameTextField.setBounds(220, 60, 200, 40);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setText(oc.getCurrentMember().getName());
		
		product1TextField = new JTextField();
		product1TextField.setBounds(220, 110, 200, 40);
		contentPane.add(product1TextField);
		product1TextField.setColumns(10);
		product1TextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	updateAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	updateAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	updateAmount();
            }
        });
		
		product2TextField = new JTextField();
		product2TextField.setBounds(220, 160, 200, 40);
		contentPane.add(product2TextField);
		product2TextField.setColumns(10);
		product2TextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	updateAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	updateAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	updateAmount();
            }
        });
		
		product3TextField = new JTextField();
		product3TextField.setBounds(220, 210, 200, 40);
		contentPane.add(product3TextField);
		product3TextField.setColumns(10);
		product3TextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	updateAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	updateAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	updateAmount();
            }
        });
		
		product4TextField = new JTextField();
		product4TextField.setBounds(220, 260, 200, 40);
		contentPane.add(product4TextField);
		product4TextField.setColumns(10);
		product4TextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	updateAmount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	updateAmount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	updateAmount();
            }
        });
		
		JPanel calculatePanel = new JPanel();
		calculatePanel.setBackground(Color.WHITE);
		calculatePanel.setBounds(220, 310, 200, 40);
		contentPane.add(calculatePanel);
		calculatePanel.setLayout(null);
		
		calculateLabel = new JLabel("$");
		calculateLabel.setBounds(10, 0, 180, 40);
		calculatePanel.add(calculateLabel);
		
		payCheckBox = new JCheckBox(payCheckBoxTitle);
		payCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		payCheckBox.setBounds(10, 360, 460, 30);
		contentPane.add(payCheckBox);
		payCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				updateAmount();
			}
		});
		
		vipCheckBox = new JCheckBox(vipCheckBoxTitle);
		vipCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		vipCheckBox.setBounds(10, 390, 460, 30);
		contentPane.add(vipCheckBox);
		vipCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				updateAmount();
			}
		});
		
		resultTextArea = new JTextArea();
		resultTextArea.setBounds(10, 470, 460, 180);
		contentPane.add(resultTextArea);
		
		JButton saveButton = new JButton(saveButtonTitle);
		saveButton.setBounds(10, 430, 90, 30);
		contentPane.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if (isBlackTeaCountError || isGreenTeaCountError || isOolongTeaCountError || isMilkTeaCountError) {
		    		showError();
		    	} else {
		    		showRecipt();
		    	}
		    }
		});
		
		JButton resetButton = new JButton(resetButtonTitle);
		resetButton.setBounds(130, 430, 90, 30);
		contentPane.add(resetButton);
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetUI();
			}
		});
		
		JButton pdfButton = new JButton(pdfButtonTitle);
		pdfButton.setBounds(260, 430, 90, 30);
		contentPane.add(pdfButton);
		pdfButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					resultTextArea.print();
				} catch (PrinterException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
		    }
		});
		
		JButton excelButton = new JButton(excelButtonTitle);
		excelButton.setBounds(380, 430, 90, 30);
		contentPane.add(excelButton);
		excelButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	oc.exportExcel();
		    }
		});
		
		oc.resetCurrentOrder();
		setTimer();
	}
	
	private void updateBlackTea() {
		try {
			if (product1TextField.getText().length() > 0) {
				int product1Count = Integer.parseInt(product1TextField.getText());
				if (product1Count >= 0) {
					oc.setBlackTeaCount(product1Count);
					isBlackTeaCountError = false;
				}
			} else {
				oc.setBlackTeaCount(0);
				isBlackTeaCountError = false;
			}
		} catch (NumberFormatException e) {
			isBlackTeaCountError = true;
		}
	}
	
	private void updateGreenTea() {
		try {
			if (product2TextField.getText().length() > 0) {
				int product2Count = Integer.parseInt(product2TextField.getText());
				if (product2Count >= 0) {
					oc.setGreenTeaCount(product2Count);
					isGreenTeaCountError = false;
				}
			} else {
				oc.setGreenTeaCount(0);
				isGreenTeaCountError = false;
			}
		} catch (NumberFormatException e) {
			isGreenTeaCountError = true;
		}
	}
	
	private void updateOolongTea() {
		try {
			if (product3TextField.getText().length() > 0) {
				int product3Count = Integer.parseInt(product3TextField.getText());
				if (product3Count >= 0) {
					oc.setOolongTeaCount(product3Count);
					isOolongTeaCountError = false;
				}
			} else {
				oc.setOolongTeaCount(0);
				isOolongTeaCountError = false;
			}
		} catch (NumberFormatException e) {
			isOolongTeaCountError = true;
		}
	}
	
	private void updateMilkTea() {
		try {
			if (product4TextField.getText().length() > 0) {
				int product4Count = Integer.parseInt(product4TextField.getText());
				if (product4Count >= 0) {
					oc.setMilkTeaCount(product4Count);
					isMilkTeaCountError = false;
				}
			} else {
				oc.setMilkTeaCount(0);
				isMilkTeaCountError = false;
			}
		} catch (NumberFormatException e) {
			isMilkTeaCountError = true;
		}
	}
	
	private void updateAmount() {
		updateBlackTea();
		updateGreenTea();
		updateOolongTea();
		updateMilkTea();
		
		if (isBlackTeaCountError || isGreenTeaCountError || isOolongTeaCountError || isMilkTeaCountError) {
			showError();
		} else {
			calculateLabel.setText("$ " + oc.calculate(vipCheckBox.isSelected(), payCheckBox.isSelected()));
			calculateLabel.setForeground(Color.BLACK);
		}
	}
	
	private void resetUI() {
		oc.resetCurrentOrder();
		
		nameTextField.setText(oc.getCurrentMember().getName());
		product1TextField.setText(null);
		product2TextField.setText(null);
		product3TextField.setText(null);
		product4TextField.setText(null);
		payCheckBox.setSelected(false);
		vipCheckBox.setSelected(false);
		resultTextArea.setText(null);
		
		updateAmount();
	}
	
	private void showRecipt() {
		String time = "結帳時間: " + getLocalTimeNow();
		String username = "客戶: " + nameTextField.getText();
		String blackTea = "紅茶: " + oc.getCurrentOrder().getBlackTea() + "杯, 共 " + oc.getBlackTeaTotal() + "元";
		String greenTea = "綠茶: " + oc.getCurrentOrder().getGreenTea() + "杯, 共 " + oc.getGreenTeaTotal() + "元";
		String oolongTea = "烏龍茶: " + oc.getCurrentOrder().getOolongTea() + "杯, 共 " + oc.getOolongTeaTotal() + "元";
		String milkTea = "奶茶: " + oc.getCurrentOrder().getMilkTea() + "杯, 共 " + oc.getMilkTeaTotal() + "元";
		String total = "共" + oc.calculate(vipCheckBox.isSelected(), payCheckBox.isSelected()) + "元 (最後顯示金額為四捨五入至整數)";
		
		String recipt = time + "\n" + username + "\n" + blackTea + "\n" + greenTea + "\n" + oolongTea + "\n" + milkTea + "\n" + total;
		resultTextArea.setText(recipt);
		
		oc.saveCurrentOrder();
	}
	
	private void showError() {
		String errorMessage = "輸入內容有誤, 請重新確認!";
		calculateLabel.setText(errorMessage);
		calculateLabel.setForeground(Color.RED);
	}
	
	private static String getLocalTimeNow() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return now.format(dtf);
	}
	
	private static void setTimer() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
					titleLabel.setText("現在時間: " + getLocalTimeNow());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }, 0, 1000);
	}

}
