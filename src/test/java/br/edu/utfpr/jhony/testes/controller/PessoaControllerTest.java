package br.edu.utfpr.jhony.testes.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import br.edu.utfpr.jhony.testes.model.Pessoa;
import br.edu.utfpr.jhony.testes.services.PessoaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PessoaService pessoaService;
	
	@Test
	public void buscaPessoaTeste() throws Exception {

		//Testa se a pessoa chegou certinho (tem que vir o jhony pesado)
		RequestBuilder request = MockMvcRequestBuilders
				.get("/buscaPessoaTeste")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\": 1,\"nome\":\"Jhony\",\"peso\":72,\"altura\":173}"))
				.andReturn();

	}

	@Test
	public void pessoadoService() throws Exception {
		when(pessoaService.buscaPessoa1()).thenReturn(
				new Pessoa(2,"Pessoa2",100,10));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/buscaPessoa1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2,nome:Pessoa2,peso:100}"))
				.andReturn();

	}

	@Test
	public void buscaTodasNaoPessoa() throws Exception {
		when(pessoaService.pegarTodasPessoas()).thenReturn(
				Arrays.asList()
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/buscaTodasPessoa")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[]"))
				.andReturn();

	}

}
