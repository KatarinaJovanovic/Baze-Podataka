package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Pacijent;
import model.Pregled;
import utils.PersistenceUtil;

public class PacijentCrud {
	
	public void insertPacijent(Pacijent p) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			
			em.persist(p);
			
			em.flush();
			et.commit();
		} catch (Exception e) {
			if(et!=null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			if(em!=null && em.isOpen())
				em.close();
		}
	}
	
	public void deletePacijent(Pacijent p) {
		EntityManager em=PersistenceUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			et=em.getTransaction();
			et.begin();
			
			p=em.merge(p);
			List<Pregled> list=p.getPregleds();
			for(Pregled pregled: list) {
				em.remove(pregled);
			}
			
			em.remove(p);
			em.flush();
			et.commit();
		} catch (Exception e) {
			if(et!=null) {
				et.rollback();
			}
			e.printStackTrace();
		}finally {
			if(em!=null && em.isOpen())
				em.close();
		}
	}
	
	public List<Pacijent> sviPacijenti(){
		EntityManager em=PersistenceUtil.getEntityManager();
		List<Pacijent> list=em.createQuery("select p from Pacijent p order by p.idp").getResultList();
		em.close();
		return list;
	}

	public Pacijent findPacijent(int idp) {
		EntityManager em=PersistenceUtil.getEntityManager();
		Pacijent p=em.find(Pacijent.class, idp);
		em.close();
		return p;
		
	}
}
