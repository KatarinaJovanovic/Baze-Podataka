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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import crud.DijagnozaCrud;
import crud.LekarCrud;
import crud.PacijentCrud;
import crud.PregledCrud;
import model.Dijagnoza;
import model.Lekar;
import model.Pacijent;
import model.Pregled;

public class DUnosPregleda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfDatum;
	private JComboBox<Pacijent> cbPacijent;
	private JComboBox<Lekar> cbLekar;
	JComboBox<Dijagnoza> cbDijagnoza;
	private PacijentCrud pacc=new PacijentCrud();
	private LekarCrud lc=new LekarCrud();
	private DijagnozaCrud dc=new DijagnozaCrud();
	private PregledCrud pregledc=new PregledCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosPregleda dialog = new DUnosPregleda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosPregleda() {
		setTitle("Prozor za unos pregleda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPacijent = new JLabel("Pacijent:");
			lblPacijent.setBounds(10, 26, 88, 13);
			contentPanel.add(lblPacijent);
		}
		{
			JLabel lblLekar = new JLabel("Lekar:");
			lblLekar.setBounds(10, 74, 88, 13);
			contentPanel.add(lblLekar);
		}
		{
			JLabel lblDijagnoza = new JLabel("Dijagnoza:");
			lblDijagnoza.setBounds(10, 128, 88, 13);
			contentPanel.add(lblDijagnoza);
		}
		{
			JLabel lblDatum = new JLabel("Datum:");
			lblDatum.setBounds(10, 179, 88, 13);
			contentPanel.add(lblDatum);
		}
		
		cbPacijent= new JComboBox<Pacijent>();
		cbPacijent.setBounds(108, 22, 253, 21);
		contentPanel.add(cbPacijent);
		List<Pacijent> pacijenti=pacc.sviPacijenti();
		for(Pacijent pac: pacijenti) {
			cbPacijent.addItem(pac);
		}
		
		cbLekar = new JComboBox<Lekar>();
		cbLekar.setBounds(108, 70, 253, 21);
		contentPanel.add(cbLekar);
		List<Lekar> lekari=lc.sviLekari();
		for(Lekar l: lekari) {
			cbLekar.addItem(l);
		}
		
		cbDijagnoza = new JComboBox<Dijagnoza>();
		cbDijagnoza.setBounds(108, 124, 253, 21);
		contentPanel.add(cbDijagnoza);
		List<Dijagnoza> dijagnoze=dc.sveDijagnoze();
		for(Dijagnoza d: dijagnoze) {
			cbDijagnoza.addItem(d);
		}
		
		tfDatum = new JTextField();
		tfDatum.setBounds(108, 176, 121, 19);
		contentPanel.add(tfDatum);
		tfDatum.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Pacijent p=(Pacijent) cbPacijent.getSelectedItem();
						Lekar l=(Lekar) cbLekar.getSelectedItem();
						Dijagnoza d=(Dijagnoza) cbDijagnoza.getSelectedItem();
						String datum=tfDatum.getText();
						Pregled pregled=new Pregled();
						pregled.setPacijent(p);
						pregled.setLekar(l);
						pregled.setDijagnoza(d);
						pregled.setDatum(datum);
						pregledc.insertPregled(pregled);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
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
