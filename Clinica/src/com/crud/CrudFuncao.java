package com.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entidades.Funcao;

public class CrudFuncao {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public CrudFuncao(){
		emf = Persistence.createEntityManagerFactory("clinicaPersistence");
		em = emf.createEntityManager();
	}
	
	public Funcao obterPorId(int id){
		em.getTransaction().begin();
		Funcao funcao = em.find(Funcao.class, id);
		em.getTransaction().commit();
		emf.close();
		
		return funcao;
	}
	
	public void Salvar(Funcao funcao){
		em.getTransaction().begin();
		em.merge(funcao);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Funcao funcao){
		em.getTransaction().begin();
		em.remove(funcao);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcao> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createNamedQuery("select funcao from Funcao funcao");
		List<Funcao> funcoes = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return funcoes;
	}
	
	
	

}
