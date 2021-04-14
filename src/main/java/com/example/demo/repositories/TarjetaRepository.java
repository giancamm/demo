package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Tarjeta;

public interface TarjetaRepository  extends CrudRepository<Tarjeta, Integer> {
	
	List<Tarjeta> findByNombreIgnoreCase(String nombre);

}
