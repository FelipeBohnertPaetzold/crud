package com.aula.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aula.Model.Pessoa;
import com.aula.Repository.PessoaRepository;

@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin("*")
public class PessoaController {

	@Autowired
	private PessoaRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> getAll(){
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Pessoa> getOne(@PathVariable("id") final String id){
		return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Pessoa> store(@RequestBody final Pessoa pessoa){
		return new ResponseEntity<>(repository.save(pessoa), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/drop/{id}")
	public ResponseEntity<Pessoa> destroy(@PathVariable("id") final String id){
		try {
			repository.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Pessoa> update(@RequestBody final Pessoa pessoa){
		try {
			return new ResponseEntity<>(repository.save(pessoa), HttpStatus.OK);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
