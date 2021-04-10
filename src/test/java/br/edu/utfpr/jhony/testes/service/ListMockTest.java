package br.edu.utfpr.jhony.testes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ListMockTest {

	List<String> listaMock = mock(List.class);

	@Test
	public void testeTamanho() {
		//Seta tamanho de mock pra lista uma lista 5
		when(listaMock.size()).thenReturn(5);
		assertEquals(5, listaMock.size());
	}

	@Test
	public void testeTamanhoDiferentes() {
		when(listaMock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, listaMock.size());
		assertEquals(10, listaMock.size());
	}

	@Test
	public void retornoComParametros() {
		when(listaMock.get(0)).thenReturn("testeJhony");
		//Eu na 0 = testeJhony
		assertEquals("testeJhony", listaMock.get(0));
		assertEquals(null, listaMock.get(1));
	}

	@Test
	public void retornoComParametrosGenericos() {
		when(listaMock.get(anyInt())).thenReturn("testeJhony");

		assertEquals("testeJhony", listaMock.get(0));
		assertEquals("testeJhony", listaMock.get(1));
	}

	@Test
	public void verificationBasics() {

		String valor1 = listaMock.get(0);
		String valor2 = listaMock.get(1);

		verify(listaMock).get(0);

		//Ver se a get foi chamado 2x
		verify(listaMock, times(2)).get(anyInt());

		//Ver se a get foi chamado pelo menos 1x
		verify(listaMock, atLeast(1)).get(anyInt());

		//Ver se a get foi chamado pelo menos 1x
		verify(listaMock, atLeastOnce()).get(anyInt());

		//Ver se a get foi chamado no max 2x
		verify(listaMock, atMost(2)).get(anyInt());

		//Ver se a get nunca foi chamado no get(2)
		verify(listaMock, never()).get(2);
	}

	@Test
	public void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null

		System.out.println(arrayListMock.size());//0

		arrayListMock.add("jhony");
		System.out.println(arrayListMock.get(0));
		arrayListMock.add("jhony2");

		System.out.println(arrayListMock.size());//0

		when(arrayListMock.size()).thenReturn(5);

		System.out.println(arrayListMock.size());//5
	}

	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Teste0");
		System.out.println(arrayListSpy.get(0));//Teste0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Teste");
		arrayListSpy.add("Teste2");
		System.out.println(arrayListSpy.size());//3
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		
		arrayListSpy.add("Teste4");
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Teste4");
	}

	
}
