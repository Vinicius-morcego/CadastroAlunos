package com.algaworks.algaschool.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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
			
			var predicates = new ArrayList<Predicate>();
			
			if(StringUtils.hasText(parametros[0])) {
				predicates.add(builder.like(root.get("nome"), "%"+parametros[0]+"%"));
				//Predicate nomePredicate = builder.like(root.get("nome"), "%"+parametros[0]+"%");
			}
			
			if(parametros[1] != null) {
				predicates.add(builder.greaterThanOrEqualTo(root.get("idade"), parametros[1]));
				//Predicate idadeMaiorPredicate = builder.greaterThanOrEqualTo(root.get("idade"), parametros[1]);
				
			}
			
			if(parametros[2] != null) {
				predicates.add(builder.lessThanOrEqualTo(root.get("idade"), parametros[2]));
				//Predicate idadeMenorPredicate = builder.lessThanOrEqualTo(root.get("idade"), parametros[2]);
				
			}
			
			criteria.where(predicates.toArray(new Predicate[0]));
			
			TypedQuery<Aluno> query = manager.createQuery(criteria);
			
			return query.getResultList();
		
		
	}
}
