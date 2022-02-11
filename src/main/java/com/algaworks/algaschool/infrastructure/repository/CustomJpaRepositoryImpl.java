package com.algaworks.algaschool.infrastructure.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.algaworks.algaschool.domain.repository.CustomJpaRepository;

public class CustomJpaRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> 
implements CustomJpaRepository<T, ID>{

	@Autowired
	private EntityManager manager;
	
	public CustomJpaRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager em) {
		
		super(entityInformation, em);
		this.manager = em;
		
	}

	@Override
	public Optional<T> buscarPrimeiro() {
		var jpql = "from " + getDomainClass().getName();
		
		T entity = manager.createQuery(jpql, getDomainClass()).setMaxResults(1).getSingleResult();
		return Optional.ofNullable(entity);
	}

}
