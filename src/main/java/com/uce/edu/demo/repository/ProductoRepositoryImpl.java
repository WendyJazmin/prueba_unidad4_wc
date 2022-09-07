package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional.TxType;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.uce.edu.demo.modelo.Producto;





@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value =TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	@Transactional(value =TxType.MANDATORY)
	public int actualizarPorPrecio(BigDecimal precio) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("UPDATE Producto p SET p.precio =: datoPrecio");
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.executeUpdate();
	}

	@Override
	@Transactional(value =TxType.NOT_SUPPORTED)
	public Producto buscarProductoPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Producto>myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigo= :datoCodigo",Producto.class);
		myQuery.setParameter("datoCodigo", codigo);
		
		return myQuery.getSingleResult() ;
	}

	

	@Override
	@Transactional(value =TxType.MANDATORY)
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	@Transactional(value =TxType.NOT_SUPPORTED)
	public List<Producto> buscarProductoPorCategoria(String categoria) {
		// TODO Auto-generated method stub
		TypedQuery<Producto>myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.categoria= :datoCategoria",Producto.class);
		myQuery.setParameter("datoCategoria", categoria);
		
		return myQuery.getResultList();
		
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p",Producto.class);
		return myQuery.getResultList();
		
	}

	


}
