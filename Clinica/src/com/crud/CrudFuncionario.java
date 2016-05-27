package com.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entidades.Funcionario;

public class CrudFuncionario {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public CrudFuncionario(){
		emf = Persistence.createEntityManagerFactory("clinicaPersistence");
		em = emf.createEntityManager();
	}
	
	public Funcionario obterPorId(int id){
		em.getTransaction().begin();
		Funcionario funcionario = em.find(Funcionario.class, id);
		em.getTransaction().commit();
		emf.close();
		
		return funcionario;
	}
	
	public void Salvar(Funcionario funcionario){
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Funcionario funcionario){
		em.getTransaction().begin();
		em.remove(funcionario);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createNamedQuery("select funcionario from Funcionario funcionario");
		List<Funcionario> funcionarios = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return funcionarios;
	}
	
	
	

}
