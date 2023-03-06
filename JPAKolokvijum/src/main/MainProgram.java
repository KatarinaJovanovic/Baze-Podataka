package main;

import java.util.List;

import crud.DijagnozaCrud;
import crud.LekarCrud;
import crud.PacijentCrud;
import crud.PregledCrud;
import model.Pacijent;
import model.Pregled;


public class MainProgram {
	public static void main(String[] args) {
		PacijentCrud pacc=new PacijentCrud();
		PregledCrud pc=new PregledCrud();
		LekarCrud lc=new LekarCrud();
		DijagnozaCrud dc=new DijagnozaCrud();
		
		/*Pacijent p=new Pacijent();
		p.setImepac("Katarina");
		p.setPrezpac("Jovanovic");
		pacc.insertPacijent(p);*/
		
		/*Pacijent p=new Pacijent();
		p.setImepac("Nikola");
		p.setPrezpac("Djukic");
		pacc.insertPacijent(p);*/
		
		/*Pregled pregled=new Pregled();
		pregled.setDatum("12.08.2020");
		pregled.setDijagnoza(dc.findDijagnoza(1));
		pregled.setLekar(lc.findLekar(3));
		pregled.setPacijent(pacc.findPacijent(1));
		pc.insertPregled(pregled);*/
		
		//pacc.deletePacijent(pacc.findPacijent(2));
		
		/*Pacijent p=new Pacijent();
		p.setImepac("Zeljko");
		p.setPrezpac("Micic");
		pacc.insertPacijent(p);*/
		Pregled pregled=new Pregled();
		pregled.setDatum("04.01.2021");
		pregled.setDijagnoza(dc.findDijagnoza(4));
		pregled.setLekar(lc.findLekar(1));
		pregled.setPacijent(pacc.findPacijent(3));
		pc.insertPregled(pregled);
		
		Pacijent x=pacc.findPacijent(1);
		List<Pregled> pregledi=pc.prikazSvihPregledaPacijenta(x);
		for(Pregled pr: pregledi)
			System.out.println(pr);
	}
}
