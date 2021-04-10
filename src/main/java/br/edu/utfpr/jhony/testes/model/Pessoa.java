package br.edu.utfpr.jhony.testes.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Pessoa {

	@Id
	private int id;
	private String nome;
	private int peso;
	private int altura;

	@Transient
	private double pesovezescem;

	protected Pessoa() {
		
	}

	public Pessoa(int id, String nome, int peso, int altura) {
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getPesovezescem() {
		return pesovezescem;
	}

	public void setPesovezescem(double pesovezescem) {
		this.pesovezescem = pesovezescem;
	}

	@Override
	public String toString() {
		return "Pessoa{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", idade=" + peso +
				", altura=" + altura +
				'}';
	}
}
