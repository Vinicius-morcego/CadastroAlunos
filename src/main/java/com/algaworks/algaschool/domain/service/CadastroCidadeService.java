package com.algaworks.algaschool.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algaschool.domain.exception.CidadeNaoEncontradaException;
import com.algaworks.algaschool.domain.exception.EntidadeEmUsoException;
import com.algaworks.algaschool.domain.modelo.Cidade;
import com.algaworks.algaschool.domain.modelo.Estado;
import com.algaworks.algaschool.domain.repository.CidadeRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CadastroEstadoService estadoService;
	
	public Cidade salvar(Cidade cidade) {
		Estado estado = estadoService.buscarOuFalhar(cidade.getEstado().getId());
		cidade.setEstado(estado);
		return cidadeRepository.save(cidade);
	}	
	
	public void deletar(Long cidadeID) {
		try {
			cidadeRepository.deleteById(cidadeID);
		} catch (EmptyResultDataAccessException e) {
			throw new CidadeNaoEncontradaException(cidadeID);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Cidade de código %d em uso", cidadeID));
		}
		
	}
	
	public Cidade buscarOuFalhar(Long cidadeId) {
		return cidadeRepository.findById(cidadeId).orElseThrow(() -> 
		new CidadeNaoEncontradaException(cidadeId));
	}
}
