package com.algaworks.algaschool.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algaschool.domain.modelo.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
