package com.algaworks.algaschool.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algaschool.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algaschool.domain.modelo.Estado;
import com.algaworks.algaschool.domain.repository.EstadoRepository;
import com.algaworks.algaschool.domain.service.CadastroEstadoService;

@RestController()
@RequestMapping(value = "/estado")
public class EstadoController {

	@Autowired
	private CadastroEstadoService estadoService;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public List<Estado> listar(){
		return estadoRepository.findAll();
	}
	
	@GetMapping("/{estadoId}")
	public Estado buscar(@PathVariable Long estadoId) {
			
			return estadoService.buscarOuFalhar(estadoId);
		
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Estado estado) {
		try {
			estado = estadoService.salvar(estado);
			return ResponseEntity.status(HttpStatus.CREATED).body(estado);
		} catch (EstadoNaoEncontradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{estadoId}")
	public Estado atualizar(@PathVariable Long estadoId, @RequestBody Estado estado){
	
			Estado estadoAtual = estadoService.buscarOuFalhar(estadoId);
			
			BeanUtils.copyProperties(estado, estadoAtual, "id");
			
			return estadoService.salvar(estadoAtual);
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{estadoId}")
	public void deletar(@PathVariable Long estadoId) {
	
			estadoService.deletar(estadoId);	
	}
}
