package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] levels = {"Nivel 1", "Nivel 2", "Nivel 3"};
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlay = new JButton("Jogar");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPlay.setBounds(161, 209, 117, 25);
		contentPane.add(btnPlay);
		
		JComboBox cbLevel = new JComboBox(levels);
		cbLevel.setBounds(125, 143, 198, 24);
		cbLevel.setSelectedIndex(0);
		contentPane.add(cbLevel);
		
		JLabel lblSi = new JLabel("SI-LA-BA-DOR");
		lblSi.setFont(new Font("Dialog", Font.BOLD, 26));
		lblSi.setBounds(125, 27, 212, 25);
		contentPane.add(lblSi);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtName.setToolTipText("Seu nome");
		txtName.setBounds(135, 106, 168, 25);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblDigiteSeuNome = new JLabel("Digite seu nome");
		lblDigiteSeuNome.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDigiteSeuNome.setBounds(147, 75, 166, 30);
		contentPane.add(lblDigiteSeuNome);
	}
}
