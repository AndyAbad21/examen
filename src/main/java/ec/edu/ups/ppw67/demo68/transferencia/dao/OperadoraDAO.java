package ec.edu.ups.ppw67.demo68.transferencia.dao;

import java.util.List;

import ec.edu.ups.ppw67.demo68.transferencia.model.Operadora;
import ec.edu.ups.ppw67.demo68.transferencia.model.Telefono;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class OperadoraDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Operadora operadora) {
		em.persist(operadora);
	}
	
	public void update(Operadora operadora) {
		em.merge(operadora);
	}
	
	public void remove(int codigo) {
		Operadora operadora = em.find(Operadora.class, codigo);
		em.remove(operadora);
	}
	
	public Operadora read(int codigo) {
		Operadora operadora = em.find(Operadora.class, codigo);
		return operadora;
	}
	
	public List<Operadora> getAll() {
		String jpql = "SELECT o FROM Operadora o";
		Query q = em.createQuery(jpql, Operadora.class);
		return q.getResultList();
	}
	public Operadora getOperadoraPorCodigo(int codigo) {
	    try {
	        String jpql = "SELECT o FROM Operadora o WHERE o.codigo = :codigo";
	        Query q = em.createQuery(jpql, Operadora.class);
	        q.setParameter("codigo", codigo);
	        return (Operadora) q.getSingleResult();
	    } catch (NoResultException e) {
	        return null; // O lanzar una excepción más descriptiva según tus necesidades
	    }
	}
}
