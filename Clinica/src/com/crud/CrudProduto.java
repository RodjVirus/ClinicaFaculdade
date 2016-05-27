package com.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entidades.Produto;

public class CrudProduto {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public CrudProduto(){
		emf = Persistence.createEntityManagerFactory("clinicaPersistence");
		em = emf.createEntityManager();
	}
	
	public Produto obterPorId(int id){
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, id);
		em.getTransaction().commit();
		emf.close();
		
		return produto;
	}
	
	public void Salvar(Produto produto){
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Produto produto){
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createNamedQuery("select produto from Produto produto");
		List<Produto> produtos = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return produtos;
	}
	
	
	

}
