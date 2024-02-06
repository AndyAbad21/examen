package ec.edu.ups.ppw67.demo68.transferencia.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw67.demo68.transferencia.dao.OperadoraDAO;
import ec.edu.ups.ppw67.demo68.transferencia.dao.TelefonoDAO;
import ec.edu.ups.ppw67.demo68.transferencia.model.Operadora;
import ec.edu.ups.ppw67.demo68.transferencia.model.Recarga;
import ec.edu.ups.ppw67.demo68.transferencia.model.Telefono;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Stateless
public class GestionOperadoras {

	@Inject
	private OperadoraDAO daoOperadora;
	 
	@Inject
	private TelefonoDAO daoTelefono;

	public void guardarOperadora(Operadora operadora) {
		Operadora ope = daoOperadora.read(operadora.getCodigo());
		if (ope != null) {
			daoOperadora.update(operadora);
		} else {
			daoOperadora.insert(operadora);
		}
	}

	public void actualizarCuentas(Operadora operadora) throws Exception {
		Operadora ope = daoOperadora.read(operadora.getCodigo());
		if (ope != null) {
			daoOperadora.update(operadora);
		} else {
			daoOperadora.insert(operadora);
		}
	}


	public List<Operadora> getOperadoras() {
		return daoOperadora.getAll();
	}

	
	public void transferir(Recarga recarga) {
		Telefono Origen = daoTelefono.getTelefonoPorCodigo(recarga.getidTelefono());
		Operadora Destino = daoOperadora.getOperadoraPorCodigo(recarga.getIdoperadora());
		
		System.out.println("Antes de la transferencia - Telefono Origen: " + daoTelefono.getTelefonoPorCodigo(recarga.getidTelefono()));
	    System.out.println("Antes de la transferencia - Operadora Destino: " + daoOperadora.getOperadoraPorCodigo(recarga.getIdoperadora()));
		
		System.out.println("MONTOOOO: " + recarga.getMonto());
		
		Origen.setSaldo(Origen.getSaldo() - recarga.getMonto());
		Destino.setSaldo(Destino.getSaldo() + recarga.getMonto());
		
		daoTelefono.update(Origen);
		daoOperadora.update(Destino);
		
		System.out.println("Despues de la transferencia - Telefono Origen: " + daoTelefono.getTelefonoPorCodigo(recarga.getidTelefono()));
	    System.out.println("Despues de la transferencia - Operadora Destino: " + daoOperadora.getOperadoraPorCodigo(recarga.getIdoperadora()));
		
	}
}
