package ec.edu.ups.ppw67.demo68.transferencia.dao;

import java.util.List;

import ec.edu.ups.ppw67.demo68.transferencia.model.Telefono;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class TelefonoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Telefono telefono) {
		em.persist(telefono);
	}
	
	public void update(Telefono telefono) {
		em.merge(telefono);
	}
	
	public void remove(int codigo) {
		Telefono telefono = em.find(Telefono.class, codigo);
		em.remove(telefono);
	}

	public Telefono read(int codigo) {
		Telefono telefono = em.find(Telefono.class, codigo);
		return telefono;
	}

	public List<Telefono> getAll() {
		String jpql = "SELECT c FROM Telefono c";
		Query q = em.createQuery(jpql, Telefono.class);
		return q.getResultList();
	}
	public Telefono getTelefonoPorCodigo(int codigo) {
		try {
	        String jpql = "SELECT t FROM Telefono t WHERE t.codigo = :codigo";
	        Query q = em.createQuery(jpql, Telefono.class);
	        q.setParameter("codigo", codigo);
	        return (Telefono) q.getSingleResult();
	    } catch (NoResultException e) {
	        return null; // O lanzar una excepción más descriptiva según tus necesidades
	    }
	}
	public Telefono getTelefonoPorNumero(String numero) {
		try {
	        String jpql = "SELECT t FROM Telefono t WHERE t.numero = :numero";
	        Query q = em.createQuery(jpql, Telefono.class);
	        q.setParameter("numero", numero);
	        return (Telefono) q.getSingleResult();
	    } catch (NoResultException e) {
	        return null; // O lanzar una excepción más descriptiva según tus necesidades
	    }
	}
}
