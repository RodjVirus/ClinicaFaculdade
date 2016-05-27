package com.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entidades.Atendimento;

public class CrudAtendimento {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public CrudAtendimento(){
		emf = Persistence.createEntityManagerFactory("clinicaPersistence");
		em = emf.createEntityManager();
	}
	
	public Atendimento obterPorId(int id){
		em.getTransaction().begin();
		Atendimento atendimento = em.find(Atendimento.class, id);
		em.getTransaction().commit();
		emf.close();
		
		return atendimento;
	}
	
	public void Salvar(Atendimento atendimento){
		em.getTransaction().begin();
		em.merge(atendimento);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Atendimento atendimento){
		em.getTransaction().begin();
		em.remove(atendimento);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Atendimento> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createNamedQuery("select atendimento from Atendimento atendimento");
		List<Atendimento> atendimentos = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return atendimentos;
	}
	
	
	

}
