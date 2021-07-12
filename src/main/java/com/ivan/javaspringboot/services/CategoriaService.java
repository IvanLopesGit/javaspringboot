package com.ivan.javaspringboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivan.javaspringboot.domain.Categoria;
import com.ivan.javaspringboot.repositories.CategoriaRepository;
import com.ivan.javaspringboot.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
					id + ", Tipo: " + Categoria.class.getName()
				));
	}

}
