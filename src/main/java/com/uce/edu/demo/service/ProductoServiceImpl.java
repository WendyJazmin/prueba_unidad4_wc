package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.repository.IProductoRepository;


import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	@Transactional(value=TxType.REQUIRES_NEW)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		
		this.iProductoRepository.insertar(producto);
	}

	@Override
	public Producto buscarProductoPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.buscarProductoPorCodigo(codigo);
	}

	@Override
	public int actualizarPorPrecio(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.actualizarPorPrecio(precio);
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarTodos();
	}
	
}
