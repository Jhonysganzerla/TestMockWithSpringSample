package br.edu.utfpr.jhony.testes.services;

import java.util.List;

import br.edu.utfpr.jhony.testes.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.jhony.testes.data.PessoaRepository;

@Component
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public Pessoa buscaPessoa1() {
		return new Pessoa(1, "Leo", 100, 175);
	}

		public List<Pessoa> pegarTodasPessoas() {
			List<Pessoa> pessoas = repository.findAll();

			for(Pessoa pessoa : pessoas) {
				pessoa.setPesovezescem((double)pessoa.getPeso() * 100);
			}

			return pessoas;
	}
	
}
