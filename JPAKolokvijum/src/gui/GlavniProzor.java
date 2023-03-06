package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor window = new GlavniProzor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlavniProzor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUnosPacijenta = new JButton("Unos pacijenta");
		btnUnosPacijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DUnosPacijenta dup=new DUnosPacijenta();
				dup.setVisible(true);
			}
		});
		btnUnosPacijenta.setBounds(58, 35, 295, 21);
		frame.getContentPane().add(btnUnosPacijenta);
		
		JButton btnUnosPregleda = new JButton("Unos pregleda");
		btnUnosPregleda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DUnosPregleda dupr=new DUnosPregleda();
				dupr.setVisible(true);
			}
		});
		btnUnosPregleda.setBounds(58, 91, 295, 21);
		frame.getContentPane().add(btnUnosPregleda);
		
		JButton btnBrisanjePacijenta = new JButton("Brisanje pacijenta");
		btnBrisanjePacijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBrisanjePacijenta dbp=new DBrisanjePacijenta();
				dbp.setVisible(true);
			}
		});
		btnBrisanjePacijenta.setBounds(58, 147, 295, 21);
		frame.getContentPane().add(btnBrisanjePacijenta);
		
		JButton btnPrikaz = new JButton("Prikaz pregleda");
		btnPrikaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DPrikazPregleda dpp=new DPrikazPregleda();
				dpp.setVisible(true);
			}
		});
		btnPrikaz.setBounds(58, 203, 295, 21);
		frame.getContentPane().add(btnPrikaz);
	}
}
