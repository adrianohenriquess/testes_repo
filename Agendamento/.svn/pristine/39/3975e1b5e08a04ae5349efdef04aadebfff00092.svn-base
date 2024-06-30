package br.com.techbean.integation.dao.impl;

import br.com.techbean.business.entity.Cliente;
import br.com.techbean.integation.dao.ClienteDAO;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente> implements ClienteDAO{
	private static ClienteDAOImpl instance;
	
	private ClienteDAOImpl() {}
	
	public static ClienteDAOImpl getInstance(){
		if (instance == null){
			instance = new ClienteDAOImpl();
		}
		return instance;
	}
}
