package com.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicacao")

public class Medicacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Id
	@Column(name = "id_produto")
	private int idProduto;
	
	@Id
	@Column(name = "id_Paciente")
	private int idPaciente;
	
	@Column(name = "is_atendido")
	private Boolean isAtendido;
	
	@Column(name = "posologia")
	private String posologia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Boolean getIsAtendido() {
		return isAtendido;
	}

	public void setIsAtendido(Boolean isAtendido) {
		this.isAtendido = isAtendido;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}
	
	
	
}
