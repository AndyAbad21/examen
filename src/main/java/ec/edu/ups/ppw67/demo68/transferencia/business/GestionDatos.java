package ec.edu.ups.ppw67.demo68.transferencia.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw67.demo68.transferencia.dao.TelefonoDAO;
import ec.edu.ups.ppw67.demo68.transferencia.model.Telefono;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
//
//	@Inject
//	private CuentaDAO daoCuenta;
//	
	@Inject
	private TelefonoDAO daoTelefono;
//
//	@PostConstruct
	public void init() {
		System.out.println("iniciando");

		Telefono telefono = new Telefono();
		telefono.setCodigo(1);
		telefono.setNumero("0980782795");
		telefono.setSaldo(100.0);
		
		daoTelefono.insert(telefono);
		
		Telefono telefono2 = new Telefono();
		telefono2.setCodigo(2);
		telefono2.setNumero("0980782799");
		telefono2.setSaldo(100.0);
		
		daoTelefono.insert(telefono2);
//		Telefono cliente1 = new Telefono();
//		cliente1.setDni("0106764830");
//		cliente1.setDireccion("Guangarcucho");
//		cliente1.setNombre("Paul Sigua");
//
//		daoCliente.insert(cliente1);
//		
//		Telefono cliente2 = new Telefono();
//		cliente2.setDni("0107841549");
//		cliente2.setDireccion("Racar");
//		cliente2.setNombre("Daniel Colla");
//
//		daoCliente.insert(cliente2);
//		
//		/*Cuenta cuenta1 = new Cuenta();
//		cuenta1.setCliente(cliente1);
//		cuenta1.setAhorros(700);
//		cuenta1.setNumero("8787-9898");
//		
//
//		Cuenta cuenta2 = new Cuenta();
//		cuenta2.setCliente(cliente2);
//		cuenta2.setAhorros(100);
//		cuenta2.setNumero("3434-1212");
//		
//		DetallesCuenta det1 = new DetallesCuenta();
//		det1.setResultadoMonto(100);
//		det1.setSaldo(cuenta1.getAhorros());
//		det1.setFecha("2024-01-05");
//		
//		cuenta1.addDetalle(det1);
//		
//		DetallesCuenta det2 = new DetallesCuenta();
//		det2.setResultadoMonto(50);
//		det2.setSaldo(cuenta2.getAhorros());
//		det2.setFecha("2024-01-05");
//		
//		cuenta2.addDetalle(det2);
//		
//		daoCuenta.insert(cuenta1);
//		daoCuenta.insert(cuenta2);*/
//
//		System.out.println("\n------------- TotalFacturas");
//		List<Cuenta> list3 = daoCuenta.getAll();
//		for (Cuenta cue : list3) {
//			System.out.println(cue);
//		}
//		
//		System.out.println("\n------------- TotalFacturas");
//		List<Telefono> list2 = daoCliente.getAll();
//		for (Telefono cue : list2) {
//			System.out.println(cue);
	}
//	}
}