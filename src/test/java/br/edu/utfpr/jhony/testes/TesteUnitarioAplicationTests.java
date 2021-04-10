package br.edu.utfpr.jhony.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TesteUnitarioAplicationTests {

	private TesteUnitarioAplication.MatematicaUtil pessoaServiceUtil = new TesteUnitarioAplication.MatematicaUtil();

	@Test
	public void contextLoads() {
	}

	@Test
	public void testeUnitario1Teste() {

		Assertions.assertEquals(6, pessoaServiceUtil.calculaSoma(new int[] { 1, 2, 3 }
		));
	}
}
