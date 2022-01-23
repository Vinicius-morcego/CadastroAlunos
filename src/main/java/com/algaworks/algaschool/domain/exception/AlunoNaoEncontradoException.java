package com.algaworks.algaschool.domain.exception;

public class AlunoNaoEncontradoException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEncontradoException(String mensagem) {
		super(mensagem);		
	}
	
	public AlunoNaoEncontradoException(Long alunoId) {
		this(String.format("Não existe aluno com código: %d", alunoId));		
	}	

}
