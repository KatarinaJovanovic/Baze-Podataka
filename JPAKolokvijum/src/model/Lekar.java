package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the lekar database table.
 * 
 */
@Entity
@NamedQuery(name="Lekar.findAll", query="SELECT l FROM Lekar l")
public class Lekar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idl;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Pregled
	@OneToMany(mappedBy="lekar")
	private List<Pregled> pregleds;

	public Lekar() {
		this.pregleds=new ArrayList<Pregled>();
	}

	public int getIdl() {
		return this.idl;
	}

	public void setIdl(int idl) {
		this.idl = idl;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Pregled> getPregleds() {
		return this.pregleds;
	}

	public void setPregleds(List<Pregled> pregleds) {
		this.pregleds = pregleds;
	}

	public Pregled addPregled(Pregled pregled) {
		getPregleds().add(pregled);
		pregled.setLekar(this);

		return pregled;
	}

	public Pregled removePregled(Pregled pregled) {
		getPregleds().remove(pregled);
		pregled.setLekar(null);

		return pregled;
	}

	@Override
	public String toString() {
		return "Lekar: " + idl + ", " + ime + " " + prezime;
	}
	

}