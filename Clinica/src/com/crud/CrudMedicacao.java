package com.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entidades.Medicacao;

public class CrudMedicacao {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public CrudMedicacao(){
		emf = Persistence.createEntityManagerFactory("clinicaPersistence");
		em = emf.createEntityManager();
	}
	
	public Medicacao obterPorId(int id){
		em.getTransaction().begin();
		Medicacao medicacao = em.find(Medicacao.class, id);
		em.getTransaction().commit();
		emf.close();
		
		return medicacao;
	}
	
	public void Salvar(Medicacao medicacao){
		em.getTransaction().begin();
		em.merge(medicacao);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Medicacao medicacao){
		em.getTransaction().begin();
		em.remove(medicacao);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Medicacao> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createNamedQuery("select medicacao from Medicacao medicacao");
		List<Medicacao> medicacaos = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return medicacaos;
	}
	
	
	

}
