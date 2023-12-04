package principal;

import java.util.Random;

public class Jogador {
	private String nome;
	private char simbolo;
	private boolean jogou = false;

	public Jogador(String nome) {
		this.setNome(nome);
		this.simbolo = gerarSimboloAleatorio();
	}

	public Jogador(String nome, char simboloJogadorAnterior) {
		this.setNome(nome);
		this.simbolo = gerarSimboloAleatorioDiferente(simboloJogadorAnterior);
	}

	private char gerarSimboloAleatorio() {
		Random random = new Random();
		// Gera 0 ou 1 aleatoriamente
		int escolha = random.nextInt(2);
		// Se escolha for 0, retorna 'X', caso contrário, retorna 'O'
		return (escolha == 0) ? 'X' : 'O';
	}

	private char gerarSimboloAleatorioDiferente(char simboloJogadorAnterior) {
		char novoSimbolo;
		do {
			novoSimbolo = gerarSimboloAleatorio();
		} while (novoSimbolo == simboloJogadorAnterior);
		return novoSimbolo;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isJogou() {
		return jogou;
	}

	public void setJogou(boolean jogou) {
		this.jogou = jogou;
	}
}
