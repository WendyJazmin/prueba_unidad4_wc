package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.util.List;


import com.uce.edu.demo.modelo.Producto;





public interface IProductoRepository {

	public void insertar(Producto producto);
	

	
	public Producto buscarProductoPorCodigo(String codigo);
	public List<Producto> buscarProductoPorCategoria(String categoria);

	
	public int actualizarPorPrecio(BigDecimal precio);
	
	public void actualizarProducto(Producto producto);
	public List<Producto> buscarTodos();
}
