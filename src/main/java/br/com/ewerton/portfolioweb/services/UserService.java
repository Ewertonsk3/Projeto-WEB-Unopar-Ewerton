package br.com.ewerton.portfolioweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewerton.portfolioweb.entities.User;
import br.com.ewerton.portfolioweb.repositories.UserRepository;
import br.com.ewerton.portfolioweb.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findByid(Long id) {
		
		
		Optional<User> usuario = repository.findById(id);
		return usuario.orElseThrow(() -> new ResourceNotFoundException(id));  
	}
	
	public User insert(User usuario) {
		return repository.save(usuario);
	}

	
	public void delet(Long id) {
		
		try {
			repository.deleteById(id);
		} catch (ResourceNotFoundException e) {
			// TODO: handle exception
		}
		 
	}
	
	public User update(Long id, User usuario) {
		try {
		User cadastro = repository.getReferenceById(id);
		updateDados(cadastro, usuario);
		return repository.save(cadastro);
		} catch (RuntimeException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateDados(User cadastro, User usuario) {
		cadastro.setNome(usuario.getNome());
		cadastro.setEmail(usuario.getEmail());
		cadastro.setTelefone(usuario.getTelefone());
		
	}
}
