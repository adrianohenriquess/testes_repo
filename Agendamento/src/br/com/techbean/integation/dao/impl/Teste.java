package br.com.techbean.integation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.techbean.business.entity.Cliente;
import br.com.techbean.integation.dao.ClienteDAO;

public class Teste {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = ClienteDAOImpl.getInstance();
		for (int i = 0; i <= 9; i++){
			Cliente cliente = new Cliente();
			cliente.setNomeCliente("Adriano");
			clienteDAO.save(cliente);
		}
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes = clienteDAO.findAll(Cliente.class);
		for (Cliente cliente : listaClientes) {
			System.out.println("Cliente: " + cliente.getCodigoCliente());
			System.out.println("Cliente: " + cliente.getNomeCliente());
		}
	}
}
