package com.algaworks.algaschool.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		Estado estado = buscarOuFalhar(estadoId);
		estadoRepository.delete(estado);
	}
	
	public Estado buscarOuFalhar(Long estadoId) {
		return estadoRepository.findById(estadoId).orElseThrow(() -> 
		new EstadoNaoEncontradoException(estadoId));
	}
}
