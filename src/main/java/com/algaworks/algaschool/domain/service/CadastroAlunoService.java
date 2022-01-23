package com.algaworks.algaschool.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algaschool.domain.modelo.Aluno;
import com.algaworks.algaschool.domain.repository.AlunoRepository;

@Service
public class CadastroAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private CadastroCidadeService cidadeService;
	
	private Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
}
