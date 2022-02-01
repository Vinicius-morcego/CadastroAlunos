package com.algaworks.algaschool.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algaschool.domain.exception.AlunoNaoEncontradoException;
import com.algaworks.algaschool.domain.exception.EntidadeEmUsoException;
import com.algaworks.algaschool.domain.modelo.Aluno;
import com.algaworks.algaschool.domain.repository.AlunoRepository;

@Service
public class CadastroAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno salvar(Aluno aluno) {
		
		return alunoRepository.save(aluno);
	}
	
	
	public void deletar(Long alunoID) {
		try {
			alunoRepository.deleteById(alunoID);
		} catch (EmptyResultDataAccessException e) {
			throw new AlunoNaoEncontradoException(alunoID);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Aluno de código %d em uso", alunoID));
		}
	}
	
	public Aluno buscarOuFalhar(Long alunoID) {
		return alunoRepository.findById(alunoID).orElseThrow(() -> 
		new AlunoNaoEncontradoException(String.format("Aluno de código %d não encontrado", alunoID)));
	}
	
	
}
