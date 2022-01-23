package com.algaworks.algaschool.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;

	public CidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
		
	}

	public CidadeNaoEncontradaException(Long cidadeId) {
		this(String.format("Não existe cidade com código: %d", cidadeId));
	}
	

}
