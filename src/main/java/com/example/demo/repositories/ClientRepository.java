package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ClienteTarjeta;

@Repository
public interface ClientRepository extends CrudRepository<ClienteTarjeta, Integer> {
	
	
}
