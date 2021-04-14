package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tarjeta;
import com.example.demo.model.TarjetaDTO;
import com.example.demo.repositories.TarjetaRepository;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaController {
	
	
	@Autowired
	private TarjetaRepository repository;
	
	@GetMapping
	public ResponseEntity<Iterable<Tarjeta>> listAll(){
		
		Iterable<Tarjeta> tarjetas = repository.findAll();
		
		return ResponseEntity.ok(tarjetas);
		
	}
	
	@GetMapping("/v2")
	public ResponseEntity<List<TarjetaDTO>> listAllV2(){
		
		Iterable<Tarjeta> tarjetas = repository.findAll();
		
		List<TarjetaDTO> respuesta  = new ArrayList<>();
		for(Tarjeta t : tarjetas) {
			
			respuesta.add(new TarjetaDTO(t.getNombre(), t.getTasa()));
			
		}
		
		return ResponseEntity.ok(respuesta);
			
	}
	
}
