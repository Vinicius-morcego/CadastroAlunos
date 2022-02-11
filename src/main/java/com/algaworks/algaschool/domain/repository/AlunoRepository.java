package com.algaworks.algaschool.domain.repository;

import org.springframework.stereotype.Repository;

import com.algaworks.algaschool.domain.modelo.Aluno;

@Repository
public interface AlunoRepository extends CustomJpaRepository<Aluno, Long>, AlunoRepositoryQueries{

	
}
