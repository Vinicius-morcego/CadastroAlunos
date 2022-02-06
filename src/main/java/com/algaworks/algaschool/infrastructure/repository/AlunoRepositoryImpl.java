package com.algaworks.algaschool.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.algaworks.algaschool.domain.modelo.Aluno;
import com.algaworks.algaschool.domain.repository.AlunoRepositoryQueries;

@Repository
public class AlunoRepositoryImpl implements AlunoRepositoryQueries{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Aluno> find(String... parametros){
	
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Aluno> criteria = builder.createQuery(Aluno.class);
		
		Root<Aluno> root = criteria.from(Aluno.class); //from Aluno
		
		Predicate nomePredicate = builder.like(root.get("nome"), "%"+parametros[0]+"%");
		
		Predicate idadePredicate = builder.lessThanOrEqualTo(root.get("idade"), parametros[1].toString());
		
		criteria.where(nomePredicate, idadePredicate);
		
		TypedQuery<Aluno> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}
}
