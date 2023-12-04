package principal;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Jogo jogo = new Jogo();

		int escolha = 1;

		while (escolha != 2) {
			System.out.println("MENU");
			System.out.println("1 - Jogar");
			System.out.println("2 - Sair");
			escolha = sc.nextInt();
			if (escolha == 1) {
				System.out.print("Digite o nome do(a) jogador(a) 1 : ");
				String nome1 = sc.next();
				Jogador jogador1 = new Jogador(nome1);
				System.out.print("Digite o nome do(a) jogador(a) 2 : ");
				String nome2 = sc.next();
				Jogador jogador2 = new Jogador(nome2, jogador1.getSimbolo());
				System.out.println("\n===============");
				System.out.println(nome1 + " vai ser: " + jogador1.getSimbolo());
				System.out.println(nome2 + " vai ser: " + jogador2.getSimbolo());
				System.out.println("===============\n");
				jogo.jogar(jogador1, jogador2);
				System.out.println();
			} else if (escolha == 2) {
				System.out.println("FIM");
			} else {
				System.out.println("Digite um número valido");
				escolha = 3;
			}
		}

		sc.close();
	}

}
