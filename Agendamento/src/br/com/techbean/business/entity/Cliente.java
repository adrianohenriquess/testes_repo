package br.com.techbean.business.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Entidade apenas de exemplo só pra gerar a tabela*/

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = -7661113727729246276L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoCliente;
	private String nomeCliente;
	
	public Cliente() {}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}
