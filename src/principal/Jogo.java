package principal;

import java.util.Scanner;

public class Jogo {
	private char pos00;
	private char pos01;
	private char pos02;
	private char pos10;
	private char pos11;
	private char pos12;
	private char pos20;
	private char pos21;
	private char pos22;

	static Scanner sc = new Scanner(System.in);

	public void mostrarJogo() {
		System.out.println(pos00 + " | " + pos01 + " | " + pos02);
		System.out.println("---------");
		System.out.println(pos10 + " | " + pos11 + " | " + pos12);
		System.out.println("---------");
		System.out.println(pos20 + " | " + pos21 + " | " + pos22);
	}

	public void jogar(Jogador jogador1, Jogador jogador2) {
		boolean ganhou = false;
		Jogador jogadorFinal = new Jogador("");
		for (int i = 0; i < 9; i++) {
			Jogador jogadorGenerico;
			if (!jogador1.isJogou()) {
				jogadorGenerico = jogador1;
				jogador1.setJogou(true);
			} else {
				jogadorGenerico = jogador2;
				jogador1.setJogou(false);
			}

			System.out.println("TABELA");
			mostrarJogo();
			System.out.println();

			System.out.println("Vez do jogador " + jogadorGenerico.getNome());
			System.out.print("Digite aonde voce deseja jogar: ");
			int jogada = sc.nextInt();
			switch (jogada) {
			case 1: {
				pos00 = jogadorGenerico.getSimbolo();
				break;
			}
			case 2: {
				pos01 = jogadorGenerico.getSimbolo();
				break;
			}
			case 3: {
				pos02 = jogadorGenerico.getSimbolo();
				break;
			}
			case 4: {
				pos10 = jogadorGenerico.getSimbolo();
				break;
			}
			case 5: {
				pos11 = jogadorGenerico.getSimbolo();
				break;
			}
			case 6: {
				pos12 = jogadorGenerico.getSimbolo();
				break;
			}
			case 7: {
				pos20 = jogadorGenerico.getSimbolo();
				break;
			}
			case 8: {
				pos21 = jogadorGenerico.getSimbolo();
				break;
			}
			case 9: {
				pos22 = jogadorGenerico.getSimbolo();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + jogada);
			}

			if (i > 3) {
				boolean teste = verificaLinha() || verificaColuna();
				ganhou = teste || verificaDiagonal();
			}

			if (ganhou) {
				jogadorFinal = jogadorGenerico;
				i = 10;
			}
			System.out.println();
		}
		if (ganhou) {
			mostrarJogo();
			System.out.println("QUEM GANHOU FOI: " + jogadorFinal.getNome().toUpperCase());
		} else {
			mostrarJogo();
			System.out.println("DEU VELHA");
		}
	}

	private boolean verificaDiagonal() {
		if (pos00 == pos11 && pos11 == pos22) {
			return true;
		} else if (pos20 == pos11 && pos11 == pos02) {
			return true;
		} else {
			return false;
		}
	}

	private boolean verificaColuna() {
		if (pos00 == pos10 && pos10 == pos20) {
			return true;
		} else if (pos01 == pos11 && pos11 == pos21) {
			return true;
		} else if (pos02 == pos12 && pos12 == pos22) {
			return true;
		} else {
			return false;
		}
	}

	private boolean verificaLinha() {
		if (pos00 == pos01 && pos01 == pos02) {
			return true;
		} else if (pos10 == pos11 && pos11 == pos12) {
			return true;
		} else if (pos20 == pos21 && pos21 == pos22) {
			return true;
		} else {
			return false;
		}
	}

}
