package com.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entidades.Patologia;

public class CrudPatologia {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public CrudPatologia(){
		emf = Persistence.createEntityManagerFactory("clinicaPersistence");
		em = emf.createEntityManager();
	}
	
	public Patologia obterPorId(int id){
		em.getTransaction().begin();
		Patologia patologia = em.find(Patologia.class, id);
		em.getTransaction().commit();
		emf.close();
		
		return patologia;
	}
	
	public void Salvar(Patologia patologia){
		em.getTransaction().begin();
		em.merge(patologia);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Patologia patologia){
		em.getTransaction().begin();
		em.remove(patologia);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Patologia> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createNamedQuery("select patologia from Patologia patologia");
		List<Patologia> patologias = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return patologias;
	}
	
	
	

}
