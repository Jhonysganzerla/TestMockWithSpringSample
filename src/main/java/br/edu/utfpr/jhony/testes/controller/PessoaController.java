package br.edu.utfpr.jhony.testes.controller;

import java.util.List;

import br.edu.utfpr.jhony.testes.services.PessoaService;
import br.edu.utfpr.jhony.testes.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

	@Autowired
	private PessoaService pessoasService;

	@GetMapping("/buscaPessoaTeste")
	public Pessoa buscaPessoa() {
		return new Pessoa(1, "Jhony", 72, 173);
	}

	@GetMapping("/buscaPessoa1")
	public Pessoa buscaPessoaDoServiceService() {
		return pessoasService.buscaPessoa1();
	}

	@GetMapping("/buscaTodasPessoa")
	public List<Pessoa> retrieveAllPessoas() {
		return pessoasService.pegarTodasPessoas();
	}

}
