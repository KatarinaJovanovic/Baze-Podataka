package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pregled database table.
 * 
 */
@Entity
@NamedQuery(name="Pregled.findAll", query="SELECT p FROM Pregled p")
public class Pregled implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int brojP;

	private String datum;

	//bi-directional many-to-one association to Dijagnoza
	@ManyToOne
	@JoinColumn(name="idd")
	private Dijagnoza dijagnoza;

	//bi-directional many-to-one association to Lekar
	@ManyToOne
	@JoinColumn(name="idl")
	private Lekar lekar;

	//bi-directional many-to-one association to Pacijent
	@ManyToOne
	@JoinColumn(name="idp")
	private Pacijent pacijent;

	public Pregled() {
	}

	public int getBrojP() {
		return this.brojP;
	}

	public void setBrojP(int brojP) {
		this.brojP = brojP;
	}

	public String getDatum() {
		return this.datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Dijagnoza getDijagnoza() {
		return this.dijagnoza;
	}

	public void setDijagnoza(Dijagnoza dijagnoza) {
		this.dijagnoza = dijagnoza;
	}

	public Lekar getLekar() {
		return this.lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}

	public Pacijent getPacijent() {
		return this.pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	@Override
	public String toString() {
		return "Pregled [brojP=" + brojP + ", datum=" + datum + ", dijagnoza=" + dijagnoza + ", lekar=" + lekar
				+ ", pacijent=" + pacijent + "]";
	}
	

}