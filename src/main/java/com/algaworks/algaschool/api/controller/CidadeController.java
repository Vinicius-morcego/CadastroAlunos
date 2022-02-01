package com.algaworks.algaschool.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

import com.algaworks.algaschool.domain.exception.CidadeNaoEncontradaException;
import com.algaworks.algaschool.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algaschool.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algaschool.domain.modelo.Cidade;
import com.algaworks.algaschool.domain.modelo.Estado;
import com.algaworks.algaschool.domain.repository.CidadeRepository;
import com.algaworks.algaschool.domain.service.CadastroCidadeService;
import com.algaworks.algaschool.domain.service.CadastroEstadoService;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CadastroCidadeService cidadeService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade salvar(@RequestBody Cidade cidade) {
		return cidadeService.salvar(cidade);		
		
	}
	
	@PutMapping("/{cidadeID}")
	public Cidade atualizar(@PathVariable Long cidadeID, @RequestBody Cidade cidade) {
	
		try {
			Cidade cidadeAtual = cidadeService.buscarOuFalhar(cidadeID);
			BeanUtils.copyProperties(cidade, cidadeAtual, "id");
			return cidadeService.salvar(cidadeAtual);
		} catch (EntidadeNaoEncontradaException e) {
			throw new EstadoNaoEncontradoException("Estado não encontrado");
		}
		
	}
	
	
	@GetMapping("/{cidadeID}")
	public Cidade buscar(@PathVariable Long cidadeID) {
		
		return cidadeService.buscarOuFalhar(cidadeID);
		
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cidade> listar(){
		return cidadeRepository.findAll();
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{cidadeID}")
	public void deletar(@PathVariable Long cidadeID) {
	
		cidadeService.deletar(cidadeID);
	}
	
}
