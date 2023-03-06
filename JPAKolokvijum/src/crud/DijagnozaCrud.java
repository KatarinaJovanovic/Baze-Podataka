package crud;

import java.util.List;

import javax.persistence.EntityManager;

import model.Dijagnoza;
import utils.PersistenceUtil;

public class DijagnozaCrud {
	
	public List<Dijagnoza> sveDijagnoze(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Dijagnoza> list=em.createQuery("select d from Dijagnoza d").getResultList();
		em.close();
		return list;
	}
	
	public Dijagnoza findDijagnoza(int idd) {
		EntityManager em=PersistenceUtil.getEntityManager();
		Dijagnoza d=em.find(Dijagnoza.class, idd);
		em.close();
		return d;
	}



}
