package br.edu.utfpr.jhony.testes.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import br.edu.utfpr.jhony.testes.model.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PessoaRepositoryTest {
	
	@Autowired
	private PessoaRepository repository;
	
	@Test
	public void testFindAll() {
		List<Pessoa> pessoas = repository.findAll();
		assertEquals(3, pessoas.size());
	}

	@Test
	public void testFindOne() {
		Pessoa pessoa = repository.findById(10001).get();
		
		assertEquals("Jhony", pessoa.getNome());
	}

}
