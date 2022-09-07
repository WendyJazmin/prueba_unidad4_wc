package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uce.edu.demo.modelo.Producto;



public interface IProductoService {

	public void insertar(Producto producto);
	
	public Producto buscarProductoPorCodigo(String codigo);
	
	public int actualizarPorPrecio(BigDecimal precio);
	
	public List<Producto> buscarTodos();
}
