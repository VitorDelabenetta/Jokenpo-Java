package pessoal.game;
import java.util.Scanner;
import java.util.Random;

public class Jokenpo {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		// INTRODUÇÃO
		System.out.println("L O R E");
		System.out.println("Máquinas horrendas dominam o planeta. \nUm vírus do espaço profundo parece ter se disseminado pela World Wide Web e infectado todas as máquinas.\nA humanidade não tem esperança...\n");
		System.out.println("Até que, por algum milagre, você surge e desafia o terrível vírus para uma batalha sangrenda de JoKenPô. \nEle aceita seu desafio, misteriosamente... ");
		System.out.println("Agora, o mundo está em suas mãos. Faça as escolhas corretas e ganhe o jogo.");
		
		System.out.println("\n_____.._____\n");	
		System.out.println("Máquina diz: [voz robótica maligna]\n\"Você terá 5 turnos para jogar\"");
		System.out.println("\n. . . . .");
		System.out.println("\nVocê poderá selecionar entre as seguintes opções:");
		System.out.println("\nPedra | Papel | Tesoura\n\n");
		
		// JOGO
		byte turno = 0;
		int pontos = 0;
		
		do {	
			turno++;	
			
			System.out.print("Escreva a opção que desejar: ");
			String escolha = leitor.nextLine();
	
			if (escolha.equalsIgnoreCase("pedra") || escolha.equalsIgnoreCase("papel") || escolha.equalsIgnoreCase("tesoura")) {
							
				String oponente = oponente(random());
				System.out.println("Seu oponente digitou: " + oponente);
				
				// TURNO
				System.out.println("\nO resultado do turno foi: ");
				
				if (oponente.equalsIgnoreCase("Não consegui escolher")) {
					System.out.println("Usuário estava indeciso. Tente novamente");
					turno --;
				}
				else if (escolha.equalsIgnoreCase(oponente)) {
					System.out.println("Empate!");
					turno --;
				}
				else if (isVencedor(escolha, oponente)) {
					System.out.println("Você venceu!");
					pontos = (pontos + 1);
				}
				else
					System.out.println("O oponente venceu \n\n[risadas malignas]");
			} 
			
			else {
				System.out.println("\nDigite uma opção válida");
				turno --;
			}
			
			System.out.println("\n_____.._____\n");
			
		} while (turno != 5);
		
		// RESULTADO
		System.out.println("Fim do jogo!");
		
		String resultado = (pontos == 1) ? "Você ficou com 1 ponto" : "Você ficou com " + pontos + " pontos";
		System.out.println(resultado);
		
		if (pontos >= 3)
			System.out.println("\nVocê não deixou as máquinas dominarem o planeta, você venceu! O Vírus se deletou. Tudo terminou bem.");
		else
			System.out.println("\nVocê lutou bravamente, mas perdeu. As máquinas, comandadas pelo Vírus maligno, aniquilaram a humanidade.");
		
		leitor.close();

	}

	public static int random() {
		Random gerador = new Random();

		int numero = gerador.nextInt(100);

		return numero;

	}

	public static String oponente(int numero) {

		String resposta = "Não consegui escolher";
		// Adicionei essa resposta que terá uma baixa chance de ocorrer (apenas se numero = 100)

		if (numero < 33)
			resposta = "Pedra";
		else if (numero >= 33 && numero < 66)
			resposta = "Papel";
		else if (numero >= 66 && numero <= 99)
			resposta = "Tesoura";

		return resposta;

	}
	
	public static boolean isVencedor (String jogador, String oponente) {
		
		// Perdeu
		if (jogador.equalsIgnoreCase("Pedra") && oponente == "Papel" || jogador.equalsIgnoreCase("Papel") && oponente == "Tesoura" || jogador.equalsIgnoreCase("Tesoura") && oponente == "Pedra")
			return false;
		
		// Venceu
		return true;
		
	}
}