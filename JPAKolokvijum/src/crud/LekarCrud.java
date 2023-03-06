package crud;

import java.util.List;

import javax.persistence.EntityManager;

import model.Lekar;
import model.Pacijent;
import utils.PersistenceUtil;

public class LekarCrud {
	
	public List<Lekar> sviLekari(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Lekar> list=em.createQuery("select l from Lekar l").getResultList();
		em.close();
		return list;
	}

	public Lekar findLekar(int idl) {
		EntityManager em=PersistenceUtil.getEntityManager();
		Lekar l=em.find(Lekar.class, idl);
		em.close();
		return l;
		
	}

}
