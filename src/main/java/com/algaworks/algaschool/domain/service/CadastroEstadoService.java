package com.algaworks.algaschool.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algaschool.domain.exception.EntidadeEmUsoException;
import com.algaworks.algaschool.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algaschool.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algaschool.domain.modelo.Estado;
import com.algaworks.algaschool.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvar(Estado estado) {	
		
		return estadoRepository.save(estado);
	}
	
	public void deletar(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EstadoNaoEncontradoException(estadoId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Estado de código %d em uso!", estadoId));
		}
		
	}
	
	public Estado buscarOuFalhar(Long estadoId) {
		return estadoRepository.findById(estadoId).orElseThrow(() -> 
		new EstadoNaoEncontradoException(estadoId));
	}
}
