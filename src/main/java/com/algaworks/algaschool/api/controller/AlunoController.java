package com.algaworks.algaschool.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algaschool.domain.modelo.Aluno;
import com.algaworks.algaschool.domain.repository.AlunoRepository;
import com.algaworks.algaschool.domain.service.CadastroAlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {

	@Autowired 
	private CadastroAlunoService alunoService;
	
	@Autowired 
	private AlunoRepository alunoRepository;
	
	@PostMapping
	public Aluno salvar(@RequestBody Aluno aluno) {
		return alunoService.salvar(aluno);
	}
	
	@PutMapping("/{alunoID}")
	public Aluno atualizar(@PathVariable Long alunoID, @RequestBody Aluno aluno) {
		Aluno alunoAtual = alunoService.buscarOuFalhar(alunoID);
		BeanUtils.copyProperties(aluno, alunoAtual, "id");
		return alunoService.salvar(alunoAtual);
	}
	
	@GetMapping
	public List<Aluno> buscar() {
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{alunoID}")
	public Aluno buscar(@PathVariable Long alunoID) {
		return alunoService.buscarOuFalhar(alunoID);
	}
	
	@GetMapping("/consultar-por-nome-ou-idade")
	public List<Aluno> buscarPorNomeouIdade(String nome, String idadeMaiorIgual, String idadeMenorIgual){
		return alunoRepository.find(nome, idadeMaiorIgual, idadeMenorIgual);
	}
	
	@GetMapping
	public Optional<Aluno> buscarPrimeiro(){
		return alunoRepository.buscarPrimeiro();
	}
	
	
	@DeleteMapping("/{alunoID}")
	public void deletar(@PathVariable Long alunoID) {
		alunoService.deletar(alunoID);
	}
	
}
