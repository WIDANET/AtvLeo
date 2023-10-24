package application;

import java.util.Locale;
import java.util.Scanner;

import entites.Candidato;

public class program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Seja bem-vindo(a) à urna eletrônica.");
		System.out.println();
		System.out.println("Escolha uma dentre as seguintes opções: ");
		System.out.println("1 p/ testar o programa, 2 p/ cadastrar candidato");
		System.out.print("Digite uma opção: ");
		int opc = sc.nextInt();
		sc.nextLine();
		
		if (opc == 1) {
			System.out.println();
			System.out.println("Inicializando testador de programa...");
			System.out.println();
			
			System.out.print("Digite o nome do candidato: ");
			String nome = sc.nextLine();
			
			System.out.print("Digite o número do candidato: ");
			int cod = sc.nextInt();
			Candidato candidato = new Candidato(nome, cod);
			candidato.setVotes(1);
			System.out.println();
			
			System.out.println("O candidato " + candidato.getName() + " (" + candidato.getCod() + ")" + " teve: " + candidato.getVotes() + " voto.");
		}
		else if (opc == 2) {
			
			System.out.println();
			System.out.print("Digite a quantidade de candidatos que serão cadastrados: ");
			int qntdCand = sc.nextInt();		
			sc.nextLine();
			
			Candidato [] vect = new Candidato[qntdCand];
			for(int i = 0; i < vect.length; i++) {
				
				int count = i + 1;
				System.out.println("Digite os dados do candidado " + count + ": ");
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Número: ");
				int cod = sc.nextInt();
				sc.nextLine();
				vect[i] = new Candidato(nome, cod);
			}
			
			System.out.println();
			System.out.print("Digite a quantidade de eleitores que irão votar: ");
			int qntdE = sc.nextInt();
			
			System.out.println();
			for(int i=0; i<qntdE; i++) {
				System.out.print("Digite o número do candidato que você está votando: ");
				int numVote = sc.nextInt();
				for(Candidato candidato : vect) {
					if(candidato.getCod() == numVote) {
						candidato.setVotes(1);
					}
				}
			}
			
			Candidato vencedor = null;
			
			System.out.println();
			System.out.println("----- RESULTADO DAS ELEIÇÕES ----- ");
			System.out.println();
			for(Candidato candidato : vect) {
				System.out.println("O candidato " 
						+ candidato.getName() + ", de número " 
						+ candidato.getCod() + ", teve um total de: " 
						+ candidato.getVotes() + " votos.");
				
				if (vencedor == null || candidato.getVotes() > vencedor.getVotes()) {
					vencedor = candidato;
				}
			}
			System.out.println();
			System.out.println("O candidato vencedor é: " 
			+ vencedor.getName() 
			+ " " + vencedor.getCod() 
			+ ", com um total de " + vencedor.getVotes() 
			+ " votos!" );
		}
		sc.close();
	}

}
