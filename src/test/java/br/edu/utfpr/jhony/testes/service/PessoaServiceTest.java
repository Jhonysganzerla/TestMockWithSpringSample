package br.edu.utfpr.jhony.testes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import br.edu.utfpr.jhony.testes.data.PessoaRepository;
import br.edu.utfpr.jhony.testes.model.Pessoa;
import br.edu.utfpr.jhony.testes.services.PessoaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

	@InjectMocks
	private PessoaService pessoaService;

	@Mock
	private PessoaRepository repository;

	@Test
	public void pegarTodasPessoas() {
		when(repository.findAll()).thenReturn(Arrays.asList(
				new Pessoa(2,"Pessoa2",10,10),
				new Pessoa(3,"Pessoa3",20,20)));

		List<Pessoa> pessoas = pessoaService.pegarTodasPessoas();
		
		assertEquals(1000, pessoas.get(0).getPesovezescem());
		assertEquals(2000, pessoas.get(1).getPesovezescem());
	}
}
