package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Producto;
import com.uce.edu.demo.repository.IProductoRepository;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Service
public class GestorProductoServiceImpl implements IGestorProductoService{
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private IProductoService iProductoService;

	@Override
	@Transactional(value=TxType.REQUIRES_NEW)
	public void insertarProducto(String codigo) {
		// TODO Auto-generated method stub
		Integer stock = 100;
		Producto producto = this.iProductoRepository.buscarProductoPorCodigo(codigo);
		String obtenercodigo = producto.getCodigo();
		String obtenercategoria = producto.getCategoria();
		if(obtenercodigo.equals(null)) {
			int nuevoStock =producto.getStock()+stock;
			producto.setStock(nuevoStock);
			this.iProductoRepository.actualizarProducto(producto);
		}
		this.iProductoService.insertar(producto);
	}

}
