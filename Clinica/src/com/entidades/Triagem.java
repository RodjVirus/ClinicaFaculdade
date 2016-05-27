package com.entidades;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="triagem")
public class Triagem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Id
	@Column(name = "id_cliente")
	private int idCliente;
	
	@Id
	@Column(name = "id_patologia")
	private int idPatologia;
	
	@Column(name = "data_triagem")
	private Timestamp dataTriagem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdPatologia() {
		return idPatologia;
	}

	public void setIdPatologia(int idPatologia) {
		this.idPatologia = idPatologia;
	}

	public Timestamp getDataTriagem() {
		return dataTriagem;
	}

	public void setDataTriagem(Timestamp dataTriagem) {
		this.dataTriagem = dataTriagem;
	}

	
}
