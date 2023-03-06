package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import crud.PacijentCrud;
import crud.PregledCrud;
import model.Pacijent;
import model.Pregled;

public class DPrikazPregleda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<Pacijent> cbPacijent;
	private PacijentCrud pc=new PacijentCrud();
	private JTable table;
	private PregledCrud prc=new PregledCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPrikazPregleda dialog = new DPrikazPregleda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPrikazPregleda() {
		setTitle("Prozor za prikaz pregleda ");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblPacijent = new JLabel("Izaberite pacijenta:");
				panel.add(lblPacijent);
			}
			{
				cbPacijent = new JComboBox<Pacijent>();
				panel.add(cbPacijent);
				List<Pacijent> pacijenti=pc.sviPacijenti();
				for(Pacijent pac: pacijenti) {
					cbPacijent.addItem(pac);
				}
			}
			{
				JButton btnPrikazi = new JButton("Prikazi");
				btnPrikazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Pacijent pacijent=(Pacijent) cbPacijent.getSelectedItem();
						List<Pregled> pregledi=prc.prikazSvihPregledaPacijenta(pacijent);
						TableModelPrikaz tmp=new TableModelPrikaz(pregledi);
						table.setModel(tmp);
					}
				});
				panel.add(btnPrikazi);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Zatvori");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
