package ec.edu.ups.ppw67.demo68.transferencia.business;

import java.util.List;

import ec.edu.ups.ppw67.demo68.transferencia.dao.TelefonoDAO;
import ec.edu.ups.ppw67.demo68.transferencia.model.Telefono;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionTelefonos {

	@Inject
	private TelefonoDAO daotelefono;

	public void guardartelefonos(Telefono telefono) {
		Telefono cli = daotelefono.read(telefono.getCodigo());
		if (cli != null) {
			daotelefono.update(telefono);
		} else {
			daotelefono.insert(telefono);
		}
	}

	public void actualizartelefono(Telefono telefono) throws Exception {
		Telefono cli = daotelefono.read(telefono.getCodigo());
		if (cli != null) {
			daotelefono.update(telefono);
		} else {
			throw new Exception("telefono no existe");
		}
	}

	public Telefono gettelefonoPorNumero(String numero) throws Exception {

		if (numero.length() != 10)
			throw new Exception("Telefono incorrecto");

		return daotelefono.getTelefonoPorNumero(numero);
	}

	public List<Telefono> gettelefonos() {
		return daotelefono.getAll();
	}
}