package com.entidades;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="atendimento")


public class Atendimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Id
	@Column(name = "id_cliente")
	private int idCliente;
	
	@Column(name = "id_funcionario")
	@Id
	private int idFuncionario;
	
	@Column(name = "data_atendimento")
	private  Timestamp dataAtendimento;
	
	@Column(name = "exame")
	private String exame;
	
	@Column(name = "is_retorno")
	private Boolean isRetorno;

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

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Timestamp getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Timestamp dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public Boolean getIsRetorno() {
		return isRetorno;
	}

	public void setIsRetorno(Boolean isRetorno) {
		this.isRetorno = isRetorno;
	}
	
	


}
