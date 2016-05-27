package com.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entidades.Triagem;

public class CrudTriagem {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public CrudTriagem(){
		emf = Persistence.createEntityManagerFactory("clinicaPersistence");
		em = emf.createEntityManager();
	}
	
	public Triagem obterPorId(int id){
		em.getTransaction().begin();
		Triagem triagem = em.find(Triagem.class, id);
		em.getTransaction().commit();
		emf.close();
		
		return triagem;
	}
	
	public void Salvar(Triagem triagem){
		em.getTransaction().begin();
		em.merge(triagem);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Triagem triagem){
		em.getTransaction().begin();
		em.remove(triagem);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Triagem> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createNamedQuery("select triagem from Triagem triagem");
		List<Triagem> triagems = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return triagems;
	}
	
	
	

}
