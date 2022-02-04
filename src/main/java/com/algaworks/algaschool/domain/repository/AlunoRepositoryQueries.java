package com.algaworks.algaschool.domain.repository;

import java.util.List;

import com.algaworks.algaschool.domain.modelo.Aluno;

public interface AlunoRepositoryQueries {

	List<Aluno> find(String nome);

}